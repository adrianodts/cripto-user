package br.com.adrianodts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class AssinaturaEndereco {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codAssinaturaEndereco;
	
	@ManyToOne()
	@JoinColumn(name = "codAssinatura", nullable = false)
	private Assinatura assinatura;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;
	
	@Column
	private Long numCep;

	public Long getCodAssinaturaEndereco() {
		return codAssinaturaEndereco;
	}

	public void setCodAssinaturaEndereco(Long codAssinaturaEndereco) {
		this.codAssinaturaEndereco = codAssinaturaEndereco;
	}

	public Assinatura getAssinatura() {
		return assinatura;
	}

	public void setAssinatura(Assinatura assinatura) {
		this.assinatura = assinatura;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public Long getNumCep() {
		return numCep;
	}

	public void setNumCep(Long numCep) {
		this.numCep = numCep;
	}
	
}