package controller;

import javax.swing.*;
import java.sql.*;

public class DBConnection {

	public Statement stm;
	public ResultSet rs;
	public Connection con;
	
	public void conexao(){

		String driver = "org.postgresql.Driver";
		System.setProperty("jdbc.Drivers", driver);
		try {
			String local = "jdbc:postgresql://localhost:5432/condominiobd";
			String usuario = "postgres";
			String password = "@Neves123";
			con = DriverManager.getConnection(local, usuario, password);
		//JOptionPane.showMessageDialog(null,"Sistema conectado com sucesso");
		} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null,"Erro ao conectar\n"+ ex.getMessage());
		}
	}
	
	public void executaSQL(String sql) {
		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Erro ao executar SQL\n Erro: "+ ex.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			con.close();
		//	JOptionPane.showMessageDialog(null,"Sistema desconectado com sucesso");

		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Erro ao desconectar do sistema"+ex.getMessage());

		}
	}

}
