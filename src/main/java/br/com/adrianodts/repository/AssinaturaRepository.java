package br.com.adrianodts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.adrianodts.model.Assinatura;
import br.com.adrianodts.model.TipoEndereco;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {

	//TODO: 1 - Escrever um método para fazer uma busca via HQL de todas Pessoas que tem um CEP no endereço de entrega e que assinam um determinado Produto 
	//(ex.: clientes que assinam produto 55 com CEP de entrega 06190001).

	@Query("SELECT aa FROM Assinatura aa JOIN aa.produto pr JOIN aa.pessoa pe JOIN aa.assinaturaEndereco ae WHERE ae.numCep = :numCep AND "
			+ "ae.tipoEndereco = :tipoEndereco")
			//+ "ae.tipoEndereco = :#{T(br.com.adrianodts.model.TipoEndereco).#tipoEndereco}")
	List<Assinatura> obterAssinaturasPorCepTipoEndereco(@Param("numCep") Long numCep, @Param("tipoEndereco") TipoEndereco tipoEndereco);	
}
