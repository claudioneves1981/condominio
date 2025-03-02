package service;

import javax.swing.*;
import java.sql.*;

public class DBConnection {

	public Statement stm;
	public ResultSet rs;
	public Connection con;
	
	public void conexao(){

		String driver = "org.sqlite.JDBC";
		System.setProperty("jdbc.Drivers", driver);
		try {
			String local = "jdbc:sqlite:src/database/condominio.db";
			String usuario = "";
			String password = "";
			con = DriverManager.getConnection(local, usuario, password);
		//JOptionPane.showMessageDialog(null,"Sistema conectado com sucesso");
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, STR."""
Erro ao conectar
\{ex.getMessage()}""");
		}
	}
	
	public void executaSQL(String sql) {
		try {
			stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, STR."""
Erro ao executar SQL
 Erro: \{ex.getMessage()}""");
		}
	}
	
	public void desconectar() {
		try {
			con.close();
		//	JOptionPane.showMessageDialog(null,"Sistema desconectado com sucesso");

		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, STR."Erro ao desconectar do sistema\{ex.getMessage()}");

		}
	}

}
