package com.scu.algorithm;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {
    private AtomicInteger cnt = new AtomicInteger();
    public void add(){
       cnt.incrementAndGet();
    }
    public int get(){
        return cnt.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ProducerConsumer producerConsumer = new ProducerConsumer();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(()->{
                producerConsumer.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(producerConsumer.get());
    }
}
