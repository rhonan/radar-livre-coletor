package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import util.ConexaoBanco;

public class RotaDao {
	
	public static void adicionarRota(String id_rota, String hex, String prefixo_aeroporto_saida, String prefixo_aeroporto_chegada){
		Connection connection;
		String sql = "INSERT INTO rota (id_rota,hex,prefixo_aeroporto_saida,prefixo_aeroporto_chegada) VALUES ('"+ id_rota +"','"+ hex +"','"+ prefixo_aeroporto_saida +"','"+ prefixo_aeroporto_chegada +"')";
		
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

	public static void adicionarRotaHexId(String id_rota, String hex){
		Connection connection;
		String sql = "INSERT INTO rota (id_rota,hex) VALUES ('"+ id_rota +"','"+ hex +"')";
		
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
		String sql = "SELECT id_rota,hex,prefixo_aeroporto_chegada,prefixo_aeroporto_saida FROM rota;";
		
		String id_rota;
		String hex;
		String prefixo_aeroporto_chegada;
		String prefixo_aeroporto_saida;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject rotas = new JSONObject();
				id_rota = (rs.getString("id_rota"));
				hex = (rs.getString("hex"));
				prefixo_aeroporto_chegada = (rs.getString("prefixo_aeroporto_chegada"));
				prefixo_aeroporto_saida = (rs.getString("prefixo_aeroporto_saida"));
				rotas.put("id_rota",id_rota);
				rotas.put("hex",hex);
				rotas.put("prefixo_aerporto_chegada",prefixo_aeroporto_chegada);
				rotas.put("prefixo_aeroporto_saida",prefixo_aeroporto_saida);
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
	
	public static JSONArray retornarRotaPorId(String id_rotaBuscado){
		Connection connection;
		String sql = "SELECT id_rota,hex,prefixo_aeroporto_chegada,prefixo_aeroporto_saida FROM rota WHERE id_rota="+ id_rotaBuscado +"';";
		
		String id_rota;
		String hex;
		String prefixo_aeroporto_chegada;
		String prefixo_aeroporto_saida;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject rotas = new JSONObject();
				id_rota = (rs.getString("prefixo"));
				hex = (rs.getString("nome"));
				prefixo_aeroporto_chegada = (rs.getString("cidade"));
				prefixo_aeroporto_saida = (rs.getString("pais"));
				rotas.put("id_rota",id_rota);
				rotas.put("hex",hex);
				rotas.put("prefixo_aerporto_chegada",prefixo_aeroporto_chegada);
				rotas.put("prefixo_aeroporto_saida",prefixo_aeroporto_saida);
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
	
	public static void atualizarRota(String id_rotaParaAtualizar, String novaid_rota, String hex, String prefixo_aeroporto_saida, String prefixo_aeroporto_chegada)
	{
	Connection connection;
		
		String sql = "UPDATE rota SET id_rota='"+ novaid_rota +"', hex='"+ hex +"', prefixo_aeroporto_saida='"+ prefixo_aeroporto_saida +"', prefixo_aeorporto_chegada='"+prefixo_aeroporto_chegada+"' WHERE id_rota='"+ id_rotaParaAtualizar +"'";

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