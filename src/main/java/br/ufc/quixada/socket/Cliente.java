package br.ufc.quixada.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.regex.Pattern;

import br.ufc.quixada.dao.ObservacaoDao;
import br.ufc.quixada.webservice.WebService;

public class Cliente {

	public static void main(String[] args) throws Exception{
		System.out.println("Iniciando cliente...");
		
		System.out.println("Iniciando conexão com o servidor...");
		
		Socket socket = new Socket("127.0.0.1",30003);
		
		System.out.println("Conexão estabelecida.");
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);
		
		while(true){
			String mensagem = in.readLine();
			String[] mensagem_quebrada = mensagem.split(Pattern.quote(","));
			
			switch(Integer.parseInt(mensagem_quebrada[1])){
			
				case 1:				
					/* Hex: mensagem_quebrada[4]
					 * Rota: mensagem_quebrada[5] */
					System.out.println("Case 1 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					ObservacaoDao.adicionarObservacao("null", "null", "null", "null", "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					WebService.enviarParaWS("null", "null", "null", "null", "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					break;
				case 2:
					/* Hex: mensagem_quebrada[4]
					 * Rota: mensagem_quebrada[5]
					 * Altitude: mensagem_quebrada[11]
					 * Latitude: mensagem_quebrada[14]
					 * Longitude: mensagem_quebrada[15]
					 * Angulo: mensagem_quebrada[13]
					 * Velocidade: mensagem_quebrada[12] */
					System.out.println("Case 2 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					ObservacaoDao.adicionarObservacao("null", mensagem_quebrada[14], mensagem_quebrada[15], mensagem_quebrada[11], mensagem_quebrada[12], mensagem_quebrada[13], "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					WebService.enviarParaWS("null", mensagem_quebrada[14], mensagem_quebrada[15], mensagem_quebrada[11], mensagem_quebrada[12], mensagem_quebrada[13], "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					break;
				case 3:
					/* Hex: mensagem_quebrada[4]
					 * Rota: mensagem_quebrada[5]
					 * Altitude: mensagem_quebrada[11]
					 * Latitude: mensagem_quebrada[14]
					 * Longitude: mensagem_quebrada[15] */
					System.out.println("Case 3 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					ObservacaoDao.adicionarObservacao("null", mensagem_quebrada[14], mensagem_quebrada[15], mensagem_quebrada[11], "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					WebService.enviarParaWS("null", mensagem_quebrada[14], mensagem_quebrada[15], mensagem_quebrada[11], "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					break;
				case 4:
					/* Hex: mensagem_quebrada[4]
					 * Rota: mensagem_quebrada[5]
					 * Angulo: mensagem_quebrada[13]
					 * Velocidade: mensagem_quebrada[12] */
					System.out.println("Case 4 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					ObservacaoDao.adicionarObservacao("null", "null", "null", "null", "'"+mensagem_quebrada[12]+"'", "'"+mensagem_quebrada[13]+"'", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					WebService.enviarParaWS("null", "null", "null", "null", "'"+mensagem_quebrada[12]+"'", "'"+mensagem_quebrada[13]+"'", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					break;
				case 5:
					/* Hex: mensagem_quebrada[4]
					 * Rota: mensagem_quebrada[5]
					 * Altitude: mensagem_quebrada[11] */
					System.out.println("Case 5 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					ObservacaoDao.adicionarObservacao("null", "null", "null", mensagem_quebrada[11], "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					WebService.enviarParaWS("null", "null", "null", mensagem_quebrada[11], "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					break;
				case 6:
					/* Hex: mensagem_quebrada[4]
					 * Rota: mensagem_quebrada[5]
					 * Altitude: mensagem_quebrada[11] */
					System.out.println("Case 6 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					ObservacaoDao.adicionarObservacao("null", "null", "null", mensagem_quebrada[11], "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					WebService.enviarParaWS("null", "null", "null", mensagem_quebrada[11], "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					break;
				case 7:
					/* Hex: mensagem_quebrada[4]
					 * Rota: mensagem_quebrada[5]
					 * Altitude: mensagem_quebrada[11] */
					System.out.println("Case 7 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					ObservacaoDao.adicionarObservacao("null", "null", "null", mensagem_quebrada[11], "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					WebService.enviarParaWS("null", "null", "null", mensagem_quebrada[11], "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					break;
				case 8:
					/* Hex: mensagem_quebrada[4]
					 * Rota: mensagem_quebrada[5] */
					System.out.println("Case 8 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					ObservacaoDao.adicionarObservacao("null", "null", "null", "null", "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					WebService.enviarParaWS("null", "null", "null", "null", "null", "null", "'"+ mensagem_quebrada[8] + " " + mensagem_quebrada[9] +"'", "null", "'"+mensagem_quebrada[4]+"'");
					break;
			}
			
			if("FIM".equals(mensagem)){
				break;
			}

		}
		
		System.out.println("Encerrando conexão...");
		
		in.close();
		
		out.close();
		
		socket.close();
		
	}
	
	
	
}