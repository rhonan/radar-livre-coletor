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
@Table(name = "observacao", catalog = "coletorbd", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ROTA"),
		@UniqueConstraint(columnNames = "RADAR"),
		@UniqueConstraint(columnNames = "LATITUDE"),
		@UniqueConstraint(columnNames = "LONGITUDE"),
		@UniqueConstraint(columnNames = "ALTITUDE"),
		@UniqueConstraint(columnNames = "VELOCIDADE"),
		@UniqueConstraint(columnNames = "ANGULO"),
		@UniqueConstraint(columnNames = "HORA")})

public class Observacao implements java.io.Serializable{
	
	private int id;
	private Rota rota;
	private String radar;
	private long latitude;
	private long longitude;
	private int altitude;
	private int velocidade;
	private int angulo;
	private Date hora;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "observacao", cascade = CascadeType.ALL)
	public Rota getRota() {
		return this.rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	@Column(name = "RADAR", nullable=false)
	public String getRadar() {
		return this.radar;
	}

	public void setRadar(String radar) {
		this.radar = radar;
	}

	@Column(name = "LATITUDE", nullable=false)
	public long getLatitude() {
		return this.latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	@Column(name = "LONGITUDE", nullable=false)
	public long getLongitude() {
		return this.longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	
	@Column(name = "ALTITUDE", nullable=false)
	public int getAltitude() {
		return this.altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	@Column(name = "VELOCIDADE", nullable=false)
	public int getVelocidade() {
		return this.velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
	@Column(name = "ANGULO", nullable=false)
	public int getAngulo() {
		return this.angulo;
	}

	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	@Column(name = "HORA", nullable=false)
	public Date getHora() {
		return this.hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
}
