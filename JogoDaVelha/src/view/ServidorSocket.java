package view;

import java.io.IOException;
import java.net.ServerSocket;

public class ServidorSocket {
	
	
	public static void main(String[] args) {
		ServerSocket servidor=null;
		try {
			servidor = new ServerSocket();
		} catch (IOException e) {
			try {
				if(servidor!=null)
					servidor.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.err.print("Porta ocupada ou o servidor foi fechado");
			e.printStackTrace();
		}
	}
}
