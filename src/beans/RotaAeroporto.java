package beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "rota_has_aeroporto", uniqueConstraints = {
		@UniqueConstraint(columnNames = "SEQUENCIAL")})

public class RotaAeroporto implements java.io.Serializable {
	
	private Rota rota;
	private Aeroporto aeroporto;
	private int sequencial;
	
	public RotaAeroporto(){
		
	}
	
	public RotaAeroporto(Rota rota, Aeroporto aeroporto, int sequencial){
		this.aeroporto = aeroporto;
		this.rota = rota;
		this.sequencial = sequencial;
	}

	@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Aeronave getAeronave() {
		return rota.getAeronave();
	}

	public void setAeronave(Aeronave aeronave) {
		rota.setAeronave(aeronave);
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Aeroporto getAeroporto() {
		return aeroporto;
	}

	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}

	@Column(name = "SEQUENCIAL")
	public int getSequencial() {
		return sequencial;
	}

	public void setSequencial(int sequencial) {
		this.sequencial = sequencial;
	}
}
