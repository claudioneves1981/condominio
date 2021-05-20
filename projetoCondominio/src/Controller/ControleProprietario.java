package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModelBeans.BeansProprietario;
import ModelBeans.BeansUsuario;

public class ControleProprietario {
	
	ConexaoBD conex = new ConexaoBD();
	BeansProprietario mod = new BeansProprietario();
	
	public void Salvar(BeansProprietario mod){
		
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("insert into proprietarios (nome_proprietario, lote_proprietario, "
																+ "quadra_proprietario, cpf_proprietario, telefone_proprietario, "
																+ "email_proprietario, data_cadastro, endereco, numero_endereco, "
																+ "complemento, bairro, cep, cidade , estado, tipo_proprietario) "
																+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, mod.getNome_proprietario());
			pst.setString(2, mod.getLote_proprietario());
			pst.setString(3, mod.getQuadra_proprietario());
			pst.setString(4, mod.getCpf_proprietario());
			pst.setString(5, mod.getTelefone_proprietario());
			pst.setString(6, mod.getEmail_proprietario());
			pst.setString(7, mod.getData_cadastro());
			pst.setString(8, mod.getEndereco());
			pst.setString(9, mod.getNumero_endereco());
			pst.setString(10,mod.getComplemento());
			pst.setString(11,mod.getBairro());
			pst.setString(12,mod.getCep());
			pst.setString(13,mod.getCidade());
			pst.setString(14,mod.getEstado());
			pst.setString(15,mod.getTipo_proprietario());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Proprietario Salvo com sucesso");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao salvar proprietario!\nErro: "+ex);
		}
				
			conex.desconectar();
			
			
	}
	
	public void Editar (BeansProprietario mod) {
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("update proprietarios set nome_proprietario=?, lote_proprietario=?, quadra_proprietario=?, "
																+ "cpf_proprietario=?, telefone_proprietario=?, email_proprietario=?, data_cadastro=?,"
																+ "endereco=?, numero_endereco=?, complemento=?, bairro=?, cep=?, cidade=?, estado=?, "
																+ "tipo_proprietario=? where id_proprietario=?");
			pst.setString(1, mod.getNome_proprietario());
			pst.setString(2, mod.getLote_proprietario());
			pst.setString(3, mod.getQuadra_proprietario());
			pst.setString(4, mod.getCpf_proprietario());
			pst.setString(5, mod.getTelefone_proprietario());
			pst.setString(6, mod.getEmail_proprietario());
			pst.setString(7, mod.getData_cadastro());
			pst.setString(8, mod.getEndereco());
			pst.setString(9, mod.getNumero_endereco());
			pst.setString(10,mod.getComplemento());
			pst.setString(11,mod.getBairro());
			pst.setString(12,mod.getCep());
			pst.setString(13,mod.getCidade());
			pst.setString(14,mod.getEstado());
			pst.setString(15,mod.getTipo_proprietario());
			pst.setInt(16,mod.getCodigo_proprietario());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Proprietario Salvo com sucesso");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao salvar proprietario!\nErro: "+ex);
		}
				
			conex.desconectar();
		
	}
	
	public void Excluir(BeansProprietario mod) {
		conex.conexao();
		
		try {
			PreparedStatement pst = conex.con.prepareStatement("delete from proprietarios where id_proprietario=?");
			pst.setInt(1,mod.getCodigo_proprietario());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Proprietario/Morador Excluido com Sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao excluir Proprietario / Morador");
		}
		
		conex.desconectar();
	}
	
	public BeansProprietario buscarProprietario(BeansProprietario mod) {
		
		conex.conexao();
		conex.executaSQL("select * from proprietarios where nome_proprietario like '%"+mod.getPesquisa()+"%'");
		try {
			conex.rs.last();
			mod.setCodigo_proprietario(conex.rs.getInt("id_proprietario"));
			mod.setNome_proprietario(conex.rs.getString("nome_proprietario"));
			mod.setLote_proprietario(conex.rs.getString("lote_proprietario"));
			mod.setQuadra_proprietario(conex.rs.getString("quadra_proprietario"));
			mod.setCpf_proprietario(conex.rs.getString("cpf_proprietario"));
			mod.setTelefone_proprietario(conex.rs.getString("telefone_proprietario"));
			mod.setEmail_proprietario(conex.rs.getString("email_proprietario"));
			mod.setData_cadastro(conex.rs.getString("data_cadastro"));
			mod.setEndereco(conex.rs.getString("endereco"));
			mod.setNumero_endereco(conex.rs.getString("numero_endereco"));
			mod.setComplemento(conex.rs.getString("complemento"));
			mod.setBairro(conex.rs.getString("bairro"));
			mod.setCep(conex.rs.getString("cep"));
			mod.setCidade(conex.rs.getString("cidade"));
			mod.setEstado(conex.rs.getString("estado"));
			mod.setTipo_proprietario(conex.rs.getString("tipo_proprietario"));

			
		}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "Proprietario não cadastrado\nErro: "+ex);

		}
		conex.desconectar();
		return mod;
	}

}
