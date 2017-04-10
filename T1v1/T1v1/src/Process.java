import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Process implements Runnable{
	Pilha stack;
	int porta;
	InetAddress ip;

	
	public Process (Pilha stack, int porta, InetAddress ip){
		this.stack = stack;
		this.porta = porta;
		this.ip = ip;
	}
	
	@Override
	public void run(){
		byte[] dado; 
		
		int d = stack.pop();
		String s = String.valueOf(d);
		
		dado = s.getBytes();
		DatagramSocket ds;
		try {
			ds = new DatagramSocket();
			DatagramPacket dp = new DatagramPacket(dado, dado.length, ip, porta);			
			ds.send(dp);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
