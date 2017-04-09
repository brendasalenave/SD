import java.io.*;
import java.net.*;
import java.util.*;

public class Consumidor {
  public static void main(String[] args) {
    try{
      byte[] dado = new byte[256];
      InetAddress ip = InetAddress.getByName("192.168.108.128");
                                                                    //"ip, porta"
      DatagramPacket pacoteEnvio = new DatagramPacket(dado, dado.length, ip, 50001);
      DatagramSocket socket = new DatagramSocket(); // criação do endpoint
      socket.send(pacoteEnvio);
      DatagramPacket pacoteRecebido = new DatagramPacket(dado, dado.length);
      socket.receive(pacoteRecebido);
      dado = pacoteRecebido.getData();
      String valor = new String(pacoteRecebido.getData());
      int valorInteiro = Integer.parseInt( valor.trim() );
      //somatorio += valorInteiro;
    } catch(Exception e){
      System.out.println("Erro");
    }
  }
}
