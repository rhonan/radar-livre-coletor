package br.ufc.quixada.webservice;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.json.JSONObject;

import br.ufc.quixada.pojo.Observacao;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class WebService {
	
	public static void enviarParaWS(String radar, String latitude, String longitude, String altitude, String velocidade, String angulo, String hora, String rota_id, String hex){
		Client client = Client.create();
		WebResource webResource = client.resource(getBaseURI() + "/observacao");
		Observacao obs = new Observacao(radar, latitude, longitude, altitude, velocidade, angulo, hora, rota_id, hex);
		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, obs);
	
		if (response.getStatus() != 201) {
			System.out.println("Falhou : HTTP error: "
			     + response.getStatus());
		}else{
			System.out.println("Resposta do servidor .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);
		}

	}

	
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/Radar-Livre")
				.build();
	}
	
}
