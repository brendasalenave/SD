import java.io.*;
import java.net.*;

public class Consumidor {
	static int porta = 6789;
	
    public static void main(String[] args) throws IOException {
    	int somatorio = 0;
    	
    	while(true){
	    	byte[] dado = new byte[100];
	    	InetAddress ip = InetAddress.getByName("localHost");
	    	Socket socket = new Socket(ip, porta); // criação do endpoint
	    	
	    	// ligação de streams de entrada e saida
	    	BufferedOutputStream buffOut = new BufferedOutputStream(socket.getOutputStream());
	    	BufferedInputStream buffIn = new BufferedInputStream(socket.getInputStream());
	    	
	    	//System.out.println("Enviando solicitação ao servidor");
	    	buffOut.write(dado, 0, dado.length);
	    	buffOut.flush();

	    	// receber resposta e extrair valor
	    	dado = new byte[100];
	    	int bytesLidos = buffIn.read(dado, 0, dado.length);
	    	String valor = new String(dado, 0, bytesLidos);
	    	int valorInteiro = Integer.parseInt( valor.trim() );
	    	if(valorInteiro == 0){
	    		System.out.println("Somatorio: " + somatorio);
	    		socket.close();
	    		break;
	    	}
	    	somatorio += valorInteiro;
    	} 
    }
}
