package com.example.restapi.service;

import com.example.restapi.model.AssetDataModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CounterServiceTest {

    @Autowired
    private SequenceGeneratorService counterService;

    @Test
    public void testGetNextSequence() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                long sequence = counterService.generateSequence(AssetDataModel.SEQUENCE_NAME);
                System.out.println(sequence);
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

}
