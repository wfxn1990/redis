package cn.itcast.core;

import java.sql.SQLOutput;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer> {
    private static final Integer ADJUST_VALUE = 10;
    private int begin;
    private int end;
    private int result;

    MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - begin) <= ADJUST_VALUE) {
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        } else {
            int middle = (end + begin)/2;
            MyTask task01 = new MyTask(begin, middle);
            MyTask task02 = new MyTask(middle+1, end);
            task01.fork();
            task02.fork();
            result = task01.join() + task02.join();
        }

        return result;
    }
}

public class test10 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0, 100);
        ForkJoinPool f1 = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = f1.submit(myTask);
        System.out.println(forkJoinTask.get());
        f1.shutdown();
    }




}
