import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	
	private BlockingQueue<Item> queue;
	
	public Consumer(BlockingQueue<Item> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Item item;
            while((item = queue.take()).getItem() !="stop"){
            
            System.out.println("Consumer consumed: "+item.getItem());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
