package cn.itcast.core;

import java.util.concurrent.atomic.AtomicInteger;

public class testctomic {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(5);
        System.out.println(i.updateAndGet(value ->value*10));
    }
}
