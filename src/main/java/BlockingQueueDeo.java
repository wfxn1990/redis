import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDeo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        System.out.println(blockingQueue.add("a"));
        String element = blockingQueue.element();
        System.out.println(element);
        System.out.println(blockingQueue.take());
    }
}
