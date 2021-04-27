package cn.itcast.core;

import java.util.concurrent.*;

public class test7 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2,5,2L
        , TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 1; i <= 10; i++) {
                threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()+"\t办理业务"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
