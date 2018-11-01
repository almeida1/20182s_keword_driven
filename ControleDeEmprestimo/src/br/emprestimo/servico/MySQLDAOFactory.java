package br.emprestimo.servico;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import br.emprestimo.modelo.EmprestimoDAO;
import br.emprestimo.modelo.LivroDAO;
import br.emprestimo.modelo.UsuarioDAO;

public class MySQLDAOFactory extends DAOFactory {
	static Logger logger = Logger.getLogger(MySQLDAOFactory.class);

	ConfiguraDB configura;
	public MySQLDAOFactory(ConfiguraDB c){
		configura = c;
	}
	// method to create MySQL connections
	public static Connection createConnection() {
		try {
			Class.forName(c.getDriver());
			
			return (Connection) DriverManager.getConnection(c.getUrl(),c.getUsuario(),c.getSenha());
			}
		catch (CommunicationsException e){
			logger.info("Exceçãoo de comunicacao com o DB causa: " + e.getMessage());
			
			throw new RuntimeException(e); 
		}
		catch (SQLException e){
			logger.info("Exceção geral causa SQLException: " + e.getMessage() + ";" + e.getErrorCode());
			
			throw new RuntimeException(e); 
		}
		catch (Exception e){
			logger.info("Exceção geral causa: " + e.getMessage());
			
			throw new RuntimeException(e); 
		}
	  }
	@Override
	public EmprestimoDAO getEmprestimoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivroDAO getLivroDAO() {
		return new LivroDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
