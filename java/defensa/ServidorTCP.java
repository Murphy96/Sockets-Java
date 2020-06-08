package tcp;

import java.io.*;
import java.net.*;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.tools.javac.Main;



public class ServidorTCP {  
	
  //static Logger bitaco = bitacora.getBitacora("tcp.bitacora","bitacora.txt",Level.FINE);
  private static Logger logger = Logger.getLogger(Main.class.getName());
  
  public static final int PORT = 4444;
  public static void main(String[] args) throws IOException {
    // Establece el puerto en el que escucha peticiones
    ServerSocket socketServidor = null;
    try {
      socketServidor = new ServerSocket(PORT);
      
    } catch (IOException e) {
      System.out.println("No puede escuchar en el puerto: " + PORT);
      System.exit(-1);
    }

    Socket socketCliente = null;
    BufferedReader entrada = null;
    PrintWriter salida = null;

    System.out.println("Escuchando: " + socketServidor);
    try {
    	
    	while(true) {
    		
    	 socketServidor.setSoTimeout(10*1000);	
    	 
	      // Se bloquea hasta que recibe alguna petición de un cliente
	      // abriendo un socket para el cliente
	      socketCliente = socketServidor.accept();
	      
	      System.out.println("Connexión acceptada: "+ socketCliente);
	      System.out.println(socketCliente.getPort());
	      
	      Date date = new Date();
	      //logger.info("fecha + "+date.getDate() + " hora "+date.getTime());
	      logger.info("puerto del servidor "+PORT);
	      logger.info("socket cliente (IP,PUERTO ): ["+socketCliente.getLocalAddress() + ", "+socketCliente.getPort()+"] ");
	      
	      // Establece canal de entrada
	      entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
	      // Establece canal de salida
	      salida = new PrintWriter(new BufferedWriter(new  OutputStreamWriter(socketCliente.getOutputStream())),true);
	      
	      
	      String str = entrada.readLine();
	      System.out.println("Cliente: " + str);
	      salida.println(" (IP,PUERTO) : [ "+socketCliente.getLocalAddress()+","+socketCliente.getPort()+"]");
	      
	      
	      
    	}

    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    }  
    try {
    	salida.close();
	    entrada.close();
	    socketCliente.close();
	    socketServidor.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
    
    
  }
}