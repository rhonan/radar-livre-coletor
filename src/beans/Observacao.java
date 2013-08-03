package beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "observacao", uniqueConstraints = {
		@UniqueConstraint(columnNames = "RADAR"),
		@UniqueConstraint(columnNames = "LATITUDE"),
		@UniqueConstraint(columnNames = "LONGITUDE"),
		@UniqueConstraint(columnNames = "ALTITUDE"),
		@UniqueConstraint(columnNames = "VELOCIDADE"),
		@UniqueConstraint(columnNames = "ANGULO"),
		@UniqueConstraint(columnNames = "HORA")})

public class Observacao implements java.io.Serializable{
	
	private long id;
	private Rota rota;
	private String radar;
	private long latitude;
	private long longitude;
	private int altitude;
	private int velocidade;
	private int angulo;
	private Date hora;
	private Aeronave aeronave;
	
	public Observacao(){
		
	}
	
	public Observacao(int id, Rota rota, String radar, long latitude,
			long longitude, int altitude, int velocidade, int angulo,
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
	public long getLatitude() {
		return this.latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	@Column(name = "LONGITUDE")
	public long getLongitude() {
		return this.longitude;
	}

	public void setLongitude(long longitude) {
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
	public int getVelocidade() {
		return this.velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
	@Column(name = "ANGULO")
	public int getAngulo() {
		return this.angulo;
	}

	public void setAngulo(int angulo) {
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
