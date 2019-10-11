package br.com.adrianodts.repository;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import br.com.adrianodts.model.Assinatura;
import br.com.adrianodts.model.AssinaturaEndereco;
import br.com.adrianodts.model.TipoEndereco;
import br.com.adrianodts.spring.conf.JPAConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes = { JPAConfiguration.class }, 
		loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext
public class AssinaturaRepositoryTest {
	
	@Resource	
	private AssinaturaRepository repository;
	
	@Test
	public void testObterAssinaturasPorCepTipoEndereco() {
		
		List<Assinatura> assinaturas = repository.obterAssinaturasPorCepTipoEndereco(11111111L, TipoEndereco.ENTREGA);
		
		for (Assinatura assinatura : assinaturas) {
			
			System.out.println("ASSINATURA: " + assinatura.getCodAssinatura());
			System.out.println("PRODUTO   : " + assinatura.getProduto().getDescricao());
			System.out.println("PESSOA    : " + assinatura.getPessoa().getNomPessoa());	
			
			for (AssinaturaEndereco endereco : assinatura.getAssinaturaEndereco()) {
				System.out.println("CEP: " + endereco.getNumCep().toString());
				System.out.println("TIPO ENDERECO: " + endereco.getTipoEndereco());				
			}
		}
	}
}

