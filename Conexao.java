package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private Connection conexao;

	public Conexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//String url = "jdbc:mysql://localhost/trabalhoear";
			String url = "jdbc:mysql://localhost/trabalhoear?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
					
			conexao = DriverManager.getConnection(url, "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public void desconecta() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
