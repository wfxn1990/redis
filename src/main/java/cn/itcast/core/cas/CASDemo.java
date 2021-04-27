package cn.itcast.core.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo {
    public static void main(String[] args) {
        /*AtomicInteger atomicInteger = new AtomicInteger(2020);
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());*/
        AtomicStampedReference<Integer> actomicInteger = new AtomicStampedReference<>(2020, 1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a"+actomicInteger.getStamp());
            }
        },"a").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a"+actomicInteger.getStamp());
            }
        },"b").start();
    }
}
