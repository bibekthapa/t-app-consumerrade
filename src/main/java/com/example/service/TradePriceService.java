package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.TradeRepository;
import com.example.entity.TradeEntity;

@Service
public class TradePriceService {


    @Autowired
    private TradeRepository tradeRepository;

    public List<TradeEntity> getPrices(String symbol){
        
        return tradeRepository.findByTradeId(symbol);
    }

    public List<TradeEntity> getPrices(){
        return tradeRepository.findAll();
    }
    
}
