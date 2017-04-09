import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int port = 50001;
        /**
         * The initial capacity for the blocking collection needs to be fine tuned
         * based on your application requirements.
         */
        BlockingQueue<byte[]> messageQueue = new ArrayBlockingQueue<>(1200);
        UDPServer server = new UDPServer(port);
        // message queue is shared between UDP client and Data Processor
        UDPClient client = new UDPClient(port, messageQueue);
        DataStackProcessor dataProcessor = new DataStackProcessor(messageQueue);
        /**
         * Execute the components as 3 different threads
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(client);
        executorService.submit(server);
        executorService.submit(dataProcessor);
    }
}