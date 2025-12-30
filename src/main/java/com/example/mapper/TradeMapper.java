package com.example.mapper;

import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.Price;
import com.example.Time;
import com.example.Trade;
import com.example.entity.TradeEntity;

import java.io.*;

@Mapper(componentModel = "spring")
public interface TradeMapper {


    @Mapping(target ="id",ignore = true)
    @Mapping(target = "tradeId", source = "tradeId")
    @Mapping(target = "tradeType", source = "tradeType")

    @Mapping(target = "priceCurrent", source = "price.current")
    @Mapping(target = "priceOpen", source = "price.open")
    @Mapping(target = "priceHigh", source = "price.high")
    @Mapping(target = "priceLow", source = "price.low")
    @Mapping(target = "priceVolume", source = "price.volume")
    @Mapping(target = "priceClose", source = "price.close")
    @Mapping(target = "timestampEpochMillis", expression = "java(avro.getTimestamp() != null ? avro.getTimestamp().getEpochMillis() : null)")
    //@Mapping(target = "avroData", expression = "java(serializeAvro(avro))")
    TradeEntity avroToEntity(Trade avro);

    default String map(CharSequence value) {
        return value == null ? null : value.toString();
    }

    default Trade entityToAvro(TradeEntity entity){

        Price price = Price.newBuilder()
            .setClose(entity.getPriceClose())
            .setCurrent(entity.getPriceCurrent())
            .setHigh(entity.getPriceHigh())
            .setLow(entity.getPriceLow())
            .setOpen(entity.getPriceOpen())
            .setVolume(entity.getPriceVolume()).build();

        Trade.Builder builder = Trade.newBuilder()
            .setTradeId(entity.getTradeId())
            .setPrice(price)
            .setTradeType(entity.getTradeType());

        Time time = null;
        if(entity.getTimestampEpochMillis() != null){
            time = Time.newBuilder().setEpochMillis(entity.getTimestampEpochMillis()).build();
        }

        if(time != null) builder.setTimestamp(time);
        return builder.build();
        
        
    }

    default Trade deserializeAvro(byte[] data){

    try{
        DatumReader<Trade> reader = new SpecificDatumReader<>(Trade.class);
       Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);
       return reader.read(null, decoder);
    }catch(IOException e){
        throw new RuntimeException(e);
    }
    }

    

    
}
