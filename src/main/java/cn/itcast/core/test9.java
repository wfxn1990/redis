package cn.itcast.core;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class test9 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*CompletableFuture<Void> completableFuture =CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
        });
        System.out.println("1111111");
        completableFuture.get();*/
        CompletableFuture<Integer> completableFuture =CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println(Thread.currentThread().getName()+"sldfldsf");
                return 1024;
            }
        });
        System.out.println(completableFuture.whenComplete((t,u)->{
            System.out.println("t=>" + t);

        }).exceptionally((e)->{
            System.out.println(e.getMessage());
            return 2333;
        }).get());
    }
}
