package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name= "rota", catalog = "coletorbd")
public class Rota implements java.io.Serializable{
	
	private String rota_id;
	private Aeronave aeronave;
	private Aeroporto aeroporto_saida;
	private Aeroporto aeroporto_chegada;
	
	public Rota(){
		
	}
	
	public Rota(String rota_id, Aeronave aeronave, Aeroporto aeroporto_saida, Aeroporto aeroporto_chegada){
		this.rota_id = rota_id;
		this.aeronave = aeronave;
		this.aeroporto_saida = aeroporto_saida;
		this.aeroporto_chegada = aeroporto_chegada;
	}
	
	@Id
	@Column(name = "ROTA_ID", unique = true, nullable = false)
	public String getRota_id() {
		return this.rota_id;
	}
	
	public void setRota_id(String rota_id) {
		this.rota_id = rota_id;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Aeronave getAeronave() {
		return this.aeronave;
	}
	
	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Aeroporto getAeroporto_saida() {
		return this.aeroporto_saida;
	}
	
	public void setAeroporto_saida(Aeroporto aeroporto_saida) {
		this.aeroporto_saida = aeroporto_saida;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Aeroporto getAeroporto_chegada() {
		return this.aeroporto_chegada;
	}
	
	public void setAeroporto_chegada(Aeroporto aeroporto_chegada) {
		this.aeroporto_chegada = aeroporto_chegada;
	}

}
