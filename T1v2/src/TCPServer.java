import java.io.*;
import java.net.*;
import java.util.Random;

public class TCPServer {
	Pilha stack = new Pilha();
	// cria endpoint na porta 2020

	Socket skt;// = null;
	
    public void produtor(){   	    
	    for(int i=0; i<100; i++){
			Random rn = new Random();
			
			Integer num = (rn.nextInt(32767) + 1);
			stack.push(num);
	    }
    }
	
    public void run() throws IOException{
    	ServerSocket socket = new ServerSocket(50001);
    	
		while (true) {
			try{
			// aguarda solicitação de conexão
			skt = socket.accept();
			// ligação de streams de entrada e saída
			BufferedOutputStream buffOut = new BufferedOutputStream(skt.getOutputStream());
			BufferedInputStream buffIn = new BufferedInputStream(skt.getInputStream());
			// aguarda solicitação de serviço
			byte[] dado = new byte[100];
			int bytesLidos = buffIn.read(dado, 0, dado.length);
			// enviar resposta ao cliente
			//dado = resposta.getBytes();
			buffOut.write(dado, 0, dado.length);
			buffOut.flush();
			
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
