package br.emprestimo.servico;

import org.apache.log4j.Logger;

/**
 * Configuracao do banco de dados
 * @author esa
 *
 */

public class ConfiguraDB {
	
	static Logger logger = Logger.getLogger(ConfiguraDB.class);
	static String url = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false";
	static String driver = "com.mysql.jdbc.Driver";
	static String usuario = "root";
	static String senha = "";
	
	public ConfiguraDB(String url, String driver, String usuario, String senha) {
		this.url = url;
		this.driver = driver;
		this.usuario = usuario;
		this.senha = senha;
	}
	public ConfiguraDB(){
		
	}
	public String getUrl() {
		return url;
	}
	public String getDriver() {
		return driver;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
	
	
}



