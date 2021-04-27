package cn.itcast.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class testArrayList {
    public static void main(String[] args) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();

//        Vector list = new Vector<>();
//        List list = new ArrayList();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    list.add(i);
                }
                System.out.println(list);
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 30; i < 60; i++) {
                    list.add(i);
                }
                System.out.println(list);
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 60; i < 90; i++) {
                    list.add(i);
                }
                System.out.println(list);
            }
        },"C").start();
    }
}
