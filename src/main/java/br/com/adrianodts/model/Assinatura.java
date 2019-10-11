package br.com.adrianodts.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Assinatura {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codAssinatura;
		
	@ManyToOne()
	@JoinColumn(name = "codPessoa", nullable = false)
	private Pessoa pessoa;
	
	@ManyToOne()
	@JoinColumn(name = "codProduto", nullable = false)
	private Produto produto;
	
	@OneToMany(mappedBy = "assinatura")

	private List<AssinaturaEndereco> assinaturaEndereco;

	public Long getCodAssinatura() {
		return codAssinatura;
	}

	public void setCodAssinatura(Long codAssinatura) {
		this.codAssinatura = codAssinatura;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<AssinaturaEndereco> getAssinaturaEndereco() {
		return assinaturaEndereco;
	}

	public void setAssinaturaEndereco(List<AssinaturaEndereco> assinaturaEndereco) {
		this.assinaturaEndereco = assinaturaEndereco;
	}
}