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
		
		while(true){
			String mensagem = in.readLine();
			String[] mensagem_quebrada = mensagem.split(Pattern.quote(","));
			
			switch(Integer.parseInt(mensagem_quebrada[1])){
			
				case 1:					
					System.out.println("Case 1 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					//rota.setRota_id(mensagem_quebrada[5]);
					//observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					System.out.println(AeronaveDao.retornarAeronavePorHex(mensagem_quebrada[4]));
					System.out.println(AeronaveDao.retornarAeronavePorHex(mensagem_quebrada[4]).length());
					if(AeronaveDao.retornarAeronavePorHex(mensagem_quebrada[4]).length() == 0){
						System.out.println("if");
						AeronaveDao.adicionarAeronaveHex(mensagem_quebrada[4]);
						RotaDao.adicionarRotaHexId(mensagem_quebrada[5], mensagem_quebrada[4]);
						ObservacaoDao.adicionarObservacaoMSG1(mensagem_quebrada[5], mensagem_quebrada[4]);
					}else{
						System.out.println("else");
						ObservacaoDao.adicionarObservacaoMSG1(mensagem_quebrada[5], mensagem_quebrada[4]);					}
					break;
				case 2:
					System.out.println("Case 2 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
//					aeronave.setHex(mensagem_quebrada[4]);
//					rota.setRota_id(mensagem_quebrada[5]);
//					observacao.setRota(rota);
//					mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
//					observacao.setAltitude(Integer.parseInt(mensagem_quebrada[11]));
//					observacao.setLatitude(Double.parseDouble(mensagem_quebrada[14]));
//					observacao.setLongitude(Double.parseDouble(mensagem_quebrada[15]));
//					observacao.setAngulo(Double.parseDouble(mensagem_quebrada[13]));
//					observacao.setVelocidade(Integer.parseInt(mensagem_quebrada[12]));
					
					if(AeronaveDao.retornarAeronavePorHex(mensagem_quebrada[4]).length() == 0){
						AeronaveDao.adicionarAeronave(mensagem_quebrada[4], null, null);
						RotaDao.adicionarRota(mensagem_quebrada[5], mensagem_quebrada[4], null, null);
						ObservacaoDao.adicionarObservacao(null, mensagem_quebrada[14], mensagem_quebrada[15], null, mensagem_quebrada[12], mensagem_quebrada[13], null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}else{
						ObservacaoDao.adicionarObservacao(null, mensagem_quebrada[14], mensagem_quebrada[15], null, mensagem_quebrada[12], mensagem_quebrada[13], null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}
					
					break;
				case 3:
					System.out.println("Case 3 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					
//					aeronave.setHex(mensagem_quebrada[4]);
//					rota.setRota_id(mensagem_quebrada[5]);
//					rota.setAeronave(aeronave);
//					observacao.setRota(rota);
//					observacao.setAltitude(Integer.parseInt(mensagem_quebrada[11]));
//					observacao.setLatitude(Double.parseDouble(mensagem_quebrada[14]));
//					observacao.setLongitude(Double.parseDouble(mensagem_quebrada[15]));
//					observacao.setAeronave_Hex(aeronave.getHex());
					
					if(AeronaveDao.retornarAeronavePorHex(mensagem_quebrada[4]).length() == 0){
						AeronaveDao.adicionarAeronave(mensagem_quebrada[4], null, null);
						RotaDao.adicionarRota(mensagem_quebrada[5], mensagem_quebrada[4], null, null);
						ObservacaoDao.adicionarObservacao(null, mensagem_quebrada[14], mensagem_quebrada[15], mensagem_quebrada[11], null, null, null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}else{
						ObservacaoDao.adicionarObservacao(null, mensagem_quebrada[14], mensagem_quebrada[15], mensagem_quebrada[11], null, null, null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}
					break;
				case 4:
					System.out.println("Case 4 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
//					aeronave.setHex(mensagem_quebrada[4]);
//					rota.setRota_id(mensagem_quebrada[5]);
//					observacao.setRota(rota);
//					mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
//					observacao.setAngulo(Double.parseDouble(mensagem_quebrada[13]));
//					observacao.setVelocidade(Double.parseDouble(mensagem_quebrada[12]));
					if(AeronaveDao.retornarAeronavePorHex(mensagem_quebrada[4]).length() == 0){
						AeronaveDao.adicionarAeronave(mensagem_quebrada[4], null, null);
						RotaDao.adicionarRota(mensagem_quebrada[5], mensagem_quebrada[4], null, null);
						ObservacaoDao.adicionarObservacao(null, null, null, null, mensagem_quebrada[12], mensagem_quebrada[13], null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}else{
						ObservacaoDao.adicionarObservacao(null, null, null, null, mensagem_quebrada[12], mensagem_quebrada[13], null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}
					break;
				case 5:
					System.out.println("Case 5 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					//aeronave.setHex(mensagem_quebrada[4]);
					//rota.setRota_id(mensagem_quebrada[5]);
					//observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					//observacao.setAltitude(Integer.parseInt(mensagem_quebrada[11]));
					if(AeronaveDao.retornarAeronavePorHex(mensagem_quebrada[4]).length() == 0){
						AeronaveDao.adicionarAeronave(mensagem_quebrada[4], null, null);
						RotaDao.adicionarRota(mensagem_quebrada[5], mensagem_quebrada[4], null, null);
						ObservacaoDao.adicionarObservacao(null, null, null, mensagem_quebrada[11], null, null, null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}else{
						ObservacaoDao.adicionarObservacao(null, null, null, mensagem_quebrada[11], null, null, null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}
					break;
				case 6:
					System.out.println("Case 6 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					//aeronave.setHex(mensagem_quebrada[4]);
					//rota.setRota_id(mensagem_quebrada[5]);
					//observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					//observacao.setAltitude(Integer.parseInt(mensagem_quebrada[11]));
					if(AeronaveDao.retornarAeronavePorHex(mensagem_quebrada[4]).length() == 0){
						AeronaveDao.adicionarAeronave(mensagem_quebrada[4], null, null);
						RotaDao.adicionarRota(mensagem_quebrada[5], mensagem_quebrada[4], null, null);
						ObservacaoDao.adicionarObservacao(null, null, null, mensagem_quebrada[11], null, null, null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}else{
						ObservacaoDao.adicionarObservacao(null, null, null, mensagem_quebrada[11], null, null, null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}
					break;
				case 7:
					System.out.println("Case 7 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					//aeronave.setHex(mensagem_quebrada[4]);
					//rota.setRota_id(mensagem_quebrada[5]);
					//observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					//observacao.setAltitude(Integer.parseInt(mensagem_quebrada[11]));
					if(AeronaveDao.retornarAeronavePorHex(mensagem_quebrada[4]).length() == 0){
						AeronaveDao.adicionarAeronave(mensagem_quebrada[4], null, null);
						RotaDao.adicionarRota(mensagem_quebrada[5], mensagem_quebrada[4], null, null);
						ObservacaoDao.adicionarObservacao(null, null, null, mensagem_quebrada[11], null, null, null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}else{
						ObservacaoDao.adicionarObservacao(null, null, null, mensagem_quebrada[11], null, null, null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}
					break;
				case 8:
					System.out.println("Case 8 Tipo de mensagem recebida: " + mensagem_quebrada[1]);
					//aeronave.setHex(mensagem_quebrada[4]);
					//rota.setRota_id(mensagem_quebrada[5]);
					//observacao.setRota(rota);
					//mensagem_quebrada[9] mensagem_quebrada[10] observacao hora
					if(AeronaveDao.retornarAeronavePorHex(mensagem_quebrada[4]).length() == 0){
						AeronaveDao.adicionarAeronave(mensagem_quebrada[4], null, null);
						RotaDao.adicionarRota(mensagem_quebrada[5], mensagem_quebrada[4], null, null);
						ObservacaoDao.adicionarObservacao(null, null, null, null, null, null, null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}else{
						ObservacaoDao.adicionarObservacao(null, null, null, null, null, null, null, mensagem_quebrada[5], mensagem_quebrada[4]);
					}
					break;
			}
			
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