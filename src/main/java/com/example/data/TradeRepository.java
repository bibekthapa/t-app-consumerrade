package com.example.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.TradeEntity;


public interface TradeRepository extends JpaRepository<TradeEntity,Long>{
   
}
