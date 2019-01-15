import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClass {

	public static void main(String[] args) {
        
        BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);      
        new Thread(producer).start();
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }
}
