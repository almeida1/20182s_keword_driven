package br.emprestimo.servico;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;

public class ServicoEmprestimo {
	Logger logger = Logger.getLogger("ServicoEmprestimo");
	public Emprestimo empresta(Livro livro, Usuario usuario) {
		if (livro == null | usuario == null) {
			throw new RuntimeException("Dados inválidos.");
		} else {
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setLivro(livro);
			emprestimo.setUsuario(usuario);
			// data do emprestimo - data atual do sistema
			DateTime dataAtual = new DateTime();
			DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
			emprestimo.setDataEmprestimo(dataAtual.toString(fmt));
			// prazo de devolucao 8 dias
			DateTime dataDevolucao = fmt.parseDateTime(emprestimo.getDataEmprestimo());
			emprestimo.setDataDevolucao(dataDevolucao.plusDays(8).toString(fmt));
			logger.info("servico emprestimo data devolucao=> " + emprestimo.getDataDevolucao());
			logger.info("servico emprestimo data emprestimo=> " + emprestimo.getDataEmprestimo());
			return emprestimo;
		}
	}

}
