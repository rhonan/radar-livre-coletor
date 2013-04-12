package Util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[]  args) throws Exception {
		System.out.println("Iniciando servidor...");
		
		ServerSocket server = new ServerSocket(30001);
		
		System.out.println("Aguardando conex�o...");
		
		Socket socket = server.accept();
		
		System.out.println("Conex�o estabelecida.");
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream	out = new PrintStream(output);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			
			System.out.print("Digite uma mensagem: ");
			String mensagem = scanner.nextLine();
			
			out.println(mensagem);
			
			
			
			if("FIM".equals(mensagem)){
				break;
			}
			
			
		}
		
		System.out.println("Encerrando conex�o.");
		
		in.close();
		
		out.close();
		
		socket.close();
		
		System.out.println("Encerrando servidor.");
		
		server.close();
	}
}