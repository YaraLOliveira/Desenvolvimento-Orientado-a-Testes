package com.yaraOliveira.PrimerioTest;
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class CadastroPessoaTest {
	
	//caso de uso CADASTRO - NOVO
	@Test
	public void deveCriarCadastroDePessoa() {
		//cenario e execucao
		CadastroPessoa cadastro = new CadastroPessoa();
		
		//verificao = tem que estar vasio
		Assertions.assertThat(cadastro.getPessoa() ).isEmpty();
	}
	//caso de uso ADICIONAR 
	@Test
	public void deveAdicionarPessoa() {
		//cenario
		CadastroPessoa cadastroPessoa = new CadastroPessoa();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("pedro");
		//execucao adicionar pessoa
		cadastroPessoa.adicionar(pessoa);
		
		//verificacao = nao pode estar vazio; so pode adcionar uma pessoa; e deve conter pessoa;
		Assertions.assertThat(cadastroPessoa.getPessoa())
				.isNotEmpty() // nao pode estar vazia
				.hasSize(1)// deve conter apenas um cadastro
				.contains(pessoa); // e deve conter pessoa
		
	}
	//caso de uso - REMOVER
	@Test 
	public void deveRemoverPessoa() {
		//cenario
		CadastroPessoa cadastro = new CadastroPessoa();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("pedro");
		cadastro.adicionar(pessoa);

		//execucao
		cadastro.remover(pessoa);
		
		//verificaco - retorno deve ser vazio
		Assertions.assertThat(cadastro.getPessoa()).isEmpty();
	}
	
	
	//Regra de negocio
	@Test(expected  = PessoaSemNotException.class)//verificacao
	public void naoDeveCadastrarPessoaSemNome() {
		//cenario
		CadastroPessoa cadastro = new CadastroPessoa();
		Pessoa pessoa = new Pessoa();
		//execução
		cadastro.adicionar(pessoa);
	}
	//verificacao
	@Test(expected = CadastroVazioException.class)
	public  void naoDeveRemoverPessoaInexistente() {
		//cenario
		CadastroPessoa cadastro = new CadastroPessoa();
		Pessoa pessoa = new Pessoa();
		
		//execucao
		cadastro.remover(pessoa);
	}
	 
	
}
