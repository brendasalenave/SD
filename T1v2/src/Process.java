import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.*;

public class Process implements Runnable{
	private Pilha stack;
	private Socket skt;

	public Process (Pilha stack, Socket skt){
		this.skt = skt;
		this.stack = stack;
	}
	
	@Override
	public void run(){
		//byte[] dado1 = new byte[100]; 
		
		//int d = stack.pop();
		//String value = String.valueOf(d);
		
		//dado1 = value.getBytes();

		// ligação de streams de entrada e saida
		BufferedOutputStream buffOut;
		BufferedInputStream buffIn = null;
		try {
			buffOut = new BufferedOutputStream(skt.getOutputStream());
			buffIn = new BufferedInputStream(skt.getInputStream());
			
			//System.out.println("Aguardando requisições...");
			byte[] dado = new byte[100];
			int bytesLidos = buffIn.read(dado, 0, dado.length);
			
			//System.out.println("Atendendo requisições...");
			// enviar resposta ao cliente
			int resposta = 0;
			if(!stack.vazia()){
				resposta = stack.pop();
			}
			String s = String.valueOf(resposta);
			dado = s.getBytes();
			
			buffOut.write(dado, 0, dado.length);
			buffOut.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
}
