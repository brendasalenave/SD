import java.util.concurrent.BlockingQueue;


public class DataStackProcessor implements Runnable {
    private final BlockingQueue<byte[]> messageQueue;
    public DataStackProcessor(BlockingQueue<byte[]> messageQueue) {
        this.messageQueue = messageQueue;
    }
    
    @Override
    public void run() {
        int counter = 0;
        while (true){
            try {
                /**
                 * Try and take a message from the queue. Will block if the
                 * message queue is empty, until an element becomes available.
                 */
                byte[] rawData = this.messageQueue.take();
                // recuperação de uma cadeia de caracteres a partir da cadeia de bytes
                String valor = new String(rawData);
                counter++;
                System.out.println("Message: " + valor);
                /**
                 * Simulate a 3 ms delay
                 */
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}