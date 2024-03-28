package com.example.dataanalysermicroservice.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static reactor.core.publisher.Mono.when;

class LocalDataTimeDeserializerTest {


    @Mock
    Type type;
    @Mock
    JsonDeserializationContext context;

    @Test
    void TestDeserialize() {

        JsonElement jsonElement = Mockito.mock(JsonElement.class);

        JsonArray jsonArray = new JsonArray();
        jsonArray.add(2024);
        jsonArray.add(3);
        jsonArray.add(28);
        jsonArray.add(12);
        jsonArray.add(12);
        jsonArray.add(12);

        LocalDateTime localDateTime = LocalDateTime.of(2024, 3,28, 12,12,12);

        Mockito.when(jsonElement.getAsJsonArray()).thenReturn(jsonArray);
        LocalDataTimeDeserializer deserializer = new LocalDataTimeDeserializer();
        LocalDateTime actual = deserializer.deserialize(jsonElement, type, context);
        Assertions.assertEquals(localDateTime, actual);
    }
}