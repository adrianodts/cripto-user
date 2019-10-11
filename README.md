# Projeto: cripto-user


## Visão Geral 

Ex 1:
Escreva uma função que receba de entrada uma lista de nomes e senhas de usuários e armazene estes dados com segurança, de forma que os dados sensíveis não sejam facilmente obtidos
Posteriormente o programa recebe um nome de usuário e senha e valida se este usuário e senha consta ou não da lista recebida.


Ex 2:
Dado a seguinte estrutura de dados mapeada em uma classe a partir do Hibernate.

```
@Entity
public class Pessoa {
	@Id
	@Column
	private Long codPessoa;
	@Column
	private String nomPessoa;
}
```

```
@Entity
public class Assinatura {
	@Id
	@Column
	private Long codAssinatura;
	@Column
	private Long codPessoa;
	@Column
	private Long codProduto;
}
```

```
@Entity
public class AssinaturaEndereco {
	@Id
	@Column
	private Long codAssinaturaEndereco;
	@Column
	private Long codAssinatura;
	@Column
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;
	@Column
	private Long numCep;
}
```

```
public enum TipoEndereco {
	ENTREGA,
	COBRANCA
}
```

1 - Escrever um método para fazer uma busca via HQL de todas Pessoas que tem um CEP no endereço de entrega e que assinam um determinado Produto (ex.: clientes que assinam produto 55 com CEP de entrega 06190001).


#####`Para testar o método, foi criado uma classe de teste unitário:  AssinaturaRepositoryTest.java, em /src/teste/java/br.com.adrianodts.repository. Basta executar a classe com o JUNIT e vizualizar a querie gerada no console. Observação: Ao iniciar o teste, é realizado um bootstrap onde são realizados alguns inserts nas tabelas, através do arquivo insert.sql.`

2 - quais índices indicaria para criação para melhorar a performance desta busca? em qual prioridade e por que?

#####`Em primeiro lugar os índices que fazem parte da chave primária e chave estrangeira são os que tem maior prioridade  e são os mais indicados, pois esses campos são utilizados nos (JOINS) e podem deixar a consulta com maior performance. Em segundo lugar, os campos envolvidos nos filtros, ou seja, na clausula (WHERE), que neste caso é o CEP apenas. Mesmo fazendo parte do filtro, o campo Tipo Endereço não deve ser indexado, pois pode armazenar apenas dois tipos de valores e haverá repetição nas linhas, não se tornando seletivo para ter um indice. Uma observação importante é que às vezes um indice mal planejado pode acarretar diversos danos na performance de uma aplicação, por exemplo: pode-se melhorar a performance de queries de (SELECT), porém podem degradar as queries de manipulação de dados (UPDATE, INSERT e DELETE).`


3 - qual a query SQL de saída esperada?

#####`SELECT aa FROM Assinatura aa JOIN aa.produto pr JOIN aa.pessoa pe JOIN aa.assinaturaEndereco ae WHERE ae.numCep = :numCep AND ae.tipoEndereco = :tipoEndereco`

Nota:
- As colunas com o mesmo nome representam uma FK com a entidade onde esta coluna é ID (ex.: Assinatura.codPessoa é uma FP de Pessoa.codPessoa).
- Alterar as classes conforme necessário para ligar as entidades.


### Executando o sistema 

- Realizar o download do zip ou clonar repositorio Git.

- Descompactar o arquivo zipado (apenas se fez o download do zip)

- Abra o Eclipse e importe o projeto:	
	- File -> Import -> Existing Maven Project -> Next -> Navegue ao diretório onde você descompactou o arquivo zipado.
	- Selecione o projeto (/pom.xml ...) e clique em finalizar.


#### Requitos

- Eclipse
- Maven 
- Tomcat


### Instrução para validação e testes

Ex 1: Run as --> Java Aplication -> br.com.adrianodts.program.Main.java 

Ex 2: Run as --> JUnit Test -> br.com.adrianodts.repository.AssinaturaRepositoryTest.java 

