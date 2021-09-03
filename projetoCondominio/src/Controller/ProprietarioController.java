package controller;

import model.Proprietario;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProprietarioController {
	
	DBConnection conex = new DBConnection();

	public void Salvar(Proprietario mod){
		
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("insert into proprietario (nome, apto, "
																+ "bloco, cpf, telefone, "
																+ "email, data_cadastro, endereco, numero, "
																+ "complemento, bairro, cep, cidade , estado, tipo) "
																+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, mod.getNome());
			pst.setString(2, mod.getApto());
			pst.setString(3, mod.getBloco());
			pst.setString(4, mod.getCpf());
			pst.setString(5, mod.getTelefone());
			pst.setString(6, mod.getEmail());
			pst.setString(7, mod.getDataCadastro());
			pst.setString(8, mod.getEndereco());
			pst.setString(9, mod.getNumero());
			pst.setString(10,mod.getComplemento());
			pst.setString(11,mod.getBairro());
			pst.setString(12,mod.getCep());
			pst.setString(13,mod.getCidade());
			pst.setString(14,mod.getEstado());
			pst.setString(15,mod.getTipo());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Proprietario Salvo com sucesso");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao salvar proprietario!\nErro: "+ex);
		}
				
			conex.desconectar();
			
			
	}
	
	public void Editar (Proprietario mod) {
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("update proprietario set nome=?, apto=?, bloco=?, "
																+ "cpf=?, telefone=?, email=?, data_cadastro=?,"
																+ "endereco=?, numero=?, complemento=?, bairro=?, cep=?, cidade=?, estado=?, "
																+ "tipo=? where codigo=?");
			pst.setString(1, mod.getNome());
			pst.setString(2, mod.getApto());
			pst.setString(3, mod.getBloco());
			pst.setString(4, mod.getCpf());
			pst.setString(5, mod.getTelefone());
			pst.setString(6, mod.getEmail());
			pst.setString(7, mod.getDataCadastro());
			pst.setString(8, mod.getEndereco());
			pst.setString(9, mod.getNumero());
			pst.setString(10,mod.getComplemento());
			pst.setString(11,mod.getBairro());
			pst.setString(12,mod.getCep());
			pst.setString(13,mod.getCidade());
			pst.setString(14,mod.getEstado());
			pst.setString(15,mod.getTipo());
			pst.setInt(16,mod.getCodigo());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Proprietario Salvo com sucesso");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao salvar proprietario!\nErro: "+ex);
		}
				
			conex.desconectar();
		
	}
	
	public void Excluir(Proprietario mod) {
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("delete from proprietario where codigo=?");
			pst.setInt(1,mod.getCodigo());
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
		conex.executaSQL("select * from proprietario where nome like '%"+mod.getPesquisa()+"%'");
		try {
			conex.rs.last();
			mod.setCodigo(conex.rs.getInt("id"));
			mod.setNome(conex.rs.getString("nome"));
			mod.setApto(conex.rs.getString("apto"));
			mod.setBloco(conex.rs.getString("bloco"));
			mod.setCpf(conex.rs.getString("cpf"));
			mod.setTelefone(conex.rs.getString("telefone"));
			mod.setEmail(conex.rs.getString("email"));
			mod.setDataCadastro(conex.rs.getString("dataCadastro"));
			mod.setEndereco(conex.rs.getString("endereco"));
			mod.setNumero(conex.rs.getString("numero"));
			mod.setComplemento(conex.rs.getString("complemento"));
			mod.setBairro(conex.rs.getString("bairro"));
			mod.setCep(conex.rs.getString("cep"));
			mod.setCidade(conex.rs.getString("cidade"));
			mod.setEstado(conex.rs.getString("estado"));
			mod.setTipo(conex.rs.getString("tipo"));

			
		}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "Proprietario n�o cadastrado\nErro: "+ex);

		}
		conex.desconectar();
		return mod;
	}

}
