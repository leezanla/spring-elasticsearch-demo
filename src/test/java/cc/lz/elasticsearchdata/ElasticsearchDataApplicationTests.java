package cc.lz.elasticsearchdata;

import cc.lz.elasticsearchdata.domain.entity.HotelDoc;
import cc.lz.elasticsearchdata.domain.repository.es.EsHotelRepository;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class ElasticsearchDataApplicationTests {

    @Resource
    private EsHotelRepository esHotelRepository;

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    void contextLoads() {
        List<HotelDoc> hotelDocList = esHotelRepository.findAllByBrand("7天酒店");
        hotelDocList.forEach(System.out::println);
    }

    @Test
    void test1() {
        QueryBuilder query = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("brand", "如家"))
                .must(QueryBuilders.matchQuery("name", "如家"))
                .mustNot(QueryBuilders.rangeQuery("price")
                        .gt(400))
                .filter(QueryBuilders.geoDistanceQuery("location")
                        .point(31.21, 121.5)
                        .distance("10", DistanceUnit.KILOMETERS));
        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(query)
                .withHighlightBuilder(
                        new HighlightBuilder().field("name")
                                .preTags("<em>")
                                .postTags("</em>"))
                .build();
        List<HotelDoc> hotelDocs = elasticsearchRestTemplate.search(searchQuery, HotelDoc.class)
                .getSearchHits()
                .stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
        List<SearchHit<HotelDoc>> searchHits = elasticsearchRestTemplate.search(searchQuery, HotelDoc.class)
                .getSearchHits();
        searchHits.forEach(hit -> System.out.println(hit.getHighlightField("name")));
    }
}
