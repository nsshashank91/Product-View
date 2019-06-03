package com.wipro.productView.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.wipro.productView.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String,Product> producerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(config);
    }

    @Bean
    public KafkaTemplate<String, Product> kafkaTemplate(){
        return new KafkaTemplate<String, Product>(producerFactory());
    }
    
    
    @Bean
    @Scope("prototype")
    Product getProduct() {
    	return new Product();
    }
    
    @Bean
    @Scope("prototype")
    Random getRandomInstance() {
    	return new Random();
    }
}
