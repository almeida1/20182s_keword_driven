package br.emprestimo.servico;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class FabricaDeConexoes {
	Logger logger = Logger.getLogger(FabricaDeConexoes.class);
	String url = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false";
	//String url = "jdbc:mysql://mysql8.db4free.net:3306/sceweb";
	String driver = "com.mysql.jdbc.Driver";
	String usuario = "root";
	String senha = "alunofatec";
	
	public FabricaDeConexoes (ConfiguraDB configura){
		this.url = configura.getUrl();
		this.driver = configura.getDriver();
		this.usuario = configura.getUsuario();
		this.senha = configura.getSenha();
	}
	public FabricaDeConexoes(){
		
	}
	public Connection getConnection(){
		try {
			Class.forName(driver);
			logger.info("fabrica de conexoes = " + senha);
			return (Connection) DriverManager.getConnection(url,usuario,senha);
			}
		catch (CommunicationsException e){
			logger.info("Exce��oo de comunicacao com o DB causa: " + e.getMessage());
			
			throw new RuntimeException(e); 
		}
		catch (SQLException e){
			logger.info("Exce��o geral causa SQLException: " + e.getMessage() + ";" + e.getErrorCode());
			
			throw new RuntimeException(e); 
		}
		catch (Exception e){
			logger.info("Exce��oo geral causa: " + e.getMessage());
			
			throw new RuntimeException(e); 
		}
	}
}

