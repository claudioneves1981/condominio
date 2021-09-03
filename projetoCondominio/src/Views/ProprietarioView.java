package views;

import controller.DBConnection;
import controller.ProprietarioController;
import model.Proprietario;
import model.TableModel;

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
import java.util.ArrayList;

public class ProprietarioView extends JFrame {
	
	DBConnection conex = new DBConnection();
	ProprietarioController control = new ProprietarioController();
	Proprietario mod = new Proprietario();
	
	int flag = 0;

	private final JTable jTableProprietarios;
	private final JTextField jTextFieldPesquisar;
	private final ButtonGroup buttonGroupCadastro = new ButtonGroup();
	private final JTextField jTextFieldDataCadastro;
	private final JTextField jTextFieldCod;
	private final JTextField jTextFieldNomeProprietario;
	private final JTextField jTextFieldBloco;
	private final JTextField jTextFieldApto;
	private final JTextField jTextFieldEmailProprietario;
	private final JTextField jTextFieldEnderecoProprietario;
	private final JTextField jTextFieldEnderecoNumero;
	private final JTextField jTextFieldComplemento;
	private final JTextField jTextFieldBairro;
	private final JTextField jTextFieldCep;
	private final JTextField jTextFieldCidade;
	private final JTextField jTextFieldEstado;
	private final JFormattedTextField jFormattedFoneProprietario;
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
		
		jInternalFramePrincipal.setToolTipText("Cadastro do Propriet\u00E1rio");
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
		jTableProprietarios = new JTable();
		scrollPane.setViewportView(jTableProprietarios);
		jTableProprietarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		jTableProprietarios.setBounds(20, 200, 930, 260);

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
		
		jTextFieldNomeProprietario = new JTextField();
		jTextFieldNomeProprietario.setBounds(230, 57, 383, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldNomeProprietario);
		jTextFieldNomeProprietario.setColumns(10);
		
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
		
		jFormattedFoneProprietario = new JFormattedTextField();
		jFormattedFoneProprietario.setBounds(284, 95, 146, 20);
		jInternalFramePrincipal.getContentPane().add(jFormattedFoneProprietario);
		
		jTextFieldEmailProprietario = new JTextField();
		jTextFieldEmailProprietario.setBounds(503, 95, 389, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldEmailProprietario);
		jTextFieldEmailProprietario.setColumns(10);
		
		jInternalFrameCadastroEndereco.setToolTipText("Endere\u00E7o da Cidade onde Mora");
		jInternalFrameCadastroEndereco.setBounds(10, 167, 1079, 136);
		jInternalFramePrincipal.getContentPane().add(jInternalFrameCadastroEndereco);
		jInternalFrameCadastroEndereco.getContentPane().setLayout(null);
		
		JCheckBox jCheckBoxEndereco = new JCheckBox("O Propriet\u00E1rio n\u00E3o Mora no Condominio");
		buttonGroupEndereco.add(jCheckBoxEndereco);
		jCheckBoxEndereco.addActionListener(e -> {
			if(jCheckBoxEndereco.isSelected()) {
				jInternalFrameCadastroEndereco.setVisible(true);
			}
		});
		jCheckBoxEndereco.setBounds(10, 135, 266, 23);
		jInternalFramePrincipal.getContentPane().add(jCheckBoxEndereco);
		
		JLabel lblNewLabel_8 = new JLabel("Endere\u00E7o");
		lblNewLabel_8.setBounds(25, 24, 76, 14);
		jInternalFrameCadastroEndereco.getContentPane().add(lblNewLabel_8);
		
		jTextFieldEnderecoProprietario = new JTextField();
		jTextFieldEnderecoProprietario.setBounds(91, 21, 543, 20);
		jInternalFrameCadastroEndereco.getContentPane().add(jTextFieldEnderecoProprietario);
		jTextFieldEnderecoProprietario.setColumns(10);
		
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
				jTextFieldNomeProprietario.setEnabled(true);
				jTextFieldApto.setEnabled(true);
				jTextFieldBloco.setEnabled(true);
				jFormattedCpf.setEnabled(true);
				jFormattedFoneProprietario.setEnabled(true);
				jTextFieldEmailProprietario.setEnabled(true);
				jTextFieldEnderecoProprietario.setEnabled(true);
				jTextFieldEnderecoNumero.setEnabled(true);
				jTextFieldComplemento.setEnabled(true);
				jTextFieldBairro.setEnabled(true);
				jTextFieldCep.setEnabled(true);
				jTextFieldCidade.setEnabled(true);
				jTextFieldEstado.setEnabled(true);
				jComboBoxTipoMorador.setEnabled(true);
					
				jTextFieldCod.setText("");
				jTextFieldNomeProprietario.setText("");
				jTextFieldApto.setText("");
				jTextFieldBloco.setText("");
				jFormattedCpf.setText("");
				jFormattedFoneProprietario.setText("");
				jTextFieldEmailProprietario.setText("");
				jTextFieldEnderecoProprietario.setText("");
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
						
				if(flag == 1) {
					mod.setNome(jTextFieldNomeProprietario.getText());
					mod.setApto(jTextFieldApto.getText());
					mod.setBloco(jTextFieldBloco.getText());
					mod.setCpf(jFormattedCpf.getText());
					mod.setTelefone(jFormattedFoneProprietario.getText());
					mod.setEmail(jTextFieldEmailProprietario.getText());
					mod.setDataCadastro(jTextFieldDataCadastro.getText());
					mod.setEndereco(jTextFieldEnderecoProprietario.getText());
					mod.setNumero(jTextFieldEnderecoNumero.getText());
					mod.setComplemento(jTextFieldComplemento.getText());
					mod.setBairro(jTextFieldBairro.getText());
					mod.setCep(jTextFieldCep.getText());
					mod.setCidade(jTextFieldCidade.getText());
					mod.setEstado(jTextFieldEstado.getText());
					mod.setTipo((String)jComboBoxTipoMorador.getSelectedItem());

					control.Salvar(mod);
				
				jButtonSalvar.setEnabled(false);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(false);
				jButtonNovo.setEnabled(true);
				
				jTextFieldNomeProprietario.setEnabled(false);
				jTextFieldApto.setEnabled(false);
		        jTextFieldBloco.setEnabled(false);
				jFormattedCpf.setEnabled(false);
				jFormattedFoneProprietario.setEnabled(false);
				jTextFieldEmailProprietario.setEnabled(false);
				jTextFieldDataCadastro.setEnabled(false);
				jTextFieldEnderecoProprietario.setEnabled(false);
				jTextFieldEnderecoNumero.setEnabled(false);
				jTextFieldComplemento.setEnabled(false);
				jTextFieldBairro.setEnabled(false);
				jTextFieldCep.setEnabled(false);
				jTextFieldCidade.setEnabled(false);
				jTextFieldEstado.setEnabled(false);
				jComboBoxTipoMorador.setEnabled(false);
				
				
				jTextFieldCod.setText("");
				jTextFieldNomeProprietario.setText("");
				jTextFieldApto.setText("");
		        jTextFieldBloco.setText("");
				jFormattedCpf.setText("");
				jFormattedFoneProprietario.setText("");
				jTextFieldEmailProprietario.setText("");
				jTextFieldDataCadastro.setText("");
				jTextFieldEnderecoProprietario.setText("");
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
				
				preencherTabelaProprietario("select * from proprietario order by nome");
				
				}else {
					mod.setNome(jTextFieldNomeProprietario.getText());
					mod.setApto(jTextFieldApto.getText());
					mod.setBloco(jTextFieldBloco.getText());
					mod.setCpf(jFormattedCpf.getText());
					mod.setTelefone(jFormattedFoneProprietario.getText());
					mod.setEmail(jTextFieldEmailProprietario.getText());
					mod.setDataCadastro(jTextFieldDataCadastro.getText());
					mod.setEndereco(jTextFieldEnderecoProprietario.getText());
					mod.setNumero(jTextFieldEnderecoNumero.getText());
					mod.setComplemento(jTextFieldComplemento.getText());
					mod.setBairro(jTextFieldBairro.getText());
					mod.setCep(jTextFieldCep.getText());
					mod.setCidade(jTextFieldCidade.getText());
					mod.setEstado(jTextFieldEstado.getText());
					mod.setTipo((String)jComboBoxTipoMorador.getSelectedItem());

					control.Editar(mod);
					jButtonNovo.setEnabled(true);
					jButtonSalvar.setEnabled(false);
					jButtonEditar.setEnabled(false);
					jButtonCancelar.setEnabled(true);
					jButtonExcluir.setEnabled(false);
					
					jTextFieldNomeProprietario.setEnabled(false);
					jTextFieldApto.setEnabled(false);
			        jTextFieldBloco.setEnabled(false);
					jFormattedCpf.setEnabled(false);
					jFormattedFoneProprietario.setEnabled(false);
					jTextFieldEmailProprietario.setEnabled(false);
					jTextFieldDataCadastro.setEnabled(false);
					jTextFieldEnderecoProprietario.setEnabled(false);
					jTextFieldEnderecoNumero.setEnabled(false);
					jTextFieldComplemento.setEnabled(false);
					jTextFieldBairro.setEnabled(false);
					jTextFieldCep.setEnabled(false);
					jTextFieldCidade.setEnabled(false);
					jTextFieldEstado.setEnabled(false);
					jComboBoxTipoMorador.setEnabled(false);
						
					jTextFieldCod.setText("");
					jTextFieldNomeProprietario.setText("");
					jTextFieldApto.setText("");
			        jTextFieldBloco.setText("");
					jFormattedCpf.setText("");
					jFormattedFoneProprietario.setText("");
					jTextFieldEmailProprietario.setText("");
					jTextFieldDataCadastro.setText("");
					jTextFieldEnderecoProprietario.setText("");
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

					preencherTabelaProprietario("select * from proprietario order by nome");
					
				}
				
			}
				
		});
		jButtonSalvar.setBounds(300, 338, 89, 23);
		jInternalFramePrincipal.getContentPane().add(jButtonSalvar);
		
		jButtonEditar = new JButton("Editar");
		jButtonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = 2;
				jButtonNovo.setEnabled(false);
				jButtonSalvar.setEnabled(true);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(false);
				jButtonExcluir.setEnabled(false);

				jTextFieldNomeProprietario.setEnabled(true);
				jTextFieldApto.setEnabled(true);
		        jTextFieldBloco.setEnabled(true);
				jFormattedCpf.setEnabled(true);
				jFormattedFoneProprietario.setEnabled(true);
				jTextFieldEmailProprietario.setEnabled(true);
				jTextFieldDataCadastro.setEnabled(true);
				jTextFieldEnderecoProprietario.setEnabled(true);
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

				jTextFieldNomeProprietario.setEnabled(false);
				jTextFieldApto.setEnabled(false);
		        jTextFieldBloco.setEnabled(false);
				jFormattedCpf.setEnabled(false);
				jFormattedFoneProprietario.setEnabled(false);
				jTextFieldEmailProprietario.setEnabled(false);
				jTextFieldDataCadastro.setEnabled(false);
				jTextFieldEnderecoProprietario.setEnabled(false);
				jTextFieldEnderecoNumero.setEnabled(false);
				jTextFieldComplemento.setEnabled(false);
				jTextFieldBairro.setEnabled(false);
				jTextFieldCep.setEnabled(false);
				jTextFieldCidade.setEnabled(false);
				jTextFieldEstado.setEnabled(false);
				jComboBoxTipoMorador.setEnabled(false);
				
				
				jTextFieldCod.setText("");
				jTextFieldNomeProprietario.setText("");
				jTextFieldApto.setText("");
		        jTextFieldBloco.setText("");
				jFormattedCpf.setText("");
				jFormattedFoneProprietario.setText("");
				jTextFieldEmailProprietario.setText("");
				jTextFieldDataCadastro.setText("");
				jTextFieldEnderecoProprietario.setText("");
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
					mod.setCodigo(Integer.parseInt(jTextFieldCod.getText()));
					control.Excluir(mod);
					
					jButtonSalvar.setEnabled(false);
					jButtonEditar.setEnabled(false);
					jButtonCancelar.setEnabled(true);
					jButtonExcluir.setEnabled(false);
					jButtonNovo.setEnabled(true);

					jTextFieldNomeProprietario.setEnabled(false);
					jTextFieldApto.setEnabled(false);
			        jTextFieldBloco.setEnabled(false);
					jFormattedCpf.setEnabled(false);
					jFormattedFoneProprietario.setEnabled(false);
					jTextFieldEmailProprietario.setEnabled(false);
					jTextFieldDataCadastro.setEnabled(false);
					jTextFieldEnderecoProprietario.setEnabled(false);
					jTextFieldEnderecoNumero.setEnabled(false);
					jTextFieldComplemento.setEnabled(false);
					jTextFieldBairro.setEnabled(false);
					jTextFieldCep.setEnabled(false);
					jTextFieldCidade.setEnabled(false);
					jTextFieldEstado.setEnabled(false);
					jComboBoxTipoMorador.setEnabled(false);
					
					jTextFieldCod.setText("");
					jTextFieldNomeProprietario.setText("");
					jTextFieldApto.setText("");
			        jTextFieldBloco.setText("");
					jFormattedCpf.setText("");
					jFormattedFoneProprietario.setText("");
					jTextFieldEmailProprietario.setText("");
					jTextFieldDataCadastro.setText("");
					jTextFieldEnderecoProprietario.setText("");
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
					
					preencherTabelaProprietario("select * from proprietario order by nome");
				}
			}
		});
		jButtonExcluir.setBounds(602, 338, 89, 23);
		jInternalFramePrincipal.getContentPane().add(jButtonExcluir);
		
		jComboBoxTipoMorador = new JComboBox();
		jComboBoxTipoMorador.setModel(new DefaultComboBoxModel(new String[] {"Propriet\u00E1rio", "Inquilino"}));
		jComboBoxTipoMorador.setBounds(284, 136, 218, 20);
		jInternalFramePrincipal.getContentPane().add(jComboBoxTipoMorador);

		JButton jButtonPesquisar = new JButton("Pesquisar");
		jButtonPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mod.setPesquisa(jTextFieldPesquisar.getText());
				Proprietario model  = control.buscarProprietario(mod);
				
				jTextFieldCod.setText(String.valueOf(mod.getCodigo()));
				jTextFieldNomeProprietario.setText(model.getNome());
				jTextFieldApto.setText(model.getApto());
				jTextFieldBloco.setText(model.getBloco());
				jFormattedCpf.setText(model.getCpf());
				jFormattedFoneProprietario.setText(model.getTelefone());
				jTextFieldEmailProprietario.setText(model.getEmail());
				jTextFieldEnderecoProprietario.setText(model.getEndereco());
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
				
				preencherTabelaProprietario("select * from proprietario where nome like '%"+jTextFieldPesquisar.getText()+"%'");
				
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
				jTextFieldNomeProprietario.setEnabled(true);
				jTextFieldApto.setEnabled(true);
				jTextFieldBloco.setEnabled(true);
				jFormattedCpf.setEnabled(true);
				jFormattedFoneProprietario.setEnabled(true);
				jTextFieldEmailProprietario.setEnabled(true);
				jTextFieldEnderecoProprietario.setEnabled(true);
				jTextFieldEnderecoNumero.setEnabled(true);
				jTextFieldComplemento.setEnabled(true);
				jTextFieldBairro.setEnabled(true);
				jTextFieldCep.setEnabled(true);
				jTextFieldCidade.setEnabled(true);
				jTextFieldEstado.setEnabled(true);
				jComboBoxTipoMorador.setEnabled(true);

				jTextFieldCod.setText("");
				jTextFieldNomeProprietario.setText("");
				jTextFieldApto.setText("");
				jTextFieldBloco.setText("");
				jFormattedCpf.setText("");
				jFormattedFoneProprietario.setText("");
				jTextFieldEmailProprietario.setText("");
				jTextFieldEnderecoProprietario.setText("");
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
public void preencherTabelaProprietario(String SQL) {
	
		
	
	    @SuppressWarnings("rawtypes")
		ArrayList dados = new ArrayList();
	    String[] colunas = new String[] {"C�DIGO","PROPRIET�RIO","TELEFONE","CPF","E-MAIL","BLOCO","APTO","TIPO"};
		conex.conexao();
		conex.executaSQL(SQL);
		
		try {
			
			conex.rs.first();
			
			do{
				
						dados.add(new Object[]{
						conex.rs.getInt("codigo"),
						conex.rs.getString("nome"),
						conex.rs.getString("telefone"),
						conex.rs.getString("cpf"),
						conex.rs.getString("email"),
						conex.rs.getString("bloco"),
						conex.rs.getString("apto"),
						conex.rs.getString("tipo"),
						});
				
			}while(conex.rs.next());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"N�o existe propriet�rio cadastrado no sistema. Por favor cadastre um propriet�rio!");
		}
		
		TableModel modelo  = new TableModel(dados, colunas);
		jTableProprietarios.setModel(modelo);
		jTableProprietarios.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTableProprietarios.getColumnModel().getColumn(0).setResizable(false);
		jTableProprietarios.getColumnModel().getColumn(1).setPreferredWidth(313);
		jTableProprietarios.getColumnModel().getColumn(1).setResizable(false);
		jTableProprietarios.getColumnModel().getColumn(2).setPreferredWidth(100);
		jTableProprietarios.getColumnModel().getColumn(2).setResizable(false);
		jTableProprietarios.getColumnModel().getColumn(3).setPreferredWidth(100);
		jTableProprietarios.getColumnModel().getColumn(3).setResizable(false);
		jTableProprietarios.getColumnModel().getColumn(4).setPreferredWidth(200);
		jTableProprietarios.getColumnModel().getColumn(4).setResizable(false);
		jTableProprietarios.getColumnModel().getColumn(5).setPreferredWidth(110);
		jTableProprietarios.getColumnModel().getColumn(5).setResizable(false);
		jTableProprietarios.getColumnModel().getColumn(6).setPreferredWidth(78);
		jTableProprietarios.getColumnModel().getColumn(6).setResizable(false);
		jTableProprietarios.getColumnModel().getColumn(7).setPreferredWidth(78);
		jTableProprietarios.getColumnModel().getColumn(7).setResizable(false);
		jTableProprietarios.getTableHeader().setReorderingAllowed(false);
		jTableProprietarios.setAutoResizeMode(jTableProprietarios.AUTO_RESIZE_OFF);
		jTableProprietarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		conex.desconectar();
		
		jTableProprietarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String usuario = ""+jTableProprietarios.getValueAt(jTableProprietarios.getSelectedRow(),1);
				
				conex.conexao();
				
				conex.executaSQL("select * from proprietario where nome='"+usuario+"'");
				try {
					conex.rs.first();
					jTextFieldCod.setText(String.valueOf(conex.rs.getInt("codigo")));
					jTextFieldNomeProprietario.setText(conex.rs.getString("nome"));
					jTextFieldBloco.setText(conex.rs.getString("bloco"));
					jTextFieldApto.setText(conex.rs.getString("apto"));
					jFormattedCpf.setText(conex.rs.getString("cpf"));
					jFormattedFoneProprietario.setText(conex.rs.getString("telefone"));
					jTextFieldEmailProprietario.setText(conex.rs.getString("email"));
					jTextFieldEnderecoProprietario.setText(conex.rs.getString("endereco"));
					jTextFieldEnderecoNumero.setText(conex.rs.getString("numero"));
					jTextFieldComplemento.setText(conex.rs.getString("complemento"));
					jTextFieldBairro.setText(conex.rs.getString("bairro"));
					jTextFieldCep.setText(conex.rs.getString("cep"));
					jTextFieldCidade.setText(conex.rs.getString("cidade"));
					jTextFieldEstado.setText(conex.rs.getString("estado"));
					jComboBoxTipoMorador.setSelectedItem(conex.rs.getString("tipo"));
					jInternalFramePrincipal.setVisible(true);
					jInternalFrameCadastroEndereco.setVisible(true);

					jTextFieldNomeProprietario.setEnabled(true);
					jTextFieldApto.setEnabled(true);
			        jTextFieldBloco.setEnabled(true);
					jFormattedCpf.setEnabled(true);
					jFormattedFoneProprietario.setEnabled(true);
					jTextFieldEmailProprietario.setEnabled(true);
					jTextFieldDataCadastro.setEnabled(true);
					jTextFieldEnderecoProprietario.setEnabled(true);
					jTextFieldEnderecoNumero.setEnabled(true);
					jTextFieldComplemento.setEnabled(true);
					jTextFieldBairro.setEnabled(true);
					jTextFieldCep.setEnabled(true);
					jTextFieldCidade.setEnabled(true);
					jTextFieldEstado.setEnabled(true);
					jComboBoxTipoMorador.setEnabled(true);
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null,"Erro ao selecionar Propriet�rio/n Erro:"+e);
				}
				
				conex.desconectar();
				
				jButtonEditar.setEnabled(true);
				jButtonExcluir.setEnabled(true);
				jButtonCancelar.setEnabled(true);
			}
		});
		
}
}
		
