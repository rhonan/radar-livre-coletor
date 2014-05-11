package br.ufc.quixada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import br.ufc.quixada.util.ConexaoBanco;

public class RotaHasAeroportoDao {
	
	public static void adicionarRotaAeroporto(String id, String hex, String prefixo, String sequencial){
		Connection connection;
		String sql = "INSERT INTO rota_aeroporto (id,hex,prefixo,sequencial) VALUES ('"+ id +"','"+ hex +"','"+ prefixo +"','"+ sequencial +"')";
		
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
	
	public static JSONArray retornarRotaAeroportos(){
		Connection connection;
		String sql = "SELECT id,hex,prefixo,sequencial FROM rota_aeroporto;";
		
		String id;
		String hex;
		String prefixo;
		String sequencial;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject rotas = new JSONObject();
				id = (rs.getString("id"));
				hex = (rs.getString("hex"));
				prefixo = (rs.getString("prefixo"));
				sequencial = (rs.getString("sequencial"));
				rotas.put("id",id);
				rotas.put("hex",hex);
				rotas.put("prefixo",prefixo);
				rotas.put("sequencial",sequencial);
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
	
	public static JSONArray retornarRotaAeroportoPorRotaId(String idBuscado){
		Connection connection;
		String sql = "SELECT id,hex,prefixo,sequencial FROM rota_aeroporto WHERE id='"+idBuscado+"';";
		
		String id;
		String hex;
		String prefixo;
		String sequencial;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject rotas = new JSONObject();
				id = (rs.getString("id"));
				hex = (rs.getString("hex"));
				prefixo = (rs.getString("prefixo"));
				sequencial = (rs.getString("sequencial"));
				rotas.put("id",id);
				rotas.put("hex",hex);
				rotas.put("prefixo",prefixo);
				rotas.put("sequencial",sequencial);
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
	
	public static void atualizarRotaAeroporto(String novaId_rota, String idParaAtualizar, String hex, String sequencial, String prefixo)
	{
	Connection connection;
		
		String sql = "UPDATE rota_aeroporto SET id='"+ novaId_rota +"', hex='"+ hex +"', prefixo='"+ prefixo+"', sequencial='"+sequencial+"' WHERE id='"+ idParaAtualizar +"'";

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
