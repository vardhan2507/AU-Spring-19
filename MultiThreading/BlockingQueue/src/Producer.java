import java.util.concurrent.BlockingQueue;
public class Producer implements Runnable {

    private BlockingQueue<Item> queue;
    private String[] items;
    
    public Producer(BlockingQueue<Item> q){
        this.queue=q;
        this.items=new String[] {
        		"Oneplus 6T","Nokia 6.1 Plus","Google Pixel XL 2","Oppo F9 Pro","Vivo V12",
        		"Redmi Note 6 Pro","RealMe 2 Pro","Mi A2","10 or G","iPhone"
        };
        
    }
    @Override
    public void run() {
        
        for(int i=0; i<10; i++){
            Item msg = new Item(items[i]);
            try {
           
                queue.put(msg);
                System.out.println("Produced produced: "+msg.getItem());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        Item msg = new Item("stop");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}