import java.io.*;
import java.net.*;
import java.util.*;

public class Consumidor {
	static String servidor = "127.0.0.1";
	static int porta = 2020;
        int somatorio = 0;

  public static void main(String[] args) throws IOException {
    //try{
      byte[] dado = new byte[100];
      InetAddress ip = InetAddress.getByName("localHost");
      DatagramPacket pacoteEnvio = new DatagramPacket(dado, dado.length, ip, porta);
      DatagramSocket socket = new DatagramSocket(); // criação do endpoint
      
      socket.send(pacoteEnvio);
      
      DatagramPacket pacoteRecebido = new DatagramPacket(dado, 100);
     
      socket.receive(pacoteRecebido);
      //System.out.println(pacoteRecebido);
      
      String m = new String(pacoteRecebido.getData(), pacoteRecebido.getOffset(), pacoteRecebido.getLength());
      dado = pacoteRecebido.getData();
      //String valor = new String(pacoteRecebido.getData());
      //System.out.println(m);
      //int valorInteiro = Integer.parseInt(m);
      System.out.println(pacoteRecebido.getData().toString());
      String valor = new String(pacoteRecebido.getData());
      int valorInteiro = Integer.parseInt(valor.trim());
      System.out.println("Mensagem: " + valorInteiro);
      //somatorio += valorInteiro;
    //} catch(Exception e){
    //  System.out.println("Erro");
    //}
  }
}
