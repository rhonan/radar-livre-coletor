package Util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[]  args) throws Exception {
		System.out.println("Iniciando servidor...");
		
		ServerSocket server = new ServerSocket(30003);
		
		System.out.println("Aguardando conex‹o...");
		
		Socket socket = server.accept();
		
		System.out.println("Conex‹o estabelecida.");
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream	out = new PrintStream(output);
		
		while(true){
			String mensagem = in.readLine();
			
			System.out.println(
					"Mensagem recebida do cliente[" + socket.getInetAddress().getHostName() +
					"]: " +
					mensagem);
			
			if("FIM".equals(mensagem)){
				break;
			}
			
			out.println(mensagem);
		}
		
		System.out.println("Encerrando conex‹o.");
		
		in.close();
		
		out.close();
		
		socket.close();
		
		System.out.println("Encerrando servidor.");
		
		server.close();
	}
}