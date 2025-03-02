/*package controller;

import model.Visitante;
import service.DBConnection;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioController {
	
	DBConnection conex = new DBConnection();

	public void Salvar(Visitante mod){
		
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("insert into usuario (nome, documento, tipo, observacao) values (?,?,?,?)");
			pst.setString(1, mod.getNome());
			pst.setString(2, mod.getDocumento());
			pst.setString(3, mod.getTipo());
			pst.setString(4, mod.getObservacao());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Usuario Salvo com sucesso");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao salvar usuario!\nErro: "+ex);
		}
				
			conex.desconectar();
			
			
	}
	
	public void Editar (Visitante mod) {
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("update usuario set nome=?, documento=?, tipo=?, observacao=? where codigo=?");
			pst.setString(1, mod.getNome());
			pst.setString(2, mod.getDocumento());
			pst.setString(3, mod.getTipo());
			pst.setInt(4, mod.getCodigo());
			pst.setString(5,mod.getObservacao());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Usuario Alterado com Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Usuario");
		}
		
		conex.desconectar();
		
		
	}
	
	public void Excluir(Visitante mod) {
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("delete from usuario where codigo=?");
			pst.setInt(1,mod.getCodigo());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Usuario Excluido com Sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao excluir usuario");
		}
		
		conex.desconectar();
	}
	
	public Visitante buscaUsuario(Visitante mod) {
		
		conex.conexao();
		conex.executaSQL("select * from usuario where nome like'%"+ mod.getPesquisa() + "%' or documento like '%"+ mod.getPesquisa() + "%'");
		try {
			conex.rs.last();
			mod.setCodigo(conex.rs.getInt("codigo"));
			mod.setNome(conex.rs.getString("nome"));
			mod.setDocumento(conex.rs.getString("documento"));
			mod.setTipo(conex.rs.getString("tipo"));
			mod.setObservacao(conex.rs.getString("observacao"));
			
		}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "Usuario n�o cadastrado\nErro: "+ex);

		}
		conex.desconectar();
		return mod;
	}
}*/
