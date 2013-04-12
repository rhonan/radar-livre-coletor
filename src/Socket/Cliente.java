package Socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Cliente {

	public static void main(String[] args) throws Exception{
		System.out.println("Iniciando cliente...");
		
		System.out.println("Iniciando conex�o com o servidor...");
		
		Socket socket = new Socket("192.168.1.108",30003);
		
		System.out.println("Conex�o estabelecida.");
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);
		
		
		
		while(true){
			String mensagem = in.readLine();
			String[] mensagem_quebrada = mensagem.split(Pattern.quote(","));
			
			int mensagens = 1;
			
			switch(mensagens)
			
			{
			
			case 1:  
				
			
			}
			
			for(int i=0; i< mensagem_quebrada.length; i++){
			System.out.println(
					"Mensagem recebida do servidor[" + socket.getInetAddress().getHostName() +
					"]: " +
					mensagem_quebrada[i]);
			}
			
			if("FIM".equals(mensagem)){
				break;
			}
			
		//	mensagem = in.readLine();
			
		//	System.out.println(
		//			"Mensagem recebida do servidor: " +
		//			mensagem);
		}
		
		System.out.println("Encerrando conex�o...");
		
		in.close();
		
		out.close();
		
		socket.close();
		
	}
}