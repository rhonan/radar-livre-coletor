package br.ufc.quixada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import br.ufc.quixada.util.ConexaoBanco;

public class AeronaveDao {
	
	public static void adicionarAeronave(String hex, String modelo, String companhia){
		Connection connection;
		String sql = "INSERT INTO aeronave (hex,modelo,companhia) VALUES ('"+ hex +"','"+ modelo +"','"+ companhia +"')";
		
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

	public static void adicionarAeronaveHex(String hex){
		Connection connection;
		String sql = "INSERT INTO aeronave (hex) VALUES ('"+ hex +"')";
		
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
	
	public static JSONArray retornarAeronaves(){
		Connection connection;
		String sql="SELECT hex,companhia,modelo FROM aeronave";
		
		String hex;
		String companhia;
		String modelo;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject aeronaves = new JSONObject();
				hex = (rs.getString("hex"));
				companhia = (rs.getString("companhia"));
				modelo = (rs.getString("modelo"));
				aeronaves.put("hex",hex);
				aeronaves.put("companhia",companhia);
				aeronaves.put("modelo",modelo);
			//	System.out.println(isbn + " " + nome_titulo + " " + tipo_titulo);
				arrayObj.put(aeronaves);
				
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
	
	public static JSONArray retornarAeronavePorHex(String hexBuscado){
		Connection connection;
		String sql = "SELECT hex,companhia,modelo FROM aeronave WHERE hex='"+ hexBuscado +"';";
		
		String hex;
		String companhia;
		String modelo;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject aeronaves = new JSONObject();
				hex = (rs.getString("hex"));
				companhia = (rs.getString("companhia"));
				modelo = (rs.getString("modelo"));
				aeronaves.put("hex",hex);
				aeronaves.put("companhia",companhia);
				aeronaves.put("modelo",modelo);
			//	System.out.println(isbn + " " + nome_titulo + " " + tipo_titulo);
				arrayObj.put(aeronaves);
				
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
	
	public static void atualizarAeronave(String hexParaAtualizar, String novoHex, String companhia, String modelo){
		Connection connection;
		
		String sql = "UPDATE aeronave SET hex='"+novoHex +"' companhia='"+ companhia +"', modelo_aeroanve='"+ modelo +"' WHERE hex='"+ hexParaAtualizar +"'";

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
