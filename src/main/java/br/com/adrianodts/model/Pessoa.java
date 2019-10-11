package br.com.adrianodts.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pessoa {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codPessoa;
	
	@Column
	private String nomPessoa;
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
	private List<Assinatura> assinaturas;
		
	public Long getCodPessoa() {
		return codPessoa;
	}
	public void setCodPessoa(Long codPessoa) {
		this.codPessoa = codPessoa;
	}
	public String getNomPessoa() {
		return nomPessoa;
	}
	public void setNomPessoa(String nomPessoa) {
		this.nomPessoa = nomPessoa;
	}
	public List<Assinatura> getAssinaturas() {
		return assinaturas;
	}
	public void addAssinaturas(Assinatura assinatura) {
		this.assinaturas.add(assinatura);
	}
}