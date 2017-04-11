import java.io.*;
import java.net.*;
import java.util.Random;

class TCPServer{
	public static void main(String argv[]) throws Exception {

		Pilha stack = new Pilha();
		ServerSocket socket = new ServerSocket(6789);
		
   	    for(int i=0; i<100; i++){
   			Random rn = new Random();
    			
   			Integer num = (rn.nextInt(32767) + 1);
   			stack.push(num);
   	    }
	
		while(true){
			System.out.println("Aguardando solicitação de conexão...");
			Socket skt = socket.accept();
			// ligação de streams de entrada e saada
			BufferedOutputStream buffOut = new BufferedOutputStream(skt.getOutputStream());
			BufferedInputStream buffIn = new BufferedInputStream(skt.getInputStream());
			
			System.out.println("Aguardando requisições...");
			byte[] dado = new byte[100];
			int bytesLidos = buffIn.read(dado, 0, dado.length);
			
			System.out.println("Atendendo requisições...");
			// enviar resposta ao cliente
			int resposta = stack.pop();
			String s = String.valueOf(resposta);
			dado = s.getBytes();
			
			buffOut.write(dado, 0, dado.length);
			buffOut.flush();
		}
	}
	
}