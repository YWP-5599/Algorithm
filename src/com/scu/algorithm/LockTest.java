package com.scu.algorithm;

import java.util.concurrent.*;

public class LockTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    result +=i;
                }
                return result;
            }
        });
        Thread computerThread = new Thread(futureTask);
        computerThread.start();
        Thread otherThread = new Thread(()->{
            System.out.println("other thread is runnung!");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
    }
}
