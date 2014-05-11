package br.ufc.quixada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import br.ufc.quixada.util.ConexaoBanco;

public class AeroportoDao {
	
	public static void adicionarAeroporto(String prefixo, String nome, String cidade, String pais, String latitude, String longitude, String altitude){
		Connection connection;
		String sql = "INSERT INTO aeroporto (prefixo,nome,cidade,pais,latitude,longitude,altitude) VALUES ('"+ prefixo +"','"+ nome +"','"+ cidade +"','"+ pais +"','"+ latitude+"','"+ longitude +"','"+ altitude+"')";
		
		try {
			
			connection = ConexaoBanco.AbrirConexao();
			ConexaoBanco.executeInsert(connection, sql);
			connection.close();
			
			

	
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	
	}
		}
	
	public static JSONArray retornarAeroportos(){
		Connection connection;
		String sql="SELECT prefixo,nome,cidade,pais,latitude,longitude,altitude FROM aeroporto";
		
		String prefixo;
		String nome;
		String cidade;
		String pais;
		String latitude;
		String longitude;
		String altitude;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject aeroportos = new JSONObject();
				prefixo = (rs.getString("prefixo"));
				nome = (rs.getString("nome"));
				cidade = (rs.getString("cidade"));
				pais = (rs.getString("pais"));
				latitude = (rs.getString("latitude"));
				longitude = (rs.getString("longitude"));
				altitude = (rs.getString("altitude"));
				aeroportos.put("prefixo",prefixo);
				aeroportos.put("nome",nome);
				aeroportos.put("cidade",cidade);
				aeroportos.put("pais",pais);
				aeroportos.put("latitude",latitude);
				aeroportos.put("longitude",longitude);
				aeroportos.put("altitude",altitude);
				//	System.out.println(isbn + " " + nome_titulo + " " + tipo_titulo);
				arrayObj.put(aeroportos);
				
			}
			rs.close();
			pstm.close();
			connection.close();

	
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	
	}
		
		return arrayObj;
	}
	
	public static JSONArray retornarAeroportoPorPrefixo(String prefixoBuscado){
		Connection connection;
		String sql = "SELECT prefixo,nome,cidade,pais,latitude,longitude,altitude FROM aeroporto WHERE prefixo="+ prefixoBuscado +"';";
		
		String prefixo;
		String nome;
		String cidade;
		String pais;
		String latitude;
		String longitude;
		String altitude;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject aeroportos = new JSONObject();
				prefixo = (rs.getString("prefixo"));
				nome = (rs.getString("nome"));
				cidade = (rs.getString("cidade"));
				pais = (rs.getString("pais"));
				latitude = (rs.getString("latitude"));
				longitude = (rs.getString("longitude"));
				altitude = (rs.getString("altitude"));
				aeroportos.put("prefixo",prefixo);
				aeroportos.put("nome",nome);
				aeroportos.put("cidade",cidade);
				aeroportos.put("pais",pais);
				aeroportos.put("latitude",latitude);
				aeroportos.put("longitude",longitude);
				aeroportos.put("altitude",altitude);			//	System.out.println(isbn + " " + nome_titulo + " " + tipo_titulo);
				arrayObj.put(aeroportos);
				
			}
			rs.close();
			pstm.close();
			connection.close();

	
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	
	}
		
		return arrayObj;
	}
	
	public static void atualizarAeroporto(String prefixoParaAtualizar, String novoPrefixo, String nome, String cidade, String pais, String latitude, String longitude, String altitude){
		Connection connection;
		
		String sql = "UPDATE aeroporto SET prefixo='"+ novoPrefixo +"', nome='"+ nome +"', cidade='"+ cidade +"', pais='"+pais+"', latitude='"+latitude+"', longitude='"+longitude+"', altitude='"+altitude+"' WHERE prefixo='"+ prefixoParaAtualizar +"'";

		try {
			
			connection = ConexaoBanco.AbrirConexao();
			ConexaoBanco.executeQuery(connection, sql);
			
			connection.close();
			

	
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	
	}
	}
} 
