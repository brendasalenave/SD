import java.io.IOException;
import java.net.*;
import java.util.*;
//import java.util.concurrent.BlockingQueue;
public class UDPServer implements Runnable {
    /**
     * The port where the client is listening.
     */
    private final int clientPort;
    public UDPServer(int clientPort) {
        this.clientPort = clientPort;
    }
    @Override
    public void run() {
        /**
         * Create a new server socket and bind it to a free port. I have chosen
         * one in the 49152 - 65535 range, which are allocated for internal applications
         */
        try (DatagramSocket serverSocket = new DatagramSocket(50000)) {
            // The server will generate 10000 messages and send them to the client
            // Each message will be sent at a 2 ms interval
            for (int i = 0; i < 10000; i++) {
            	Random rn = new Random();
           	    int num = rn.nextInt(32767) + 1;
	           	// transformação de valor inteiro para String
	           	String message = Integer.toString(num);
            	
                DatagramPacket datagramPacket = new DatagramPacket(
                        message.getBytes(),
                        message.length(),
                        InetAddress.getByName("192.168.108.128"),
                        clientPort
                );
                serverSocket.send(datagramPacket);
                // Wait 2 ms before sending the next message
                Thread.sleep(20000);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public class Pilha{
    	
        private Stack stack;

		public Pilha(Stack p) {
            this.stack = p;
        }
    	
	    //Stack stack;
	    public synchronized void push(short valor){
	    	
	    }
	    
	    public synchronized short pop(){
	      	return (short) stack.pop();
	    }
    }
}