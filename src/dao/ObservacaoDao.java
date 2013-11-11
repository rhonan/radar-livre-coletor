package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import util.ConexaoBanco;

public class ObservacaoDao {

	public static void adicionarObservacaoMSG1(String id_rota, String hex){
		Connection connection;
		String sql = "INSERT INTO observacao (id_rota,hex) VALUES ('"+id_rota+"','"+hex+"')";
		
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
	
	public static void adicionarObservacao(String radar, String latitude, String longitude, String altitude, String velocidade, String angulo, String hora, String id_rota, String hex){
		Connection connection;
		String sql = "INSERT INTO observacao (radar,latitude,longitude,altitude,velocidade,angulo,hora,id_rota,hex) VALUES ('"+ radar +"','"+ latitude +"','"+ longitude +"','"+ altitude +"','"+ velocidade+"','"+ angulo +"','"+ hora+"','"+id_rota+"','"+hex+"')";
		
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
	
	public static JSONArray retornarObservacoes(){
		Connection connection;
		String sql="SELECT id_observacao,radar,latitude,longitude,altitude,velocidade,angulo,hora,id_rota,hex FROM observacao";
		
		String id_observacao;
		String radar;
		String latitude;
		String longitude;
		String altitude;
		String velocidade;
		String angulo;
		String hora;
		String id_rota;
		String hex;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject observacoes = new JSONObject();
				id_observacao = (rs.getString("id_observacao"));
				radar = (rs.getString("radar"));
				latitude = (rs.getString("latitude"));
				longitude = (rs.getString("longitude"));
				altitude = (rs.getString("altitude"));
				velocidade = (rs.getString("velocidade"));
				angulo = (rs.getString("angulo"));
				hora = (rs.getString("hora"));
				id_rota = (rs.getString("id_rota"));
				hex = (rs.getString("hex"));
				observacoes.put("id_observacao",id_observacao);
				observacoes.put("radar",radar);
				observacoes.put("latitude",latitude);
				observacoes.put("longitude",longitude);
				observacoes.put("altitude",altitude);
				observacoes.put("velocidade",velocidade);
				observacoes.put("angulo",angulo);
				observacoes.put("hora",hora);
				observacoes.put("id_rota",id_rota);
				observacoes.put("hex",hex);
				//	System.out.println(isbn + " " + nome_titulo + " " + tipo_titulo);
				arrayObj.put(observacoes);
				
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
	
	public static JSONArray retornarObservacaoPorId(String id_observacaoBuscado){
		Connection connection;
		String sql="SELECT id_observacao,radar,latitude,longitude,altitude,velocidade,angulo,hora,id_rota,hex FROM observacao WHERE id_observacao='"+id_observacaoBuscado+"'";
		
		String id_observacao;
		String radar;
		String latitude;
		String longitude;
		String altitude;
		String velocidade;
		String angulo;
		String hora;
		String id_rota;
		String hex;
		
		JSONArray arrayObj = new JSONArray();
		
		try {
			connection = ConexaoBanco.AbrirConexao();
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				JSONObject observacoes = new JSONObject();
				id_observacao = (rs.getString("id_observacao"));
				radar = (rs.getString("radar"));
				latitude = (rs.getString("latitude"));
				longitude = (rs.getString("longitude"));
				altitude = (rs.getString("altitude"));
				velocidade = (rs.getString("velocidade"));
				angulo = (rs.getString("angulo"));
				hora = (rs.getString("hora"));
				id_rota = (rs.getString("id_rota"));
				hex = (rs.getString("hex"));
				observacoes.put("id_observacao",id_observacao);
				observacoes.put("radar",radar);
				observacoes.put("latitude",latitude);
				observacoes.put("longitude",longitude);
				observacoes.put("altitude",altitude);
				observacoes.put("velocidade",velocidade);
				observacoes.put("angulo",angulo);
				observacoes.put("hora",hora);
				observacoes.put("id_rota",id_rota);
				observacoes.put("hex",hex);
				//	System.out.println(isbn + " " + nome_titulo + " " + tipo_titulo);
				arrayObj.put(observacoes);
				
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
	
	public static void atualizarObservacao(String id_observacao, String radar, String latitude, String longitude, String altitude, String velocidade, String angulo, String hora, String id_rota, String hex)
	{
		Connection connection;
		
		String sql = "UPDATE observacao SET radar='"+ radar +"', latitude='"+ latitude +"', longitude='"+ longitude +"', altitude='"+altitude+"', velocidade='"+velocidade+"', angulo='"+angulo+"', hora='"+hora+"', id_rota='"+id_rota+"', hex='"+hex+"' WHERE prefixo='"+ id_observacao +"'";

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