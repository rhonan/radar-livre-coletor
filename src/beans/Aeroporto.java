package beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "aeroporto", uniqueConstraints = {
		@UniqueConstraint(columnNames = "NOME"),
		@UniqueConstraint(columnNames = "CIDADE"),
		@UniqueConstraint(columnNames = "PAIS"),
		@UniqueConstraint(columnNames = "LATITUDE"),
		@UniqueConstraint(columnNames = "LONGITUDE"),
		@UniqueConstraint(columnNames = "ALTITUDE")})
public class Aeroporto {
	
	private String prefixo;
	private String nome;
	private String cidade;
	private String pais;
	private Long latitude;
	private Long longitude;
	private int altitude;
	
	public Aeroporto(){
		
	}
	
	public Aeroporto(String prefixo, String nome, String cidade, String pais, Long latitude, Long longitude, int altitude){
		this.prefixo = prefixo;
		this.nome = nome;
		this.pais = pais;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}

	@Id
	@Column(name = "PREFIXO", unique = true)
	public String getPrefixo() {
		return this.prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	@Column(name = "NOME")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "CIDADE")
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name = "PAIS")
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Column(name = "LATITUDE")
	public Long getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	@Column(name = "LONGITUDE")
	public Long getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	@Column(name = "ALTITUDE")
	public int getAltitude() {
		return this.altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}	
	
}
