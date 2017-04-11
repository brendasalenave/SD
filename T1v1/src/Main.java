import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {
    	byte[] dado = new byte[10];
    	Pilha stack = new Pilha();
        int porta = 2020;
        
   	    for(int i=0; i<100; i++){
   			Random rn = new Random();
    			
   			Integer num = (rn.nextInt(32767) + 1);
   			stack.push(num);
   	    }
    	
    	while(true){
	        try {
	            // The server will generate 10000 messages and send them to the client
	            // Each message will be sent at a 2 ms interval
	            //for (int i = 0; i < 10000; i++) {
        		DatagramSocket serverSocket = new DatagramSocket(2020);
           	    //String message = String.valueOf(stack.pop());
            	
        		System.out.println("Aguardando conexao");
                DatagramPacket datagramPacket = new DatagramPacket(dado, dado.length);
                serverSocket.receive(datagramPacket);
	            //System.out.println("Teste1");    
                DatagramPacket data = new DatagramPacket(dado, dado.length);
                serverSocket.send(datagramPacket);
	                
                Process proc = new Process(stack, datagramPacket.getPort(), datagramPacket.getAddress());
                Thread t = new Thread(proc);
                t.start();
	                
                // Wait 2 ms before sending the next message
                serverSocket.close();
                Thread.sleep(20000);            
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
    }
}
