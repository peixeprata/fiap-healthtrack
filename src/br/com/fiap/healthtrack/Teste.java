package br.com.fiap.healthtrack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Teste {

	public static void main(String[] args) {
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM82502", "040594");

			System.out.println("Conectou!"); 


			conexao.close();

		}
		catch (SQLException e) 
		{
			System.err.println("Não foi possível conectar ao Oracle FIAP");
			e.printStackTrace();

		}
		catch (ClassNotFoundException e) 
		{
			System.err.println("O Driver JDBC não foi encontrado!");
			e.printStackTrace();

		}

	}
}




