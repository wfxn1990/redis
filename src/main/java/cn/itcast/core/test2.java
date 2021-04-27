package cn.itcast.core;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class test2 {
    public static class Mythread implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("osidjfoj");
            return 1024;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Mythread());
        new Thread(futureTask, "A").start();
        System.out.println(futureTask.get());
    }
}
