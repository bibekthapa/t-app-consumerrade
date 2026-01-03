package com.example.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.TradeEntity;
import java.util.List;



public interface TradeRepository extends JpaRepository<TradeEntity,Long>{

    List<TradeEntity> findByTradeId(String tradeId);
   
}
