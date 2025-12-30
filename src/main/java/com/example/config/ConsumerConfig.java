package com.example.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.example.Trade;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

@Configuration

public class ConsumerConfig {


    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServers;

   

    public Map<String,Object> propertiesMap(){

        Map<String,Object> propMap = new HashMap<>();
        propMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        propMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        propMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        propMap.put("schema.registry.url" , "http://localhost:8081");
        propMap.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG , true);
        return  propMap;      
    }


    @Bean
    public ConsumerFactory<String,Trade> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(propertiesMap());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Trade> kafkaListenerContainerFactory(){

        ConcurrentKafkaListenerContainerFactory<String,Trade> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;

    }
    

}
