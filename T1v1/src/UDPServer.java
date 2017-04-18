import java.io.IOException;
import java.net.*;
import java.util.*;

public class UDPServer{
    /**
     * The port where the client is listening.
     */
	byte[] dado = new byte[100];
	Pilha stack = new Pilha();
    private final int clientPort;
    public UDPServer(int clientPort) {
        this.clientPort = clientPort;
    }
    
    public void produtor(){   	    
	    for(int i=0; i<100; i++){
			Random rn = new Random();
			
			Integer num = (rn.nextInt(32767) + 1);
			stack.push(num);
	    }
    }
    
    
    //@Override
    public void run() throws SocketException {

    	DatagramSocket serverSocket = new DatagramSocket(2020);
    	while(true){
	        try {

                DatagramPacket datagramPacket = new DatagramPacket(dado, 100);
                serverSocket.receive(datagramPacket);
	                
                DatagramPacket data = new DatagramPacket(dado, dado.length);
                serverSocket.send(datagramPacket);
	            
                String m = new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength());
                System.out.println(m);
                
                Process proc = new Process(stack, datagramPacket.getPort(), datagramPacket.getAddress());

                Thread t = new Thread(proc);
                t.start();
	                
                // Wait 2 ms before sending the next message
                //serverSocket.close();
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