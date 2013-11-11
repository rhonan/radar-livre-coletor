package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import util.ConexaoBanco;

public class AeronaveDao {
	
	public static void adicionarAeronave(String hex, String modelo_aeronave, String companhia){
		Connection connection;
		String sql = "INSERT INTO aeronave (hex,modelo_aeronave,companhia) VALUES ('"+ hex +"','"+ modelo_aeronave +"','"+ companhia +"')";
		
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
		String sql="SELECT hex,companhia,modelo_aeronave FROM aeronave";
		
		String hex;
		String companhia;
		String modelo_aeronave;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject aeronaves = new JSONObject();
				hex = (rs.getString("hex"));
				companhia = (rs.getString("companhia"));
				modelo_aeronave = (rs.getString("modelo_aeronave"));
				aeronaves.put("hex",hex);
				aeronaves.put("companhia",companhia);
				aeronaves.put("modelo_aeronave",modelo_aeronave);
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
		String sql = "SELECT hex,companhia,modelo_aeronave FROM aeronave WHERE hex="+ hexBuscado +"';";
		
		String hex;
		String companhia;
		String modelo_aeronave;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject aeronaves = new JSONObject();
				hex = (rs.getString("hex"));
				companhia = (rs.getString("companhia"));
				modelo_aeronave = (rs.getString("modelo_aeronave"));
				aeronaves.put("hex",hex);
				aeronaves.put("companhia",companhia);
				aeronaves.put("modelo_aeronave",modelo_aeronave);
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
	
	public static void atualizarAeronave(String hexParaAtualizar, String novoHex, String companhia, String modelo_aeronave){
		Connection connection;
		
		String sql = "UPDATE aeronave SET hex='"+novoHex +"' companhia='"+ companhia +"', modelo_aeroanve='"+ modelo_aeronave +"' WHERE hex='"+ hexParaAtualizar +"'";

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
