/**
 * @author leezan
 * @Data 2024/11/28 15:52
 */
package cc.lz.elasticsearchdata.domain.repository.es;

import cc.lz.elasticsearchdata.domain.entity.HotelDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsHotelRepository extends ElasticsearchRepository<HotelDoc, Long> {

    List<HotelDoc> findAllByBrand(String brand);
}
