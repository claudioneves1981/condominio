package view;

import dao.PessoaJpaDAO;
import model.*;
import service.DBConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProprietarioView extends JFrame {
	
	DBConnection conex = new DBConnection();
	//PessoaController control = new PessoaController();
	Pessoa mod;
	
	int flag = 0;

	private final JTable jTablePessoas;
	private final JTextField jTextFieldPesquisar;
	private final ButtonGroup buttonGroupCadastro = new ButtonGroup();
	private final JTextField jTextFieldDataCadastro;
	private final JTextField jTextFieldCod;
	private final JTextField jTextFieldNomePessoa;
	private final JTextField jTextFieldBloco;
	private final JTextField jTextFieldApto;
	private final JTextField jTextFieldEmailPessoa;
	private final JTextField jTextFieldEnderecoPessoa;
	private final JTextField jTextFieldEnderecoNumero;
	private final JTextField jTextFieldComplemento;
	private final JTextField jTextFieldBairro;
	private final JTextField jTextFieldCep;
	private final JTextField jTextFieldCidade;
	private final JTextField jTextFieldEstado;
	private final JFormattedTextField jFormattedFonePessoa;
	private final JFormattedTextField jFormattedCpf;
	private final JInternalFrame jInternalFrameCadastroEndereco;
	private final JInternalFrame jInternalFramePrincipal;
	private final ButtonGroup buttonGroupEndereco = new ButtonGroup();
	@SuppressWarnings("rawtypes")
	private final JComboBox jComboBoxTipoMorador;
	private final JButton jButtonNovo;
	private final JButton jButtonEditar;
	private final JButton jButtonSalvar;
	private final JButton jButtonExcluir;
	private final JButton jButtonCancelar;
	private final JButton jButtonPesquisar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ProprietarioView frame = new ProprietarioView();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}


	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ProprietarioView() {
				
		jInternalFrameCadastroEndereco = new JInternalFrame("Endere\u00E7o da Cidade onde Mora");
		jInternalFramePrincipal = new JInternalFrame("Cadastro do Propriet\u00E1rio / Morador");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1199, 818);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informa\u00E7\u00F5es Propriet\u00E1rio / Morador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(38, 99, 1135, 639);
		contentPane.add(panel);
		panel.setLayout(null);
		
		jInternalFramePrincipal.setToolTipText("Cadastro do Proprietário/Morador");
		jInternalFramePrincipal.setBounds(10, 24, 1115, 555);
		panel.add(jInternalFramePrincipal);
		jInternalFramePrincipal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data.:");
		lblNewLabel.setBounds(10, 25, 65, 14);
		jInternalFramePrincipal.getContentPane().add(lblNewLabel);
		
		jTextFieldDataCadastro = new JTextField();
		jTextFieldDataCadastro.setBounds(47, 22, 86, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldDataCadastro);
		jTextFieldDataCadastro.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo.:");
		lblNewLabel_1.setBounds(10, 60, 46, 14);
		jInternalFramePrincipal.getContentPane().add(lblNewLabel_1);
		
		jTextFieldCod = new JTextField();
		jTextFieldCod.setBounds(57, 57, 86, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldCod);
		jTextFieldCod.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 1104, 359);
		panel.add(scrollPane);
		jTablePessoas = new JTable();
		scrollPane.setViewportView(jTablePessoas);
		jTablePessoas.setBorder(new LineBorder(new Color(0, 0, 0)));
		jTablePessoas.setBounds(20, 200, 930, 260);

		JButton JButtonFecharInternalFramePrincipal = new JButton("Fechar");
		JButtonFecharInternalFramePrincipal.addActionListener(e -> {

			jInternalFramePrincipal.dispose();
			jInternalFrameCadastroEndereco.dispose();
			buttonGroupCadastro.clearSelection();
			buttonGroupEndereco.clearSelection();

		});
		JButtonFecharInternalFramePrincipal.setBounds(953, 25, 89, 23);
		jInternalFramePrincipal.getContentPane().add(JButtonFecharInternalFramePrincipal);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(181, 60, 39, 14);
		jInternalFramePrincipal.getContentPane().add(lblNewLabel_2);
		
		jTextFieldNomePessoa = new JTextField();
		jTextFieldNomePessoa.setBounds(230, 57, 383, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldNomePessoa);
		jTextFieldNomePessoa.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Bloco");
		lblNewLabel_3.setBounds(636, 60, 30, 14);
		jInternalFramePrincipal.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Apto");
		lblNewLabel_4.setBounds(768, 60, 28, 14);
		jInternalFramePrincipal.getContentPane().add(lblNewLabel_4);
		
		jTextFieldBloco = new JTextField();
		jTextFieldBloco.setBounds(672, 57, 86, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldBloco);
		jTextFieldBloco.setColumns(10);
		
		jTextFieldApto = new JTextField();
		jTextFieldApto.setBounds(806, 57, 86, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldApto);
		jTextFieldApto.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CPF");
		lblNewLabel_5.setBounds(10, 98, 46, 14);
		jInternalFramePrincipal.getContentPane().add(lblNewLabel_5);
		
		jFormattedCpf = new JFormattedTextField();
		jFormattedCpf.setBounds(32, 95, 170, 20);
		jInternalFramePrincipal.getContentPane().add(jFormattedCpf);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone");
		lblNewLabel_6.setBounds(230, 98, 46, 14);
		jInternalFramePrincipal.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		lblNewLabel_7.setBounds(462, 98, 39, 14);
		jInternalFramePrincipal.getContentPane().add(lblNewLabel_7);
		
		jFormattedFonePessoa = new JFormattedTextField();
		jFormattedFonePessoa.setBounds(284, 95, 146, 20);
		jInternalFramePrincipal.getContentPane().add(jFormattedFonePessoa);
		
		jTextFieldEmailPessoa = new JTextField();
		jTextFieldEmailPessoa.setBounds(503, 95, 389, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldEmailPessoa);
		jTextFieldEmailPessoa.setColumns(10);
		
		jInternalFrameCadastroEndereco.setToolTipText("Endere\u00E7o da Cidade onde Mora");
		jInternalFrameCadastroEndereco.setBounds(10, 167, 1079, 136);
		jInternalFramePrincipal.getContentPane().add(jInternalFrameCadastroEndereco);
		jInternalFrameCadastroEndereco.getContentPane().setLayout(null);
		
		JCheckBox jCheckBoxEndereco = new JCheckBox("O Propriet\u00E1rio n\u00E3o Mora no Condominio");
		buttonGroupEndereco.add(jCheckBoxEndereco);
		jCheckBoxEndereco.addActionListener(e -> {
			if(jCheckBoxEndereco.isSelected()) {
				jInternalFrameCadastroEndereco.setVisible(true);
				mod = (Proprietario) mod;
			} else {
				mod = (Morador) mod;
			}
		});
		jCheckBoxEndereco.setBounds(10, 135, 266, 23);
		jInternalFramePrincipal.getContentPane().add(jCheckBoxEndereco);
		
		JLabel lblNewLabel_8 = new JLabel("Endere\u00E7o");
		lblNewLabel_8.setBounds(25, 24, 76, 14);
		jInternalFrameCadastroEndereco.getContentPane().add(lblNewLabel_8);
		
		jTextFieldEnderecoPessoa = new JTextField();
		jTextFieldEnderecoPessoa.setBounds(91, 21, 543, 20);
		jInternalFrameCadastroEndereco.getContentPane().add(jTextFieldEnderecoPessoa);
		jTextFieldEnderecoPessoa.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("N\u00BA");
		lblNewLabel_9.setBounds(644, 24, 46, 14);
		jInternalFrameCadastroEndereco.getContentPane().add(lblNewLabel_9);
		
		jTextFieldEnderecoNumero = new JTextField();
		jTextFieldEnderecoNumero.setBounds(664, 21, 86, 20);
		jInternalFrameCadastroEndereco.getContentPane().add(jTextFieldEnderecoNumero);
		jTextFieldEnderecoNumero.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Complemento");
		lblNewLabel_10.setBounds(777, 24, 46, 14);
		jInternalFrameCadastroEndereco.getContentPane().add(lblNewLabel_10);
		
		jTextFieldComplemento = new JTextField();
		jTextFieldComplemento.setBounds(822, 21, 134, 20);
		jInternalFrameCadastroEndereco.getContentPane().add(jTextFieldComplemento);
		jTextFieldComplemento.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Bairro");
		lblNewLabel_11.setBounds(25, 70, 46, 14);
		jInternalFrameCadastroEndereco.getContentPane().add(lblNewLabel_11);
		
		jTextFieldBairro = new JTextField();
		jTextFieldBairro.setBounds(55, 67, 243, 20);
		jInternalFrameCadastroEndereco.getContentPane().add(jTextFieldBairro);
		jTextFieldBairro.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("CEP");
		lblNewLabel_12.setBounds(349, 70, 46, 14);
		jInternalFrameCadastroEndereco.getContentPane().add(lblNewLabel_12);
		
		jTextFieldCep = new JTextField();
		jTextFieldCep.setBounds(376, 67, 86, 20);
		jInternalFrameCadastroEndereco.getContentPane().add(jTextFieldCep);
		jTextFieldCep.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Cidade");
		lblNewLabel_13.setBounds(501, 70, 46, 14);
		jInternalFrameCadastroEndereco.getContentPane().add(lblNewLabel_13);
		
		jTextFieldCidade = new JTextField();
		jTextFieldCidade.setBounds(541, 67, 86, 20);
		jInternalFrameCadastroEndereco.getContentPane().add(jTextFieldCidade);
		jTextFieldCidade.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Estado");
		lblNewLabel_14.setBounds(684, 70, 46, 14);
		jInternalFrameCadastroEndereco.getContentPane().add(lblNewLabel_14);
		
		jTextFieldEstado = new JTextField();
		jTextFieldEstado.setBounds(726, 67, 86, 20);
		jInternalFrameCadastroEndereco.getContentPane().add(jTextFieldEstado);
		jTextFieldEstado.setColumns(10);
		
		JButton jButtonFecharInternalEndereco = new JButton("Fechar");
		jButtonFecharInternalEndereco.addActionListener(e -> {

			jInternalFrameCadastroEndereco.dispose();
			buttonGroupEndereco.clearSelection();

		});
		jButtonFecharInternalEndereco.setBounds(966, 20, 89, 23);
		jInternalFrameCadastroEndereco.getContentPane().add(jButtonFecharInternalEndereco);
		
		jButtonNovo = new JButton("Novo");
		jButtonNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = 1; 

				jButtonSalvar.setEnabled(true);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(false);
				
				jTextFieldCod.setEnabled(true);
				jTextFieldNomePessoa.setEnabled(true);
				jTextFieldApto.setEnabled(true);
				jTextFieldBloco.setEnabled(true);
				jFormattedCpf.setEnabled(true);
				jFormattedFonePessoa.setEnabled(true);
				jTextFieldEmailPessoa.setEnabled(true);
				jTextFieldEnderecoPessoa.setEnabled(true);
				jTextFieldEnderecoNumero.setEnabled(true);
				jTextFieldComplemento.setEnabled(true);
				jTextFieldBairro.setEnabled(true);
				jTextFieldCep.setEnabled(true);
				jTextFieldCidade.setEnabled(true);
				jTextFieldEstado.setEnabled(true);
				jComboBoxTipoMorador.setEnabled(true);
					
				jTextFieldCod.setText("");
				jTextFieldNomePessoa.setText("");
				jTextFieldApto.setText("");
				jTextFieldBloco.setText("");
				jFormattedCpf.setText("");
				jFormattedFonePessoa.setText("");
				jTextFieldEmailPessoa.setText("");
				jTextFieldEnderecoPessoa.setText("");
				jTextFieldEnderecoNumero.setText("");
				jTextFieldComplemento.setText("");
				jTextFieldBairro.setText("");
				jTextFieldCep.setText("");
				jTextFieldCidade.setText("");
				jTextFieldEstado.setText("");
				jComboBoxTipoMorador.setSelectedItem("");
				jTextFieldPesquisar.setText("");
				
			}
			
		});
		jButtonNovo.setBounds(201, 338, 89, 23);
		jInternalFramePrincipal.getContentPane().add(jButtonNovo);
		
		jButtonSalvar = new JButton("Salvar");
		jButtonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					if (mod instanceof Proprietario proprietario) {


						Apartamento apto = new Apartamento();
						Contato contato = new Contato();
						Endereco endereco = new Endereco();

						contato.setEmail(jTextFieldEmailPessoa.getText());
						contato.setTelefone(jFormattedFonePessoa.getText());
						apto.setApto(jTextFieldApto.getText());
						apto.setBloco(jTextFieldBloco.getText());

						ChaveComposta chaveComposta = new ChaveComposta(apto, contato);
						endereco.setEndereco(jTextFieldEnderecoPessoa.getText());
						endereco.setNumero(jTextFieldEnderecoNumero.getText());
						endereco.setComplemento(jTextFieldComplemento.getText());
						endereco.setBairro(jTextFieldBairro.getText());
						endereco.setCep(jTextFieldCep.getText());
						endereco.setCidade(jTextFieldCidade.getText());
						endereco.setEstado(jTextFieldEstado.getText());

						proprietario.setNome(jTextFieldNomePessoa.getText());
						proprietario.setChaveComposta(chaveComposta);
						proprietario.setDocumento(jFormattedCpf.getText());
						proprietario.setDataCadastro(LocalDate.now());
						proprietario.setEndereco(endereco);

						//mod.setTipo(Tipo.valueOf((String) jComboBoxTipoMorador.getSelectedItem());

						PessoaJpaDAO.getInstance().merge(proprietario);
						//control.Salvar(mod);

					}else if(mod instanceof Morador morador){

						Apartamento apto = new Apartamento();
						Contato contato = new Contato();

						contato.setEmail(jTextFieldEmailPessoa.getText());
						contato.setTelefone(jFormattedFonePessoa.getText());
						apto.setApto(jTextFieldApto.getText());
						apto.setBloco(jTextFieldBloco.getText());

						ChaveComposta chaveComposta = new ChaveComposta(apto, contato);

						morador.setNome(jTextFieldNomePessoa.getText());
						morador.setChaveComposta(chaveComposta);
						morador.setDocumento(jFormattedCpf.getText());
						morador.setDataCadastro(LocalDate.now());
						PessoaJpaDAO.getInstance().merge(morador);


					}
				
				jButtonSalvar.setEnabled(false);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(false);
				jButtonNovo.setEnabled(true);
				
				jTextFieldNomePessoa.setEnabled(false);
				jTextFieldApto.setEnabled(false);
		        jTextFieldBloco.setEnabled(false);
				jFormattedCpf.setEnabled(false);
				jFormattedFonePessoa.setEnabled(false);
				jTextFieldEmailPessoa.setEnabled(false);
				jTextFieldDataCadastro.setEnabled(false);
				jTextFieldEnderecoPessoa.setEnabled(false);
				jTextFieldEnderecoNumero.setEnabled(false);
				jTextFieldComplemento.setEnabled(false);
				jTextFieldBairro.setEnabled(false);
				jTextFieldCep.setEnabled(false);
				jTextFieldCidade.setEnabled(false);
				jTextFieldEstado.setEnabled(false);
				jComboBoxTipoMorador.setEnabled(false);
				
				
				jTextFieldCod.setText("");
				jTextFieldNomePessoa.setText("");
				jTextFieldApto.setText("");
		        jTextFieldBloco.setText("");
				jFormattedCpf.setText("");
				jFormattedFonePessoa.setText("");
				jTextFieldEmailPessoa.setText("");
				jTextFieldDataCadastro.setText("");
				jTextFieldEnderecoPessoa.setText("");
				jTextFieldEnderecoNumero.setText("");
				jTextFieldComplemento.setText("");
				jTextFieldBairro.setText("");
				jTextFieldCep.setText("");
				jTextFieldCidade.setText("");
				jTextFieldEstado.setText("");
				jComboBoxTipoMorador.setSelectedItem("");
				
				jInternalFrameCadastroEndereco.dispose();
				jInternalFramePrincipal.dispose();
				buttonGroupEndereco.clearSelection();

				List<Morador> pessoaList = PessoaJpaDAO.getInstance().findAllMoradorOrderBy("nome");
				preencherTabelaPessoa(pessoaList);

			}
				
		});
		jButtonSalvar.setBounds(300, 338, 89, 23);
		jInternalFramePrincipal.getContentPane().add(jButtonSalvar);
		
		jButtonEditar = new JButton("Editar");
		jButtonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//flag = 2;
				jButtonNovo.setEnabled(false);
				jButtonSalvar.setEnabled(true);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(false);
				jButtonExcluir.setEnabled(false);

				jTextFieldNomePessoa.setEnabled(true);
				jTextFieldApto.setEnabled(true);
		        jTextFieldBloco.setEnabled(true);
				jFormattedCpf.setEnabled(true);
				jFormattedFonePessoa.setEnabled(true);
				jTextFieldEmailPessoa.setEnabled(true);
				jTextFieldDataCadastro.setEnabled(true);
				jTextFieldEnderecoPessoa.setEnabled(true);
				jTextFieldEnderecoNumero.setEnabled(true);
				jTextFieldComplemento.setEnabled(true);
				jTextFieldBairro.setEnabled(true);
				jTextFieldCep.setEnabled(true);
				jTextFieldCidade.setEnabled(true);
				jTextFieldEstado.setEnabled(true);
				jComboBoxTipoMorador.setEnabled(true);
				
			}
		});
		jButtonEditar.setBounds(399, 338, 89, 23);
		jInternalFramePrincipal.getContentPane().add(jButtonEditar);
		
		jButtonCancelar = new JButton("Cancelar");
		jButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonSalvar.setEnabled(false);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(false);
				jButtonExcluir.setEnabled(false);
				jButtonNovo.setEnabled(true);

				jTextFieldNomePessoa.setEnabled(false);
				jTextFieldApto.setEnabled(false);
		        jTextFieldBloco.setEnabled(false);
				jFormattedCpf.setEnabled(false);
				jFormattedFonePessoa.setEnabled(false);
				jTextFieldEmailPessoa.setEnabled(false);
				jTextFieldDataCadastro.setEnabled(false);
				jTextFieldEnderecoPessoa.setEnabled(false);
				jTextFieldEnderecoNumero.setEnabled(false);
				jTextFieldComplemento.setEnabled(false);
				jTextFieldBairro.setEnabled(false);
				jTextFieldCep.setEnabled(false);
				jTextFieldCidade.setEnabled(false);
				jTextFieldEstado.setEnabled(false);
				jComboBoxTipoMorador.setEnabled(false);
				
				
				jTextFieldCod.setText("");
				jTextFieldNomePessoa.setText("");
				jTextFieldApto.setText("");
		        jTextFieldBloco.setText("");
				jFormattedCpf.setText("");
				jFormattedFonePessoa.setText("");
				jTextFieldEmailPessoa.setText("");
				jTextFieldDataCadastro.setText("");
				jTextFieldEnderecoPessoa.setText("");
				jTextFieldEnderecoNumero.setText("");
				jTextFieldComplemento.setText("");
				jTextFieldBairro.setText("");
				jTextFieldCep.setText("");
				jTextFieldCidade.setText("");
				jTextFieldEstado.setText("");
				jComboBoxTipoMorador.setSelectedItem("");
				jTextFieldPesquisar.setText("");				
			}
		});
		jButtonCancelar.setBounds(503, 338, 89, 23);
		jInternalFramePrincipal.getContentPane().add(jButtonCancelar);
		
		jButtonExcluir = new JButton("Excluir");
		jButtonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int confirma;
				confirma = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente Excluir usuario?");
				if(confirma == JOptionPane.YES_OPTION) {
					mod.setCodigo(Long.parseLong(jTextFieldCod.getText()));
					PessoaJpaDAO.getInstance().remove(mod);

					jButtonSalvar.setEnabled(false);
					jButtonEditar.setEnabled(false);
					jButtonCancelar.setEnabled(true);
					jButtonExcluir.setEnabled(false);
					jButtonNovo.setEnabled(true);

					jTextFieldNomePessoa.setEnabled(false);
					jTextFieldApto.setEnabled(false);
			        jTextFieldBloco.setEnabled(false);
					jFormattedCpf.setEnabled(false);
					jFormattedFonePessoa.setEnabled(false);
					jTextFieldEmailPessoa.setEnabled(false);
					jTextFieldDataCadastro.setEnabled(false);
					jTextFieldEnderecoPessoa.setEnabled(false);
					jTextFieldEnderecoNumero.setEnabled(false);
					jTextFieldComplemento.setEnabled(false);
					jTextFieldBairro.setEnabled(false);
					jTextFieldCep.setEnabled(false);
					jTextFieldCidade.setEnabled(false);
					jTextFieldEstado.setEnabled(false);
					jComboBoxTipoMorador.setEnabled(false);
					
					jTextFieldCod.setText("");
					jTextFieldNomePessoa.setText("");
					jTextFieldApto.setText("");
			        jTextFieldBloco.setText("");
					jFormattedCpf.setText("");
					jFormattedFonePessoa.setText("");
					jTextFieldEmailPessoa.setText("");
					jTextFieldDataCadastro.setText("");
					jTextFieldEnderecoPessoa.setText("");
					jTextFieldEnderecoNumero.setText("");
					jTextFieldComplemento.setText("");
					jTextFieldBairro.setText("");
					jTextFieldCep.setText("");
					jTextFieldCidade.setText("");
					jTextFieldEstado.setText("");
					jComboBoxTipoMorador.setSelectedItem("");
					jTextFieldPesquisar.setText("");
					
					jInternalFrameCadastroEndereco.dispose();
					jInternalFramePrincipal.dispose();
					buttonGroupEndereco.clearSelection();

					List<Morador> pessoaList = PessoaJpaDAO.getInstance().findAllMoradorOrderBy("nome");
					preencherTabelaPessoa(pessoaList);
				}
			}
		});
		jButtonExcluir.setBounds(602, 338, 89, 23);
		jInternalFramePrincipal.getContentPane().add(jButtonExcluir);
		
		jComboBoxTipoMorador = new JComboBox();
		jComboBoxTipoMorador.setModel(new DefaultComboBoxModel(new String[] {"Propriet\u00E1rio", "Inquilino"}));
		jComboBoxTipoMorador.setBounds(284, 136, 218, 20);
		jInternalFramePrincipal.getContentPane().add(jComboBoxTipoMorador);

		jButtonPesquisar = new JButton("Pesquisar");

		jButtonPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//mod.setPesquisa(jTextFieldPesquisar.getText());

				//PessoaJpaDAO.getInstance()

				//Pessoa model  = control.buscarPessoa(mod);

				/* jTextFieldCod.setText(String.valueOf(mod.getCodigo()));
				jTextFieldNomePessoa.setText(model.getNome());
				jTextFieldApto.setText(model.getApto());
				jTextFieldBloco.setText(model.getBloco());
				jFormattedCpf.setText(model.getCpf());
				jFormattedFonePessoa.setText(model.getTelefone());
				jTextFieldEmailPessoa.setText(model.getEmail());
				jTextFieldEnderecoPessoa.setText(model.getEndereco());
				jTextFieldEnderecoNumero.setText(model.getNumero());
				jTextFieldComplemento.setText(model.getComplemento());
				jTextFieldBairro.setText(model.getBairro());
				jTextFieldCep.setText(model.getCep());
				jTextFieldCidade.setText(model.getCidade());
				jTextFieldEstado.setText(model.getEstado());
				jComboBoxTipoMorador.setSelectedItem(model.getTipo());

				jButtonNovo.setEnabled(false);
				jButtonEditar.setEnabled(true);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(true);
				jButtonSalvar.setEnabled(false);


				jInternalFrameCadastroEndereco.dispose();
				jInternalFramePrincipal.dispose();
				buttonGroupEndereco.clearSelection();
				*/

				List<Morador> pessoaList = PessoaJpaDAO.getInstance().findAllMoradorByNome(jTextFieldPesquisar.getText());
				preencherTabelaPessoa(pessoaList);

				jTextFieldPesquisar.setText("");


			}
		});
		jButtonPesquisar.setBounds(1025, 44, 89, 23);
		panel.add(jButtonPesquisar);
		
		jTextFieldPesquisar = new JTextField();
		jTextFieldPesquisar.setBounds(737, 45, 273, 20);
		panel.add(jTextFieldPesquisar);
		jTextFieldPesquisar.setColumns(10);
		
		JRadioButton jRadioButtonCadastrar = new JRadioButton("Cadastrar Propriet\u00E1rio / Morador");
		buttonGroupCadastro.add(jRadioButtonCadastrar);
		jRadioButtonCadastrar.addActionListener(arg0 -> {
			if(jRadioButtonCadastrar.isSelected()) {
				jInternalFramePrincipal.setVisible(true);

				flag = 1;

				jButtonSalvar.setEnabled(true);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(false);

				jTextFieldCod.setEnabled(true);
				jTextFieldNomePessoa.setEnabled(true);
				jTextFieldApto.setEnabled(true);
				jTextFieldBloco.setEnabled(true);
				jFormattedCpf.setEnabled(true);
				jFormattedFonePessoa.setEnabled(true);
				jTextFieldEmailPessoa.setEnabled(true);
				jTextFieldEnderecoPessoa.setEnabled(true);
				jTextFieldEnderecoNumero.setEnabled(true);
				jTextFieldComplemento.setEnabled(true);
				jTextFieldBairro.setEnabled(true);
				jTextFieldCep.setEnabled(true);
				jTextFieldCidade.setEnabled(true);
				jTextFieldEstado.setEnabled(true);
				jComboBoxTipoMorador.setEnabled(true);

				jTextFieldCod.setText("");
				jTextFieldNomePessoa.setText("");
				jTextFieldApto.setText("");
				jTextFieldBloco.setText("");
				jFormattedCpf.setText("");
				jFormattedFonePessoa.setText("");
				jTextFieldEmailPessoa.setText("");
				jTextFieldEnderecoPessoa.setText("");
				jTextFieldEnderecoNumero.setText("");
				jTextFieldComplemento.setText("");
				jTextFieldBairro.setText("");
				jTextFieldCep.setText("");
				jTextFieldCidade.setText("");
				jTextFieldEstado.setText("");
				jComboBoxTipoMorador.setSelectedItem("");
				jTextFieldPesquisar.setText("");
			}
		});
		jRadioButtonCadastrar.setBounds(38, 58, 223, 23);
		contentPane.add(jRadioButtonCadastrar);	
	}

@SuppressWarnings({ "unchecked", "static-access" })
public void preencherTabelaPessoa(List<Morador> pessoaList) {


	@SuppressWarnings("rawtypes")
	List<String> dados = new ArrayList<>();
	String[] colunas = new String[]{"C�DIGO", "PROPRIET�RIO/MORADOR", "TELEFONE", "CPF", "E-MAIL", "BLOCO", "APTO", "TIPO"};


	for (Morador morador : pessoaList){

		 dados.add(String.valueOf(morador.getCodigo()));
		 dados.add(morador.getNome());
		 dados.add(morador.getChaveComposta().getContato().getTelefone());
		 dados.add(morador.getDocumento());
		 dados.add(morador.getChaveComposta().getContato().getEmail());
		 dados.add(morador.getChaveComposta().getApto().getBloco());
		 dados.add(morador.getChaveComposta().getApto().getApto());
		 dados.add(morador.getTipo().getDescricao());

	}

		
		TableModel modelo  = new TableModel(dados, colunas);
		jTablePessoas.setModel(modelo);
		jTablePessoas.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTablePessoas.getColumnModel().getColumn(0).setResizable(false);
		jTablePessoas.getColumnModel().getColumn(1).setPreferredWidth(313);
		jTablePessoas.getColumnModel().getColumn(1).setResizable(false);
		jTablePessoas.getColumnModel().getColumn(2).setPreferredWidth(100);
		jTablePessoas.getColumnModel().getColumn(2).setResizable(false);
		jTablePessoas.getColumnModel().getColumn(3).setPreferredWidth(100);
		jTablePessoas.getColumnModel().getColumn(3).setResizable(false);
		jTablePessoas.getColumnModel().getColumn(4).setPreferredWidth(200);
		jTablePessoas.getColumnModel().getColumn(4).setResizable(false);
		jTablePessoas.getColumnModel().getColumn(5).setPreferredWidth(110);
		jTablePessoas.getColumnModel().getColumn(5).setResizable(false);
		jTablePessoas.getColumnModel().getColumn(6).setPreferredWidth(78);
		jTablePessoas.getColumnModel().getColumn(6).setResizable(false);
		jTablePessoas.getColumnModel().getColumn(7).setPreferredWidth(78);
		jTablePessoas.getColumnModel().getColumn(7).setResizable(false);
		jTablePessoas.getTableHeader().setReorderingAllowed(false);
		jTablePessoas.setAutoResizeMode(jTablePessoas.AUTO_RESIZE_OFF);
		jTablePessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		jTablePessoas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Long codigo = Long.parseLong(STR."\{jTablePessoas.getValueAt(jTablePessoas.getSelectedRow(), 0)}");

				if (PessoaJpaDAO.getInstance().getById(codigo) instanceof Proprietario proprietario) {

					jTextFieldCod.setText(String.valueOf(proprietario.getCodigo()));
					jTextFieldNomePessoa.setText(proprietario.getNome());
					jTextFieldBloco.setText(proprietario.getChaveComposta().getApto().getBloco());
					jTextFieldApto.setText(proprietario.getChaveComposta().getApto().getApto());
					jFormattedCpf.setText(proprietario.getDocumento());
					jFormattedFonePessoa.setText(proprietario.getChaveComposta().getContato().getTelefone());
					jTextFieldEmailPessoa.setText(proprietario.getChaveComposta().getContato().getEmail());

					jTextFieldEnderecoPessoa.setText(proprietario.getEndereco().getEndereco());
					jTextFieldEnderecoNumero.setText(proprietario.getEndereco().getNumero());
					jTextFieldComplemento.setText(proprietario.getEndereco().getComplemento());
					jTextFieldBairro.setText(proprietario.getEndereco().getBairro());
					jTextFieldCep.setText(proprietario.getEndereco().getCep());
					jTextFieldCidade.setText(proprietario.getEndereco().getCidade());
					jTextFieldEstado.setText(proprietario.getEndereco().getEstado());

				} else if(PessoaJpaDAO.getInstance().getById(codigo) instanceof Morador morador) {


					jTextFieldCod.setText(String.valueOf(morador.getCodigo()));
					jTextFieldNomePessoa.setText(morador.getNome());
					jTextFieldBloco.setText(morador.getChaveComposta().getApto().getBloco());
					jTextFieldApto.setText(morador.getChaveComposta().getApto().getApto());
					jFormattedCpf.setText(morador.getDocumento());
					jFormattedFonePessoa.setText(morador.getChaveComposta().getContato().getTelefone());
					jTextFieldEmailPessoa.setText(morador.getChaveComposta().getContato().getEmail());

				}

						//jComboBoxTipoMorador.setSelectedItem(conex.rs.getString("tipo"));
						jInternalFramePrincipal.setVisible(true);
						jInternalFrameCadastroEndereco.setVisible(true);

						jTextFieldNomePessoa.setEnabled(true);
						jTextFieldApto.setEnabled(true);
						jTextFieldBloco.setEnabled(true);
						jFormattedCpf.setEnabled(true);
						jFormattedFonePessoa.setEnabled(true);
						jTextFieldEmailPessoa.setEnabled(true);
						jTextFieldDataCadastro.setEnabled(true);
						jTextFieldEnderecoPessoa.setEnabled(true);
						jTextFieldEnderecoNumero.setEnabled(true);
						jTextFieldComplemento.setEnabled(true);
						jTextFieldBairro.setEnabled(true);
						jTextFieldCep.setEnabled(true);
						jTextFieldCidade.setEnabled(true);
						jTextFieldEstado.setEnabled(true);
						jComboBoxTipoMorador.setEnabled(true);



				//});
				
				//conex.executaSQL(STR."select * from pessoa where nome='\{usuario}'");
				/*try {
					conex.rs.first();
					jTextFieldCod.setText(String.valueOf(conex.rs.getInt("codigo")));
					jTextFieldNomePessoa.setText(conex.rs.getString("nome"));
					jTextFieldBloco.setText(conex.rs.getString("bloco"));
					jTextFieldApto.setText(conex.rs.getString("apto"));
					jFormattedCpf.setText(conex.rs.getString("cpf"));
					jFormattedFonePessoa.setText(conex.rs.getString("telefone"));
					jTextFieldEmailPessoa.setText(conex.rs.getString("email"));
					jTextFieldEnderecoPessoa.setText(conex.rs.getString("endereco"));
					jTextFieldEnderecoNumero.setText(conex.rs.getString("numero"));
					jTextFieldComplemento.setText(conex.rs.getString("complemento"));
					jTextFieldBairro.setText(conex.rs.getString("bairro"));
					jTextFieldCep.setText(conex.rs.getString("cep"));
					jTextFieldCidade.setText(conex.rs.getString("cidade"));
					jTextFieldEstado.setText(conex.rs.getString("estado"));
					jComboBoxTipoMorador.setSelectedItem(conex.rs.getString("tipo"));
					jInternalFramePrincipal.setVisible(true);
					jInternalFrameCadastroEndereco.setVisible(true);

					jTextFieldNomePessoa.setEnabled(true);
					jTextFieldApto.setEnabled(true);
			        jTextFieldBloco.setEnabled(true);
					jFormattedCpf.setEnabled(true);
					jFormattedFonePessoa.setEnabled(true);
					jTextFieldEmailPessoa.setEnabled(true);
					jTextFieldDataCadastro.setEnabled(true);
					jTextFieldEnderecoPessoa.setEnabled(true);
					jTextFieldEnderecoNumero.setEnabled(true);
					jTextFieldComplemento.setEnabled(true);
					jTextFieldBairro.setEnabled(true);
					jTextFieldCep.setEnabled(true);
					jTextFieldCidade.setEnabled(true);
					jTextFieldEstado.setEnabled(true);
					jComboBoxTipoMorador.setEnabled(true);
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, STR."Erro ao selecionar Propriet�rio/n Erro:\{e}");
				}*/
				
				//conex.desconectar();
				
				jButtonEditar.setEnabled(true);
				jButtonExcluir.setEnabled(true);
				jButtonCancelar.setEnabled(true);
			}
		});
		
}
}
		
