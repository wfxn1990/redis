package cn.itcast.core;

import java.util.concurrent.atomic.AtomicInteger;

public class test14 {
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add() {
        num.addAndGet(1);
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();

                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(num);
    }
}
