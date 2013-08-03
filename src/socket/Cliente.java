package socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.regex.Pattern;

import dao.AeronaveDao;
import dao.ObservacaoDao;
import dao.RotaDao;

import beans.Aeronave;
import beans.Aeroporto;
import beans.Observacao;
import beans.Rota;

public class Cliente {

	public static void main(String[] args) throws Exception{
		System.out.println("Iniciando cliente...");
		
		System.out.println("Iniciando conex�o com o servidor...");
		
		Socket socket = new Socket("127.0.0.1",30003);
		
		System.out.println("Conex�o estabelecida.");
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		PrintStream out = new PrintStream(output);
		
		Aeronave aeronave = new Aeronave();
		Rota rota = new Rota();
		Observacao observacao = new Observacao();
		
		while(true){
			String mensagem = in.readLine();
			String[] mensagem_quebrada = mensagem.split(Pattern.quote(","));
			
			switch(Integer.parseInt(mensagem_quebrada[1])){
			
				case 1:					
					System.out.println("Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					aeronave.setHex(mensagem_quebrada[4]);
					rota.setRota_id(mensagem_quebrada[5]);
					observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					AeronaveDao.adicionarAeronave(aeronave);
					RotaDao.adicionarRota(rota);
					ObservacaoDao.adicionarObservacao(observacao);
					break;
				case 2:
					System.out.println("Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					aeronave.setHex(mensagem_quebrada[4]);
					rota.setRota_id(mensagem_quebrada[5]);
					observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					observacao.setAltitude(Integer.parseInt(mensagem_quebrada[11]));
					observacao.setLatitude(Long.parseLong(mensagem_quebrada[14]));
					observacao.setLongitude(Long.parseLong(mensagem_quebrada[15]));
					observacao.setAngulo(Integer.parseInt(mensagem_quebrada[13]));
					break;
				case 3:
					System.out.println("Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					aeronave.setHex(mensagem_quebrada[4]);
					rota.setRota_id(mensagem_quebrada[5]);
					observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					observacao.setAltitude(Integer.parseInt(mensagem_quebrada[11]));
					observacao.setLatitude(Long.parseLong(mensagem_quebrada[14]));
					observacao.setLongitude(Long.parseLong(mensagem_quebrada[15]));
					break;
				case 4:
					System.out.println("Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					aeronave.setHex(mensagem_quebrada[4]);
					rota.setRota_id(mensagem_quebrada[5]);
					observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					observacao.setAngulo(Integer.parseInt(mensagem_quebrada[13]));
					break;
				case 5:
					System.out.println("Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					aeronave.setHex(mensagem_quebrada[4]);
					rota.setRota_id(mensagem_quebrada[5]);
					observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					observacao.setAltitude(Integer.parseInt(mensagem_quebrada[11]));
					break;
				case 6:
					System.out.println("Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					aeronave.setHex(mensagem_quebrada[4]);
					rota.setRota_id(mensagem_quebrada[5]);
					observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					observacao.setAltitude(Integer.parseInt(mensagem_quebrada[11]));
					break;
				case 7:
					System.out.println("Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					aeronave.setHex(mensagem_quebrada[4]);
					rota.setRota_id(mensagem_quebrada[5]);
					observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					observacao.setAltitude(Integer.parseInt(mensagem_quebrada[11]));
					break;
				case 8:
					System.out.println("Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					aeronave.setHex(mensagem_quebrada[4]);
					rota.setRota_id(mensagem_quebrada[5]);
					observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					break;
			}
			
			
//			for(int i=0; i< mensagem_quebrada.length; i++){
//			System.out.println(
//					"Mensagem recebida do servidor[" + socket.getInetAddress().getHostName() +
//					"]: " +
//					mensagem_quebrada[i]);
//			}
			
			if("FIM".equals(mensagem)){
				break;
			}

		}
		
		System.out.println("Encerrando conex�o...");
		
		in.close();
		
		out.close();
		
		socket.close();
		
	}
}