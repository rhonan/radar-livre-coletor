package beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "observacao")

public class Observacao implements java.io.Serializable{
	
	private long id;
	private Rota rota;
	private String radar;
	private double latitude;
	private double longitude;
	private int altitude;
	private double velocidade;
	private double angulo;
	private Date hora;
	private Aeronave aeronave;
	
	public Observacao(){
		
	}
	
	public Observacao(int id, Rota rota, String radar, long latitude,
			long longitude, int altitude, double velocidade, double angulo,
			Date hora, Aeronave aeronave) {
		this.id = id;
		this.rota = rota;
		this.radar = radar;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.velocidade = velocidade;
		this.angulo = angulo;
		this.hora = hora;
		this.aeronave = aeronave;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Rota getRota() {
		return this.rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Aeronave getAeronave() {
		return this.aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}
	
	@Column(name = "RADAR")
	public String getRadar() {
		return this.radar;
	}

	public void setRadar(String radar) {
		this.radar = radar;
	}

	@Column(name = "LATITUDE")
	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Column(name = "LONGITUDE")
	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	
	@Column(name = "ALTITUDE")
	public int getAltitude() {
		return this.altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	@Column(name = "VELOCIDADE")
	public double getVelocidade() {
		return this.velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}
	
	@Column(name = "ANGULO")
	public double getAngulo() {
		return this.angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	@Column(name = "HORA")
	public Date getHora() {
		return this.hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
}
