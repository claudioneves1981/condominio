/*package controller;

import model.Proprietario;
import service.DBConnection;

import javax.swing.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProprietarioController {
	
	DBConnection conex = new DBConnection();

	public void Salvar(Proprietario mod){
		
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("insert into pessoa (nome, documento, "
																+ "data_cadastro, id_endereco, id_apto, id_contato, tipo) "
																+ "values (?,?,?,?,?,?,?)");
			pst.setString(1, mod.getNome());
			pst.setString(2, mod.getDocumento());
			pst.setDate(3, Date.valueOf(mod.getDataCadastro()));
			pst.setLong(4, mod.getEndereco().getId());
			pst.setLong(5,mod.getChaveComposta().getApto().getId());
			pst.setLong(6 ,mod.getChaveComposta().getContato().getId());
			pst.setString(7, mod.getTipo().toString());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Proprietario Salvo com sucesso");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, STR."""
Erro ao salvar proprietario!
Erro: \{ex}""");
		}
				
			conex.desconectar();
			
			
	}
	
	public void Editar (Proprietario mod) {
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("update pessoa set nome=?, documento=?, data_cadastro=?,"
																+ "id_endereco=?, id_apto=?, id_contato=?"
																+ "tipo=? where codigo=?");
			pst.setString(1, mod.getNome());
			pst.setString(2, mod.getDocumento());
			pst.setDate(3, Date.valueOf(mod.getDataCadastro()));
			pst.setLong(4, mod.getEndereco().getId());
			pst.setLong(5,mod.getChaveComposta().getApto().getId());
			pst.setLong(6 ,mod.getChaveComposta().getContato().getId());
			pst.setString(7, mod.getTipo().toString());
			pst.setLong(8, mod.getCodigo());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Proprietario Salvo com sucesso");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, STR."""
Erro ao salvar proprietario!
Erro: \{ex}""");
		}
				
			conex.desconectar();
		
	}
	
	public void Excluir(Proprietario mod) {
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("delete from proprietario where codigo=?");
			pst.setLong(1,mod.getCodigo());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Proprietario/Morador Excluido com Sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao excluir Proprietario / Morador");
		}
		
		conex.desconectar();
	}
	
	public Proprietario buscarProprietario(Proprietario mod) {
		
		conex.conexao();
		conex.executaSQL(STR."select * from pessoa where nome like '%\{mod.getPesquisa()}%'");
		try {
			conex.rs.last();
			mod.setCodigo(conex.rs.getLong("id"));
			mod.setNome(conex.rs.getString("nome"));
			mod.getChaveComposta().getApto().setApto(conex.rs.getString("apto"));
			mod.getChaveComposta().getApto().setBloco(conex.rs.getString("bloco"));
			mod.setDocumento(conex.rs.getString("documento"));
			mod.getChaveComposta().getContato().setTelefone(conex.rs.getString("telefone"));
			mod.getChaveComposta().getContato().setEmail(conex.rs.getString("email"));
			mod.setDataCadastro(conex.rs.getDate("data_cadastro").toLocalDate());
			mod.getEndereco().setEndereco(conex.rs.getString("endereco"));
			mod.getEndereco().setNumero(conex.rs.getString("numero"));
			mod.getEndereco().setComplemento(conex.rs.getString("complemento"));
			mod.getEndereco().setBairro(conex.rs.getString("bairro"));
			mod.getEndereco().setCep(conex.rs.getString("cep"));
			mod.getEndereco().setCidade(conex.rs.getString("cidade"));
			mod.getEndereco().setEstado(conex.rs.getString("estado"));
			mod.getTipo().setDescricao(conex.rs.getString("tipo"));

			
		}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, STR."""
Proprietario n�o cadastrado
Erro: \{ex}""");

		}
		conex.desconectar();
		return mod;
	}

}*/
