package com.edu.virtualschool.cofig;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/25 - 10 - 25 -15:48
 */
//public class ElasticsearchConfig {
//    RestHighLevelClient elasticsearchClient() {
//        ClientConfiguration configuration = ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                //.withConnectTimeout(Duration.ofSeconds(5))
//                //.withSocketTimeout(Duration.ofSeconds(3))
//                //.useSsl()
//                //.withDefaultHeaders(defaultHeaders)
//                //.withBasicAuth(username, password)
//                // ... other options
//                .build();
//        RestHighLevelClient client = RestClients.create(configuration).rest();
//        return client;
//    }
//}
