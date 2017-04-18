import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Processamento implements Runnable{
	private Pilha stack;
	private int porta;
	private InetAddress ip;
	private Socket skt;

	public Processamento (Pilha stack, Socket skt){
		this.skt = skt;
		this.stack = stack;
	}
	
	@Override
	public void run(){
		
		// ligação de streams de entrada e saida
		ObjectOutputStream buffOut;
		ObjectInputStream buffIn = null;
		try {
			buffOut = new ObjectOutputStream(skt.getOutputStream());
			buffIn = new ObjectInputStream(skt.getInputStream());
			
			//System.out.println("Aguardando requisições...");
			byte[] dado = new byte[100];
			int bytesLidos = buffIn.read(dado, 0, dado.length);
			
			//System.out.println("Atendendo requisições...");
			// enviar resposta ao cliente
			int resposta = 0;
			if(!stack.vazia()){
				resposta = stack.pop();
				
				String s = String.valueOf(resposta);
				dado = s.getBytes();
				
				buffOut.write(dado, 0, dado.length);
				buffOut.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
}
