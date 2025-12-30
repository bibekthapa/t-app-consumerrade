package com.example.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.Trade;
import com.example.data.TradeRepository;
import com.example.entity.TradeEntity;
import com.example.mapper.TradeMapper;

@Service
public class ConsumerService {

   private final TradeMapper mapper;
   private final TradeRepository tradeRepo;

    public ConsumerService(TradeMapper mapper, TradeRepository tradeRepo) {
        this.mapper = mapper;
        this.tradeRepo = tradeRepo;
    }

   

    @KafkaListener(topics = "randomprice", groupId = "test", containerFactory = "kafkaListenerContainerFactory")
    public void getMessage(ConsumerRecord<String,Trade> record) {
        
        Trade message1 = record.value();
        TradeEntity entity = mapper.avroToEntity(message1);
        tradeRepo.save(entity);
        System.out.println( message1.getPrice());
        
    }
    
    //    @KafkaListener(topics = "randomprice", groupId = "test" , containerFactory = "kafkaListenerContainerFactory" )
    // public void getMessage(Object message) {
    //     System.out.println(message.getClass());
        
    // }
    
}
