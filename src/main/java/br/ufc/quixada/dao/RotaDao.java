package br.ufc.quixada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import br.ufc.quixada.util.ConexaoBanco;

public class RotaDao {
	
	public static void adicionarRota(String id, String hex, String aeroporto_saida, String aeroporto_chegada){
		Connection connection;
		String sql = "INSERT INTO rota (id,hex,aeroporto_saida,aeroporto_chegada) VALUES ('"+ id +"','"+ hex +"','"+ aeroporto_saida +"','"+ aeroporto_chegada +"')";
		
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

	public static void adicionarRotaHexId(String id, String hex){
		Connection connection;
		String sql = "INSERT INTO rota (id,hex) VALUES ('"+ id +"','"+ hex +"')";
		
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
	
	public static JSONArray retornarRotas(){
		Connection connection;
		String sql = "SELECT id,hex,aeroporto_chegada,aeroporto_saida FROM rota;";
		
		String id;
		String hex;
		String aeroporto_chegada;
		String aeroporto_saida;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject rotas = new JSONObject();
				id = (rs.getString("id"));
				hex = (rs.getString("hex"));
				aeroporto_chegada = (rs.getString("aeroporto_chegada"));
				aeroporto_saida = (rs.getString("aeroporto_saida"));
				rotas.put("id",id);
				rotas.put("hex",hex);
				rotas.put("prefixo_aerporto_chegada",aeroporto_chegada);
				rotas.put("aeroporto_saida",aeroporto_saida);
				arrayObj.put(rotas);
				
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
	
	public static JSONArray retornarRotaPorId(String idBuscado){
		Connection connection;
		String sql = "SELECT id,hex,aeroporto_chegada,aeroporto_saida FROM rota WHERE id="+ idBuscado +"';";
		
		String id;
		String hex;
		String aeroporto_chegada;
		String aeroporto_saida;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject rotas = new JSONObject();
				id = (rs.getString("prefixo"));
				hex = (rs.getString("nome"));
				aeroporto_chegada = (rs.getString("cidade"));
				aeroporto_saida = (rs.getString("pais"));
				rotas.put("id",id);
				rotas.put("hex",hex);
				rotas.put("prefixo_aerporto_chegada",aeroporto_chegada);
				rotas.put("aeroporto_saida",aeroporto_saida);
				arrayObj.put(rotas);
				
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
	
	public static void atualizarRota(String idParaAtualizar, String novaid, String hex, String aeroporto_saida, String aeroporto_chegada)
	{
	Connection connection;
		
		String sql = "UPDATE rota SET id='"+ novaid +"', hex='"+ hex +"', aeroporto_saida='"+ aeroporto_saida +"', aeroporto_chegada='"+aeroporto_chegada+"' WHERE id='"+ idParaAtualizar +"'";

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