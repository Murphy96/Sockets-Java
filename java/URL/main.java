import java.net.*;
import java.io.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		      // Constructor
		      URL direccion = new URL("https://github.com/Murphy96/Sockets-Java");
		      // Divide las diferentes partes de una URL
		      System.out.println("El protocolo utilizado es: " + direccion.getProtocol());
		      System.out.println("El host es: " + direccion.getHost());
		    } catch (MalformedURLException e) {
		    System.out.println("Error en la construccion de la URL");
		    }
		  }

	

}
