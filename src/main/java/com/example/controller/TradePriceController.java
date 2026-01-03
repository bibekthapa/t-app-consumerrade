package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.entity.TradeEntity;
import com.example.service.TradePriceService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/trade")
@RestController
public class TradePriceController {
    
    private final TradePriceService tradePriceService;

    public TradePriceController(TradePriceService tradePriceService) {
        this.tradePriceService = tradePriceService;
    }

    

    @GetMapping("/prices")
    public ResponseEntity<?> getMethodName(@RequestParam String symbol) {
        List<TradeEntity> trades = tradePriceService.getPrices(symbol);
        boolean hasTrades = Optional.ofNullable(trades).map(list -> !list.isEmpty()).orElse(false);
        if(!hasTrades){return ResponseEntity.noContent().build();}
        return ResponseEntity.ok(trades);
    }

     @GetMapping("/allPrices")
    public ResponseEntity<?> getMethodName() {
        List<TradeEntity> trades = tradePriceService.getPrices();
        boolean hasTrades = Optional.ofNullable(trades).map(list -> !list.isEmpty()).orElse(false);
        if(!hasTrades){return ResponseEntity.noContent().build();}
        return ResponseEntity.ok(trades);
    }
    
}
