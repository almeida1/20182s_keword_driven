package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Usuario;
import br.emprestimo.modelo.UsuarioDAO;

public class UC05CadastrarUsuario {
    public static Usuario usuario;
    public static UsuarioDAO usuarioDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test(expected = RuntimeException.class)
	public void CT01UC03CadasUsuario_ra_invalido_nulo() {
		usuario.setRa("");
	}
	@Test(expected = RuntimeException.class)
	public void CT02UC03CadasUsuario_ra_invalido_nulo() {
		usuario.setRa(null);
	}
	@Test
	public void CT03UC03CadastrarUsuario_validar_equals() {
		Usuario resultadoEsperado = new Usuario();
		resultadoEsperado.setRa("121212");
		resultadoEsperado.setNome("Carlos Xavier");
		assertTrue(resultadoEsperado.equals(usuario));
	}
	@Test
	public void CT04UC03CadastrarUsuario_com_sucesso() {
		//cenario
		usuario = ObtemUsuario.comDadosValidos();
		usuarioDAO = new UsuarioDAO();
		//acao
		int rc = usuarioDAO.adiciona(usuario);
		//verificacao
		assertEquals(1,rc);
		usuarioDAO.exclui(usuario.getRa());
	}
}
