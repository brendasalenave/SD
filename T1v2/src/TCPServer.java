import java.io.*;
import java.net.*;
import java.util.Random;

class TCPServer{
	private static ServerSocket socket;

	public static void main(String argv[]) throws Exception {

		Pilha stack = new Pilha();
		socket = new ServerSocket(6789);
		
   	    stack.push(0);
   	    stack.push(0);
   	    stack.push(0);
	    stack.push(0);
   	    for(int i=0; i<100; i++){
   			Random rn = new Random();
    			
   			Integer num = (rn.nextInt(32767) + 1);
   			stack.push(num);
   	    }

	
		while(true){
			try{
				//System.out.println("Aguardando solicitação de conexão...");
				Socket skt = socket.accept();
											
				Process proc = new Process(stack, skt);
                Thread t = new Thread(proc);
				t.start();
				
				//skt.close();
			} catch (SocketException e) {
	            e.printStackTrace();
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}
	
}