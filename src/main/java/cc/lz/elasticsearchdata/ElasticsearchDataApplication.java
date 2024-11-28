package cc.lz.elasticsearchdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ElasticsearchDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchDataApplication.class, args);
    }

}
