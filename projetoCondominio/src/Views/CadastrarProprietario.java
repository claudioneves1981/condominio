package Views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Controller.ConexaoBD;
import Controller.ControleProprietario;
import ModelBeans.BeansProprietario;
import ModelBeans.ModeloTabela;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class CadastrarProprietario extends JFrame {
	
	ConexaoBD conex = new ConexaoBD();
	ControleProprietario control = new ControleProprietario();
	BeansProprietario mod = new BeansProprietario();
	
	int flag = 0;

	private JPanel contentPane;
	private JPanel panel;
	private JTable jTableProprietarios;
	private JTextField jTextFieldPesquisar;
	private final ButtonGroup buttonGroupCadastro = new ButtonGroup();
	private JTextField jTextFieldDataCadastro;
	private JTextField jTextFieldCod_Proprietario;
	private JTextField jTextFieldNomeProprietario;
	private JTextField jTextFieldQuadra;
	private JTextField jTextFieldLote;
	private JTextField jTextFieldEmailProprietario;
	private JTextField jTextFieldEnderecoProprietario;
	private JTextField jTextFieldNumeroEndereco;
	private JTextField jTextFieldComplemento;
	private JTextField jTextFieldBairro;
	private JTextField jTextFieldCep;
	private JTextField jTextFieldCidade;
	private JTextField jTextFieldEstado;
	private JFormattedTextField jFormattedFoneProprietario;
	private JFormattedTextField jFormattedCpf_proprietario;
	private JInternalFrame jInternalFrameCadastroEndereço;
	private JInternalFrame jInternalFramePrincipal;
	private final ButtonGroup buttonGroupEndereco = new ButtonGroup();
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBoxTipoMorador;
	private JButton jButtonNovo;
	private JButton jButtonEditar;
	private JButton jButtonSalvar;
	private JButton jButtonExcluir;
	private JButton jButtonCancelar;
	private JButton jButtonPesquisar;
	private JButton JButtonFecharInternalFramePrincipal;
	private JScrollPane scrollPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProprietario frame = new CadastrarProprietario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CadastrarProprietario() {
				
		jInternalFrameCadastroEndereço = new JInternalFrame("Endere\u00E7o da Cidade onde Mora");
		jInternalFramePrincipal = new JInternalFrame("Cadastro do Propriet\u00E1rio / Morador");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1199, 818);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
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
		
		jTextFieldCod_Proprietario = new JTextField();
		jTextFieldCod_Proprietario.setBounds(57, 57, 86, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldCod_Proprietario);
		jTextFieldCod_Proprietario.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 1104, 359);
		panel.add(scrollPane);
		jTableProprietarios = new JTable();
		scrollPane.setViewportView(jTableProprietarios);
		jTableProprietarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		jTableProprietarios.setBounds(20, 200, 930, 260);
		
		JButtonFecharInternalFramePrincipal = new JButton("Fechar");
		JButtonFecharInternalFramePrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jInternalFramePrincipal.dispose();
				jInternalFrameCadastroEndereço.dispose();
				buttonGroupCadastro.clearSelection();
				buttonGroupEndereco.clearSelection();
				
			}
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
		
		jTextFieldQuadra = new JTextField();
		jTextFieldQuadra.setBounds(672, 57, 86, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldQuadra);
		jTextFieldQuadra.setColumns(10);
		
		jTextFieldLote = new JTextField();
		jTextFieldLote.setBounds(806, 57, 86, 20);
		jInternalFramePrincipal.getContentPane().add(jTextFieldLote);
		jTextFieldLote.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CPF");
		lblNewLabel_5.setBounds(10, 98, 46, 14);
		jInternalFramePrincipal.getContentPane().add(lblNewLabel_5);
		
		jFormattedCpf_proprietario = new JFormattedTextField();
		jFormattedCpf_proprietario.setBounds(32, 95, 170, 20);
		jInternalFramePrincipal.getContentPane().add(jFormattedCpf_proprietario);
		
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
		
		jInternalFrameCadastroEndereço.setToolTipText("Endere\u00E7o da Cidade onde Mora");
		jInternalFrameCadastroEndereço.setBounds(10, 167, 1079, 136);
		jInternalFramePrincipal.getContentPane().add(jInternalFrameCadastroEndereço);
		jInternalFrameCadastroEndereço.getContentPane().setLayout(null);
		
		JCheckBox jCheckBoxEndereco = new JCheckBox("O Propriet\u00E1rio n\u00E3o Mora no Condominio");
		buttonGroupEndereco.add(jCheckBoxEndereco);
		jCheckBoxEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jCheckBoxEndereco.isSelected()) {
					jInternalFrameCadastroEndereço.setVisible(true);
				}
			}
		});
		jCheckBoxEndereco.setBounds(10, 135, 266, 23);
		jInternalFramePrincipal.getContentPane().add(jCheckBoxEndereco);
		
		JLabel lblNewLabel_8 = new JLabel("Endere\u00E7o");
		lblNewLabel_8.setBounds(25, 24, 76, 14);
		jInternalFrameCadastroEndereço.getContentPane().add(lblNewLabel_8);
		
		jTextFieldEnderecoProprietario = new JTextField();
		jTextFieldEnderecoProprietario.setBounds(91, 21, 543, 20);
		jInternalFrameCadastroEndereço.getContentPane().add(jTextFieldEnderecoProprietario);
		jTextFieldEnderecoProprietario.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("N\u00BA");
		lblNewLabel_9.setBounds(644, 24, 46, 14);
		jInternalFrameCadastroEndereço.getContentPane().add(lblNewLabel_9);
		
		jTextFieldNumeroEndereco = new JTextField();
		jTextFieldNumeroEndereco.setBounds(664, 21, 86, 20);
		jInternalFrameCadastroEndereço.getContentPane().add(jTextFieldNumeroEndereco);
		jTextFieldNumeroEndereco.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Complemento");
		lblNewLabel_10.setBounds(777, 24, 46, 14);
		jInternalFrameCadastroEndereço.getContentPane().add(lblNewLabel_10);
		
		jTextFieldComplemento = new JTextField();
		jTextFieldComplemento.setBounds(822, 21, 134, 20);
		jInternalFrameCadastroEndereço.getContentPane().add(jTextFieldComplemento);
		jTextFieldComplemento.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Bairro");
		lblNewLabel_11.setBounds(25, 70, 46, 14);
		jInternalFrameCadastroEndereço.getContentPane().add(lblNewLabel_11);
		
		jTextFieldBairro = new JTextField();
		jTextFieldBairro.setBounds(55, 67, 243, 20);
		jInternalFrameCadastroEndereço.getContentPane().add(jTextFieldBairro);
		jTextFieldBairro.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("CEP");
		lblNewLabel_12.setBounds(349, 70, 46, 14);
		jInternalFrameCadastroEndereço.getContentPane().add(lblNewLabel_12);
		
		jTextFieldCep = new JTextField();
		jTextFieldCep.setBounds(376, 67, 86, 20);
		jInternalFrameCadastroEndereço.getContentPane().add(jTextFieldCep);
		jTextFieldCep.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Cidade");
		lblNewLabel_13.setBounds(501, 70, 46, 14);
		jInternalFrameCadastroEndereço.getContentPane().add(lblNewLabel_13);
		
		jTextFieldCidade = new JTextField();
		jTextFieldCidade.setBounds(541, 67, 86, 20);
		jInternalFrameCadastroEndereço.getContentPane().add(jTextFieldCidade);
		jTextFieldCidade.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Estado");
		lblNewLabel_14.setBounds(684, 70, 46, 14);
		jInternalFrameCadastroEndereço.getContentPane().add(lblNewLabel_14);
		
		jTextFieldEstado = new JTextField();
		jTextFieldEstado.setBounds(726, 67, 86, 20);
		jInternalFrameCadastroEndereço.getContentPane().add(jTextFieldEstado);
		jTextFieldEstado.setColumns(10);
		
		JButton jButtonFecharInternalEndereco = new JButton("Fechar");
		jButtonFecharInternalEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jInternalFrameCadastroEndereço.dispose();
				buttonGroupEndereco.clearSelection();

			}
		});
		jButtonFecharInternalEndereco.setBounds(966, 20, 89, 23);
		jInternalFrameCadastroEndereço.getContentPane().add(jButtonFecharInternalEndereco);
		
		jButtonNovo = new JButton("Novo");
		jButtonNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = 1; 

				jButtonSalvar.setEnabled(true);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(false);
				
				jTextFieldCod_Proprietario.setEnabled(true);
				jTextFieldNomeProprietario.setEnabled(true);
				jTextFieldLote.setEnabled(true);
				jTextFieldQuadra.setEnabled(true);
				jFormattedCpf_proprietario.setEnabled(true);
				jFormattedFoneProprietario.setEnabled(true);
				jTextFieldEmailProprietario.setEnabled(true);
				jTextFieldEnderecoProprietario.setEnabled(true);
				jTextFieldNumeroEndereco.setEnabled(true);
				jTextFieldComplemento.setEnabled(true);
				jTextFieldBairro.setEnabled(true);
				jTextFieldCep.setEnabled(true);
				jTextFieldCidade.setEnabled(true);
				jTextFieldEstado.setEnabled(true);
				jComboBoxTipoMorador.setEnabled(true);
					
				jTextFieldCod_Proprietario.setText("");
				jTextFieldNomeProprietario.setText("");
				jTextFieldLote.setText("");
				jTextFieldQuadra.setText("");
				jFormattedCpf_proprietario.setText("");
				jFormattedFoneProprietario.setText("");
				jTextFieldEmailProprietario.setText("");
				jTextFieldEnderecoProprietario.setText("");
				jTextFieldNumeroEndereco.setText("");
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
					mod.setNome_proprietario(jTextFieldNomeProprietario.getText());
					mod.setLote_proprietario(jTextFieldLote.getText());
					mod.setQuadra_proprietario(jTextFieldQuadra.getText());
					mod.setCpf_proprietario(jFormattedCpf_proprietario.getText());
					mod.setTelefone_proprietario(jFormattedFoneProprietario.getText());
					mod.setEmail_proprietario(jTextFieldEmailProprietario.getText());
					mod.setData_cadastro(jTextFieldDataCadastro.getText());
					mod.setEndereco(jTextFieldEnderecoProprietario.getText());
					mod.setNumero_endereco(jTextFieldNumeroEndereco.getText());
					mod.setComplemento(jTextFieldComplemento.getText());
					mod.setBairro(jTextFieldBairro.getText());
					mod.setCep(jTextFieldCep.getText());
					mod.setCidade(jTextFieldCidade.getText());
					mod.setEstado(jTextFieldEstado.getText());
					mod.setTipo_proprietario((String)jComboBoxTipoMorador.getSelectedItem());

					control.Salvar(mod);
				
				jButtonSalvar.setEnabled(!true);
				jButtonEditar.setEnabled(!true);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(!true);
				jButtonNovo.setEnabled(true);
				
				jTextFieldNomeProprietario.setEnabled(false);
				jTextFieldLote.setEnabled(false);
		        jTextFieldQuadra.setEnabled(false);
				jFormattedCpf_proprietario.setEnabled(false);
				jFormattedFoneProprietario.setEnabled(false);
				jTextFieldEmailProprietario.setEnabled(false);
				jTextFieldDataCadastro.setEnabled(false);
				jTextFieldEnderecoProprietario.setEnabled(false);
				jTextFieldNumeroEndereco.setEnabled(false);
				jTextFieldComplemento.setEnabled(false);
				jTextFieldBairro.setEnabled(false);
				jTextFieldCep.setEnabled(false);
				jTextFieldCidade.setEnabled(false);
				jTextFieldEstado.setEnabled(false);
				jComboBoxTipoMorador.setEnabled(false);
				
				
				jTextFieldCod_Proprietario.setText("");
				jTextFieldNomeProprietario.setText("");
				jTextFieldLote.setText("");
		        jTextFieldQuadra.setText("");
				jFormattedCpf_proprietario.setText("");
				jFormattedFoneProprietario.setText("");
				jTextFieldEmailProprietario.setText("");
				jTextFieldDataCadastro.setText("");
				jTextFieldEnderecoProprietario.setText("");
				jTextFieldNumeroEndereco.setText("");
				jTextFieldComplemento.setText("");
				jTextFieldBairro.setText("");
				jTextFieldCep.setText("");
				jTextFieldCidade.setText("");
				jTextFieldEstado.setText("");
				jComboBoxTipoMorador.setSelectedItem("");
				
				jInternalFrameCadastroEndereço.dispose();
				jInternalFramePrincipal.dispose();
				buttonGroupEndereco.clearSelection();
				
				preencherTabelaProprietario("select * from proprietarios order by nome_proprietario");
				
				}else {
					mod.setNome_proprietario(jTextFieldNomeProprietario.getText());
					mod.setLote_proprietario(jTextFieldLote.getText());
					mod.setQuadra_proprietario(jTextFieldQuadra.getText());
					mod.setCpf_proprietario(jFormattedCpf_proprietario.getText());
					mod.setTelefone_proprietario(jFormattedFoneProprietario.getText());
					mod.setEmail_proprietario(jTextFieldEmailProprietario.getText());
					mod.setData_cadastro(jTextFieldDataCadastro.getText());
					mod.setEndereco(jTextFieldEnderecoProprietario.getText());
					mod.setNumero_endereco(jTextFieldNumeroEndereco.getText());
					mod.setComplemento(jTextFieldComplemento.getText());
					mod.setBairro(jTextFieldBairro.getText());
					mod.setCep(jTextFieldCep.getText());
					mod.setCidade(jTextFieldCidade.getText());
					mod.setEstado(jTextFieldEstado.getText());
					mod.setTipo_proprietario((String)jComboBoxTipoMorador.getSelectedItem());

					control.Editar(mod);
					jButtonNovo.setEnabled(true);
					jButtonSalvar.setEnabled(!true);
					jButtonEditar.setEnabled(!true);
					jButtonCancelar.setEnabled(true);
					jButtonExcluir.setEnabled(!true);
					
					jTextFieldNomeProprietario.setEnabled(false);
					jTextFieldLote.setEnabled(false);
			        jTextFieldQuadra.setEnabled(false);
					jFormattedCpf_proprietario.setEnabled(false);
					jFormattedFoneProprietario.setEnabled(false);
					jTextFieldEmailProprietario.setEnabled(false);
					jTextFieldDataCadastro.setEnabled(false);
					jTextFieldEnderecoProprietario.setEnabled(false);
					jTextFieldNumeroEndereco.setEnabled(false);
					jTextFieldComplemento.setEnabled(false);
					jTextFieldBairro.setEnabled(false);
					jTextFieldCep.setEnabled(false);
					jTextFieldCidade.setEnabled(false);
					jTextFieldEstado.setEnabled(false);
					jComboBoxTipoMorador.setEnabled(false);
						
					jTextFieldCod_Proprietario.setText("");
					jTextFieldNomeProprietario.setText("");
					jTextFieldLote.setText("");
			        jTextFieldQuadra.setText("");
					jFormattedCpf_proprietario.setText("");
					jFormattedFoneProprietario.setText("");
					jTextFieldEmailProprietario.setText("");
					jTextFieldDataCadastro.setText("");
					jTextFieldEnderecoProprietario.setText("");
					jTextFieldNumeroEndereco.setText("");
					jTextFieldComplemento.setText("");
					jTextFieldBairro.setText("");
					jTextFieldCep.setText("");
					jTextFieldCidade.setText("");
					jTextFieldEstado.setText("");
					jComboBoxTipoMorador.setSelectedItem("");
					jTextFieldPesquisar.setText("");
					
					jInternalFrameCadastroEndereço.dispose();
					jInternalFramePrincipal.dispose();
					buttonGroupEndereco.clearSelection();
					
					preencherTabelaProprietario("select * from proprietarios order by nome_proprietario");		
					
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
				jButtonCancelar.setEnabled(!true);
				jButtonExcluir.setEnabled(!true);

				jTextFieldNomeProprietario.setEnabled(true);
				jTextFieldLote.setEnabled(true);
		        jTextFieldQuadra.setEnabled(true);
				jFormattedCpf_proprietario.setEnabled(true);
				jFormattedFoneProprietario.setEnabled(true);
				jTextFieldEmailProprietario.setEnabled(true);
				jTextFieldDataCadastro.setEnabled(true);
				jTextFieldEnderecoProprietario.setEnabled(true);
				jTextFieldNumeroEndereco.setEnabled(true);
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

				jTextFieldNomeProprietario.setEnabled(!true);
				jTextFieldLote.setEnabled(!true);
		        jTextFieldQuadra.setEnabled(!true);
				jFormattedCpf_proprietario.setEnabled(!true);
				jFormattedFoneProprietario.setEnabled(!true);
				jTextFieldEmailProprietario.setEnabled(!true);
				jTextFieldDataCadastro.setEnabled(!true);
				jTextFieldEnderecoProprietario.setEnabled(!true);
				jTextFieldNumeroEndereco.setEnabled(!true);
				jTextFieldComplemento.setEnabled(!true);
				jTextFieldBairro.setEnabled(!true);
				jTextFieldCep.setEnabled(!true);
				jTextFieldCidade.setEnabled(!true);
				jTextFieldEstado.setEnabled(!true);
				jComboBoxTipoMorador.setEnabled(!true);
				
				
				jTextFieldCod_Proprietario.setText("");
				jTextFieldNomeProprietario.setText("");
				jTextFieldLote.setText("");
		        jTextFieldQuadra.setText("");
				jFormattedCpf_proprietario.setText("");
				jFormattedFoneProprietario.setText("");
				jTextFieldEmailProprietario.setText("");
				jTextFieldDataCadastro.setText("");
				jTextFieldEnderecoProprietario.setText("");
				jTextFieldNumeroEndereco.setText("");
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
				

				int confirma = 0;
				confirma = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente Excluir usuario?");
				if(confirma == JOptionPane.YES_OPTION) {
					mod.setCodigo_proprietario(Integer.parseInt(jTextFieldCod_Proprietario.getText()));
					control.Excluir(mod);
					
					jButtonSalvar.setEnabled(false);
					jButtonEditar.setEnabled(false);
					jButtonCancelar.setEnabled(!false);
					jButtonExcluir.setEnabled(false);
					jButtonNovo.setEnabled(true);

					jTextFieldNomeProprietario.setEnabled(!true);
					jTextFieldLote.setEnabled(!true);
			        jTextFieldQuadra.setEnabled(!true);
					jFormattedCpf_proprietario.setEnabled(!true);
					jFormattedFoneProprietario.setEnabled(!true);
					jTextFieldEmailProprietario.setEnabled(!true);
					jTextFieldDataCadastro.setEnabled(!true);
					jTextFieldEnderecoProprietario.setEnabled(!true);
					jTextFieldNumeroEndereco.setEnabled(!true);
					jTextFieldComplemento.setEnabled(!true);
					jTextFieldBairro.setEnabled(!true);
					jTextFieldCep.setEnabled(!true);
					jTextFieldCidade.setEnabled(!true);
					jTextFieldEstado.setEnabled(!true);
					jComboBoxTipoMorador.setEnabled(!true);
					
					jTextFieldCod_Proprietario.setText("");
					jTextFieldNomeProprietario.setText("");
					jTextFieldLote.setText("");
			        jTextFieldQuadra.setText("");
					jFormattedCpf_proprietario.setText("");
					jFormattedFoneProprietario.setText("");
					jTextFieldEmailProprietario.setText("");
					jTextFieldDataCadastro.setText("");
					jTextFieldEnderecoProprietario.setText("");
					jTextFieldNumeroEndereco.setText("");
					jTextFieldComplemento.setText("");
					jTextFieldBairro.setText("");
					jTextFieldCep.setText("");
					jTextFieldCidade.setText("");
					jTextFieldEstado.setText("");
					jComboBoxTipoMorador.setSelectedItem("");
					jTextFieldPesquisar.setText("");
					
					jInternalFrameCadastroEndereço.dispose();
					jInternalFramePrincipal.dispose();
					buttonGroupEndereco.clearSelection();
					
					preencherTabelaProprietario("select * from proprietarios order by nome_proprietario");
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
				
				mod.setPesquisa(jTextFieldPesquisar.getText());
				BeansProprietario model  = control.buscarProprietario(mod);
				
				jTextFieldCod_Proprietario.setText(String.valueOf(mod.getCodigo_proprietario()));
				jTextFieldNomeProprietario.setText(model.getNome_proprietario());
				jTextFieldLote.setText(model.getLote_proprietario());
				jTextFieldQuadra.setText(model.getQuadra_proprietario());
				jFormattedCpf_proprietario.setText(model.getCpf_proprietario());
				jFormattedFoneProprietario.setText(model.getTelefone_proprietario());
				jTextFieldEmailProprietario.setText(model.getEmail_proprietario());
				jTextFieldEnderecoProprietario.setText(model.getEndereco());
				jTextFieldNumeroEndereco.setText(model.getNumero_endereco());
				jTextFieldComplemento.setText(model.getComplemento());
				jTextFieldBairro.setText(model.getBairro());
				jTextFieldCep.setText(model.getCep());
				jTextFieldCidade.setText(model.getCidade());
				jTextFieldEstado.setText(model.getEstado());
				jComboBoxTipoMorador.setSelectedItem(model.getTipo_proprietario());
				
				jButtonNovo.setEnabled(false);
				jButtonEditar.setEnabled(true);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(true);
				jButtonSalvar.setEnabled(false);
				
								
				jInternalFrameCadastroEndereço.dispose();
				jInternalFramePrincipal.dispose();
				buttonGroupEndereco.clearSelection();
				
				preencherTabelaProprietario("select * from proprietarios where nome_proprietario like '%"+jTextFieldPesquisar.getText()+"%'");
				
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
		jRadioButtonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jRadioButtonCadastrar.isSelected()) {
					jInternalFramePrincipal.setVisible(true);
					
					flag = 1; 

					jButtonSalvar.setEnabled(true);
					jButtonEditar.setEnabled(false);
					jButtonCancelar.setEnabled(true);
					jButtonExcluir.setEnabled(false);
					
					jTextFieldCod_Proprietario.setEnabled(true);
					jTextFieldNomeProprietario.setEnabled(true);
					jTextFieldLote.setEnabled(true);
					jTextFieldQuadra.setEnabled(true);
					jFormattedCpf_proprietario.setEnabled(true);
					jFormattedFoneProprietario.setEnabled(true);
					jTextFieldEmailProprietario.setEnabled(true);
					jTextFieldEnderecoProprietario.setEnabled(true);
					jTextFieldNumeroEndereco.setEnabled(true);
					jTextFieldComplemento.setEnabled(true);
					jTextFieldBairro.setEnabled(true);
					jTextFieldCep.setEnabled(true);
					jTextFieldCidade.setEnabled(true);
					jTextFieldEstado.setEnabled(true);
					jComboBoxTipoMorador.setEnabled(true);
						
					jTextFieldCod_Proprietario.setText("");
					jTextFieldNomeProprietario.setText("");
					jTextFieldLote.setText("");
					jTextFieldQuadra.setText("");
					jFormattedCpf_proprietario.setText("");
					jFormattedFoneProprietario.setText("");
					jTextFieldEmailProprietario.setText("");
					jTextFieldEnderecoProprietario.setText("");
					jTextFieldNumeroEndereco.setText("");
					jTextFieldComplemento.setText("");
					jTextFieldBairro.setText("");
					jTextFieldCep.setText("");
					jTextFieldCidade.setText("");
					jTextFieldEstado.setText("");
					jComboBoxTipoMorador.setSelectedItem("");
					jTextFieldPesquisar.setText("");
				}
			}
		});
		jRadioButtonCadastrar.setBounds(38, 58, 223, 23);
		contentPane.add(jRadioButtonCadastrar);	
	}
	
@SuppressWarnings({ "unchecked", "static-access" })
public void preencherTabelaProprietario(String SQL) {
	
		
	
	    @SuppressWarnings("rawtypes")
		ArrayList dados = new ArrayList();
	    String[] colunas = new String[] {"CÓDIGO","PROPRIETÁRIO","TELEFONE","CPF","E-MAIL","BLOCO","APTO","TIPO"};
		conex.conexao();
		conex.executaSQL(SQL);
		
		try {
			
			conex.rs.first();
			
			do{
				
						dados.add(new Object[]{
						conex.rs.getInt("id_proprietario"),
						conex.rs.getString("nome_proprietario"),
						conex.rs.getString("telefone_proprietario"),
						conex.rs.getString("cpf_proprietario"),
						conex.rs.getString("email_proprietario"),
						conex.rs.getString("quadra_proprietario"),
						conex.rs.getString("lote_proprietario"),
						conex.rs.getString("tipo_proprietario"),
						});
				
			}while(conex.rs.next());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Não existe proprietário cadastrado no sistema. Por favor cadastre um proprietário!");
		}
		
		ModeloTabela modelo  = new ModeloTabela(dados, colunas);
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
				
				conex.executaSQL("select * from proprietarios where nome_proprietario='"+usuario+"'");
				try {
					conex.rs.first();
					jTextFieldCod_Proprietario.setText(String.valueOf(conex.rs.getInt("id_proprietario")));
					jTextFieldNomeProprietario.setText(conex.rs.getString("nome_proprietario"));
					jTextFieldQuadra.setText(conex.rs.getString("quadra_proprietario"));
					jTextFieldLote.setText(conex.rs.getString("lote_proprietario"));
					jFormattedCpf_proprietario.setText(conex.rs.getString("cpf_proprietario"));
					jFormattedFoneProprietario.setText(conex.rs.getString("telefone_proprietario"));
					jTextFieldEmailProprietario.setText(conex.rs.getString("email_proprietario"));
					jTextFieldEnderecoProprietario.setText(conex.rs.getString("endereco"));
					jTextFieldNumeroEndereco.setText(conex.rs.getString("numero_endereco"));
					jTextFieldComplemento.setText(conex.rs.getString("complemento"));
					jTextFieldBairro.setText(conex.rs.getString("bairro"));
					jTextFieldCep.setText(conex.rs.getString("cep"));
					jTextFieldCidade.setText(conex.rs.getString("cidade"));
					jTextFieldEstado.setText(conex.rs.getString("estado"));
					jComboBoxTipoMorador.setSelectedItem(conex.rs.getString("tipo_proprietario"));
					jInternalFramePrincipal.setVisible(true);
					jInternalFrameCadastroEndereço.setVisible(true);

					jTextFieldNomeProprietario.setEnabled(true);
					jTextFieldLote.setEnabled(true);
			        jTextFieldQuadra.setEnabled(true);
					jFormattedCpf_proprietario.setEnabled(true);
					jFormattedFoneProprietario.setEnabled(true);
					jTextFieldEmailProprietario.setEnabled(true);
					jTextFieldDataCadastro.setEnabled(true);
					jTextFieldEnderecoProprietario.setEnabled(true);
					jTextFieldNumeroEndereco.setEnabled(true);
					jTextFieldComplemento.setEnabled(true);
					jTextFieldBairro.setEnabled(true);
					jTextFieldCep.setEnabled(true);
					jTextFieldCidade.setEnabled(true);
					jTextFieldEstado.setEnabled(true);
					jComboBoxTipoMorador.setEnabled(true);
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null,"Erro ao selecionar Proprietário/n Erro:"+e);
				}
				
				conex.desconectar();
				
				jButtonEditar.setEnabled(!false);
				jButtonExcluir.setEnabled(!false);
				jButtonCancelar.setEnabled(!false);
			}
		});
		
}
}
		
