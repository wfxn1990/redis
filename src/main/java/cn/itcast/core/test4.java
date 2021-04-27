package cn.itcast.core;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class  test4 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("召唤神龙");

            }
        });
        for (int i = 0; i < 8; i++) {
            final int tempInt = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + tempInt);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }, String.valueOf(i)).start();
        }
    }
}
