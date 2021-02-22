/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linhard.kaindorf._plf.pojo.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author martin
 */
public class JsonUserDeserializer extends StdDeserializer<LocalDate>{
    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public JsonUserDeserializer() {
        super(LocalDate.class);
    }
    
    
    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        return LocalDate.parse(jp.readValueAs(String.class), DTF);
    }
}
