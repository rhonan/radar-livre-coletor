package Beans;

import java.util.Date;

public class Observacao {
	
	private int id;
	
	private Rota rota;
	
	private String radar;
	
	private long latitude;
	
	private long longitude;
	
	private int altitude;
	
	private int velocidade;
	
	private int angulo;
	
	private Date hora;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public String getRadar() {
		return radar;
	}

	public void setRadar(String radar) {
		this.radar = radar;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getAngulo() {
		return angulo;
	}

	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
}
