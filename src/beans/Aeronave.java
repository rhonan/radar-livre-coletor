package beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "aeronave")

public class Aeronave implements java.io.Serializable{
	
	private String hex;
	private String modelo_aeronave;
	private String companhia;
	private Rota rota;
	
	public Aeronave(){
		
	}
	
	public Aeronave(String hex, String modelo_aeronave, String companhia){
		this.hex = hex;
		this.modelo_aeronave = modelo_aeronave;
		this.companhia = companhia;
	}
	
	public Aeronave(String hex, String modelo_aeronave, String companhia, Rota rota){
		this.hex = hex;
		this.modelo_aeronave = modelo_aeronave;
		this.companhia = companhia;
		this.rota = rota;
	}
	
	@Id
	@Column(name = "HEX", unique = true)
	public String getHex() {
		return this.hex;
	}
	
	public void setHex(String hex) {
		this.hex = hex;
	}
	
	@Column(name = "MODELO_AERONAVE")
	public String getModelo_aeronave() {
		return this.modelo_aeronave;
	}
	
	public void setModelo_aeronave(String modelo_aeronave) {
		this.modelo_aeronave = modelo_aeronave;
	}
	
	@Column(name = "COMPANHIA")
	public String getCompanhia() {
		return this.companhia;
	}
	
	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "aeronave", cascade = CascadeType.ALL)
	public Rota getRota(){
		return this.rota;
	}
	
	public void setRota(Rota rota){
		this.rota = rota;
	}
	
}
