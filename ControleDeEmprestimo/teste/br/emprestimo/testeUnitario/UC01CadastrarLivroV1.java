package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import org.junit.Test;

import br.emprestimo.modelo.Livro;

public class UC01CadastrarLivroV1 {

	@Test
	public void CT01CadastrarLivroComDadosValidos(){
		try{
			//cenario
			Livro umLivro = new Livro();
			//acao
			umLivro.setIsbn("121212");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
		}catch(RuntimeException e){
			//verificacao
			fail ("nao deve falhar");
		}
	}
	@Test
	public void CT02cadastrarLivroComISBN_em_branco(){
		//cenario
		String isbn="";
		Livro livro = new Livro();
		try{
		//acao
			livro.setIsbn(isbn);
			fail ("deveria lançar uma exceção");
		}catch(RuntimeException e){
		//verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
	@Test
	public void CT03cadastrarLivroComISBN_nulo(){
		//cenario
		String isbn=null;
		Livro livro = new Livro();
		try{
		//acao
			livro.setIsbn(isbn);
			fail ("deveria lançar uma exceção");
		}catch(RuntimeException e){
		//verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}

}
