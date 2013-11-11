package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import util.ConexaoBanco;

public class RotaHasAeroportoDao {
	
	public static void adicionarRotaAeroporto(String id_rota, String hex, String prefixo, String sequencial){
		Connection connection;
		String sql = "INSERT INTO rota_has_aeroporto (id_rota,hex,prefixo,sequencial) VALUES ('"+ id_rota +"','"+ hex +"','"+ prefixo +"','"+ sequencial +"')";
		
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
		String sql = "SELECT id_rota,hex,prefixo,sequencial FROM rota_has_aeroporto;";
		
		String id_rota;
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
				id_rota = (rs.getString("id_rota"));
				hex = (rs.getString("hex"));
				prefixo = (rs.getString("prefixo"));
				sequencial = (rs.getString("sequencial"));
				rotas.put("id_rota",id_rota);
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
	
	public static JSONArray retornarRotaAeroportoPorRotaId(String id_rotaBuscado){
		Connection connection;
		String sql = "SELECT id_rota,hex,prefixo,sequencial FROM rota_has_aeroporto WHERE id_rota='"+id_rotaBuscado+"';";
		
		String id_rota;
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
				id_rota = (rs.getString("id_rota"));
				hex = (rs.getString("hex"));
				prefixo = (rs.getString("prefixo"));
				sequencial = (rs.getString("sequencial"));
				rotas.put("id_rota",id_rota);
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
	
	public static void atualizarRotaAeroporto(String novaId_rota, String id_rotaParaAtualizar, String hex, String sequencial, String prefixo)
	{
	Connection connection;
		
		String sql = "UPDATE rota_has_aeroporto SET id_rota='"+ novaId_rota +"', hex='"+ hex +"', prefixo='"+ prefixo+"', sequencial='"+sequencial+"' WHERE id_rota='"+ id_rotaParaAtualizar +"'";

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
