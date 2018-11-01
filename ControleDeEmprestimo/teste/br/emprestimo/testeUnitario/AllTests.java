package br.emprestimo.testeUnitario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UC01CadastrarLivroV1.class, UC01CadastrarLivroV2.class, UC01CadastrarLivroV3.class,
		UC02ConsultarLivro.class, UC05CadastrarUsuario.class, UC09RegistraEmprestimoDeLivro.class,
		UC09RegistraEmprestimoDeLivroV1.class, UC09RegistraEmprestimoDeLivroV2.class })
public class AllTests {

}
