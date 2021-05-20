package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModelBeans.BeansUsuario;

public class ControleUsuario {
	
	ConexaoBD conex = new ConexaoBD();
	BeansUsuario mod = new BeansUsuario();
	
	public void Salvar(BeansUsuario mod){
		
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("insert into usuarios (usu_nome, login_usuario, tipo_usuario, observacao) values (?,?,?,?)");
			pst.setString(1, mod.getUsu_nome());
			pst.setString(2, mod.getLogin_usuario());
			pst.setString(3, mod.getTipo_usuario());
			pst.setString(4, mod.getObservacao());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Usuario Salvo com sucesso");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao salvar usuario!\nErro: "+ex);
		}
				
			conex.desconectar();
			
			
	}
	
	public void Editar (BeansUsuario mod) {
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("update usuarios set usu_nome=?, login_usuario=?, tipo_usuario=?, observacao=? where usu_cod=?");
			pst.setString(1, mod.getUsu_nome());
			pst.setString(2, mod.getLogin_usuario());
			pst.setString(3, mod.getTipo_usuario());
			pst.setInt(4, mod.getUsu_cod());
			pst.setString(5,mod.getObservacao());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Usuario Alterado com Sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Usuario");
		}
		
		conex.desconectar();
		
		
	}
	
	public void Excluir(BeansUsuario mod) {
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("delete from usuarios where usu_cod=?");
			pst.setInt(1,mod.getUsu_cod());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Usuario Excluido com Sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao excluir usuario");
		}
		
		conex.desconectar();
	}
	
	public BeansUsuario buscaUsuario(BeansUsuario mod) {
		
		conex.conexao();
		conex.executaSQL("select * from usuarios where usu_nome like'%"+ mod.getPesquisa() + "%' or login_usuario like '%"+ mod.getPesquisa() + "%'");
		try {
			conex.rs.last();
			mod.setUsu_cod(conex.rs.getInt("usu_cod"));
			mod.setUsu_nome(conex.rs.getString("usu_nome"));
			mod.setLogin_usuario(conex.rs.getString("login_usuario"));
			mod.setTipo_usuario(conex.rs.getString("tipo_usuario"));
			mod.setObservacao(conex.rs.getString("observacao"));
			
		}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "Usuario não cadastrado\nErro: "+ex);

		}
		conex.desconectar();
		return mod;
	}
	
			
	

}
