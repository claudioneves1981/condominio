package Views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import Controller.ConexaoBD;
import Controller.ControleUsuario;
import ModelBeans.BeansUsuario;
import ModelBeans.ModeloTabela;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class TelaUsuario extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField jTextField_pesquisa;
	private JTextField jTextField_nome;
	private JTextField jTextField_login;
	private JTextField jTextField_Cod_Usuario;
	private JTextPane jTextPaneObservacao;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBox_tipo_usuario = new JComboBox();
	private JButton jButtonNovo = new JButton("Novo");
	private JButton jButtonEditar = new JButton("Editar");
	private JButton jButtonCancelar = new JButton("Cancelar");
	private JButton jButtonExcluir = new JButton("Excluir");
	private JButton jButton_pesquisar = new JButton("Pesquisar");
	private JButton jButtonSalvar = new JButton("Salvar");
	private JTable jTable_tabela_usuario;
	
	

	int flag = 0;
	
	ConexaoBD conex  = new ConexaoBD();
	ControleUsuario control = new ControleUsuario();
	BeansUsuario mod = new BeansUsuario();
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaUsuario(){
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1023, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Condominio Spazio");
		lblNewLabel.setFont(new Font("Brush Script Std", Font.PLAIN, 40));
		lblNewLabel.setBounds(5, 5, 997, 119);
		contentPane.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Controle de Acesso ao Condominio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(53, 135, 967, 473);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		jTextField_pesquisa = new JTextField();
		jTextField_pesquisa.setBounds(543, 28, 293, 20);
		panel_1.add(jTextField_pesquisa);
		jTextField_pesquisa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(24, 81, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		jTextField_nome = new JTextField();
		jTextField_nome.setEnabled(false);
		jTextField_nome.setBounds(59, 78, 376, 20);
		panel_1.add(jTextField_nome);
		jTextField_nome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Documento");
		lblNewLabel_2.setBounds(445, 81, 74, 14);
		panel_1.add(lblNewLabel_2);
		
		jTextField_login = new JTextField();
		jTextField_login.setEnabled(false);
		jTextField_login.setBounds(516, 78, 208, 20);
		panel_1.add(jTextField_login);
		jTextField_login.setColumns(10);
		
		jComboBox_tipo_usuario.setEnabled(false);
		jComboBox_tipo_usuario.setModel(new DefaultComboBoxModel(new String[] {"Prestador", "Visitante"}));
		jComboBox_tipo_usuario.setBounds(774, 78, 161, 20);
		panel_1.add(jComboBox_tipo_usuario);
		
		jButtonSalvar.setBounds(145, 171, 89, 23);
		panel_1.add(jButtonSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 220, 881, 242);
		jTable_tabela_usuario = new JTable();
		panel_1.add(scrollPane);
		scrollPane.setViewportView(jTable_tabela_usuario);
		jTable_tabela_usuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		jTable_tabela_usuario.setBounds(20, 200, 930, 260);
		
		jButtonNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 1; 

				jButtonSalvar.setEnabled(true);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(false);

				jTextField_nome.setEnabled(true);
				jTextField_login.setEnabled(true);
				jComboBox_tipo_usuario.setEnabled(true);
				jTextPaneObservacao.setEnabled(true);
				
				jTextField_nome.setText("");
				jTextField_login.setText("");
				jComboBox_tipo_usuario.setSelectedItem("");
				jTextField_pesquisa.setText("");
				jTextPaneObservacao.setText("");

				
			}
		});
		jButtonNovo.setBounds(46, 171, 89, 23);
		panel_1.add(jButtonNovo);
		
		jButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jButtonSalvar.setEnabled(false);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(false);
				jButtonExcluir.setEnabled(false);
				jButtonNovo.setEnabled(true);

				jTextField_nome.setEnabled(!true);
				jTextField_login.setEnabled(!true);
				jComboBox_tipo_usuario.setEnabled(!true);
				jTextPaneObservacao.setEnabled(!true);

				jTextField_Cod_Usuario.setText("");
				jTextField_nome.setText("");
				jTextField_login.setText("");
				jComboBox_tipo_usuario.setSelectedItem("");
				jTextPaneObservacao.setText("");
				jTextField_pesquisa.setText("");
							}
		});
		jButtonCancelar.setEnabled(false);
		jButtonCancelar.setBounds(344, 171, 89, 23);
		panel_1.add(jButtonCancelar);
		
		jButtonExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirma = 0;
				confirma = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente Excluir usuario?");
				if(confirma == JOptionPane.YES_OPTION) {
					mod.setUsu_cod(Integer.parseInt(jTextField_Cod_Usuario.getText()));
					control.Excluir(mod);
					
					jButtonSalvar.setEnabled(false);
					jButtonEditar.setEnabled(false);
					jButtonCancelar.setEnabled(!false);
					jButtonExcluir.setEnabled(false);
					jButtonNovo.setEnabled(true);

					jTextField_nome.setEnabled(!true);
					jTextField_login.setEnabled(!true);
					jComboBox_tipo_usuario.setEnabled(!true);
					jTextPaneObservacao.setEnabled(!true);

				
					
					jTextField_Cod_Usuario.setText("");
					jTextField_nome.setText("");
					jTextField_login.setText("");
					jComboBox_tipo_usuario.setSelectedItem("");
					jTextPaneObservacao.setText("");
					
					jTextField_pesquisa.setText("");
					preencherTabela("select * from usuarios order by usu_nome");

				}
				
				
			}
		});
		jButtonExcluir.setEnabled(false);
		jButtonExcluir.setBounds(444, 171, 89, 23);
		panel_1.add(jButtonExcluir);
		
		JLabel lblNewLabel_5 = new JLabel("C\u00F3digo");
		lblNewLabel_5.setBounds(24, 31, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		jTextField_Cod_Usuario = new JTextField();
		jTextField_Cod_Usuario.setEnabled(false);
		jTextField_Cod_Usuario.setBounds(70, 28, 86, 20);
		panel_1.add(jTextField_Cod_Usuario);
		jTextField_Cod_Usuario.setColumns(10);
		
		jButtonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 2;
				jButtonNovo.setEnabled(false);
				jButtonSalvar.setEnabled(true);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(!true);
				jButtonExcluir.setEnabled(!true);

				jTextField_nome.setEnabled(true);
				jTextField_login.setEnabled(true);
				jComboBox_tipo_usuario.setEnabled(true);
				jTextPaneObservacao.setEnabled(true);

			}
		});
		jButtonEditar.setEnabled(false);
		jButtonEditar.setBounds(245, 171, 89, 23);
		panel_1.add(jButtonEditar);
		
		jButton_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				mod.setPesquisa(jTextField_pesquisa.getText());
				BeansUsuario model  = control.buscaUsuario(mod);
				
				jTextField_Cod_Usuario.setText(String.valueOf(mod.getUsu_cod()));
				jTextField_nome.setText(model.getUsu_nome());
				jTextField_login.setText(model.getLogin_usuario());
				jComboBox_tipo_usuario.setSelectedItem(model.getTipo_usuario());
				jTextPaneObservacao.setText(model.getObservacao());

				
				jButtonNovo.setEnabled(false);
				jButtonEditar.setEnabled(true);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(true);
				jButtonSalvar.setEnabled(false);
				
				preencherTabela("select * from usuarios where usu_nome like '%"+jTextField_pesquisa.getText()+"%' or login_usuario like '%"+jTextField_pesquisa.getText()+"%'");

				jTextField_pesquisa.setText("");
				
				
			}
		});
		jButton_pesquisar.setBounds(846, 27, 89, 23);
		panel_1.add(jButton_pesquisar);
		
		jButtonSalvar.setEnabled(false);
		
		JLabel lblNewLabel_3 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_3.setBounds(24, 134, 79, 14);
		panel_1.add(lblNewLabel_3);
		
		jTextPaneObservacao = new JTextPane();
		jTextPaneObservacao.setBounds(97, 123, 453, 36);
		panel_1.add(jTextPaneObservacao);
		jButtonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (jTextField_nome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo nome de usuario para continuar");
					jTextField_nome.requestFocus();
				}else if(jTextField_login.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o campo telefone para continuar");
					jTextField_login.requestFocus();
				}else if(jComboBox_tipo_usuario.getSelectedItem().equals("")){
					JOptionPane.showMessageDialog(null, "Preencha o campo tipo de usuario para continuar");
					jComboBox_tipo_usuario.requestFocus();
				}
						
				if(flag == 1) {
				mod.setUsu_nome(jTextField_nome.getText());
				mod.setLogin_usuario(jTextField_login.getText());
				mod.setTipo_usuario((String)jComboBox_tipo_usuario.getSelectedItem());
				mod.setObservacao(jTextPaneObservacao.getText());
				control.Salvar(mod);
				
				jButtonSalvar.setEnabled(!true);
				jButtonEditar.setEnabled(!true);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(!true);
				jButtonNovo.setEnabled(true);

				jTextField_nome.setEnabled(false);
				jTextField_login.setEnabled(false);
				jComboBox_tipo_usuario.setEnabled(false);
				jTextPaneObservacao.setEnabled(false);

				jTextField_Cod_Usuario.setText("");
				jTextField_nome.setText("");
				jTextField_login.setText("");
				jComboBox_tipo_usuario.setSelectedItem("");
				jTextPaneObservacao.setText("");
				preencherTabela("select * from usuarios order by usu_nome");
				
				}else {
					mod.setUsu_cod(Integer.parseInt(jTextField_Cod_Usuario.getText()));
					mod.setUsu_nome(jTextField_nome.getText());
					mod.setLogin_usuario(jTextField_login.getText());
					mod.setTipo_usuario((String)jComboBox_tipo_usuario.getSelectedItem());
					mod.setObservacao(jTextPaneObservacao.getText());
					
					control.Editar(mod);
					jButtonNovo.setEnabled(true);
					jButtonSalvar.setEnabled(!true);
					jButtonEditar.setEnabled(!true);
					jButtonCancelar.setEnabled(true);
					jButtonExcluir.setEnabled(!true);

					jTextField_nome.setEnabled(false);
					jTextField_login.setEnabled(false);
					jComboBox_tipo_usuario.setEnabled(false);
					jTextPaneObservacao.setEnabled(false);
					
					jTextField_Cod_Usuario.setText("");
					jTextField_nome.setText("");
					jTextField_login.setText("");
					jComboBox_tipo_usuario.setSelectedItem("Selecione o Tipo de Usuario");
					jTextPaneObservacao.setText("");
					jTextField_pesquisa.setText("");
					preencherTabela("select * from usuarios order by usu_nome");

					
				}
				
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(5, 110, 997, 10);
		contentPane.add(panel);

	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public void preencherTabela(String SQL) {
		
	    @SuppressWarnings("rawtypes")
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"CÓDIGO","NOME","DOCUMENTO","TIPO"};
		conex.conexao();
		conex.executaSQL(SQL);
		
		try {
			
			conex.rs.first();
			
			do{
				
						dados.add(new Object[]{
						conex.rs.getInt("usu_cod"),
						conex.rs.getString("usu_nome"),
						conex.rs.getString("login_usuario"),
						conex.rs.getString("tipo_usuario"),
						});
				
			}while(conex.rs.next());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Não existe usuario cadastrado no sistema. Por favor cadastre um usuario!");
		}
		
		ModeloTabela modelo  = new ModeloTabela(dados, colunas);
		jTable_tabela_usuario.setModel(modelo);
		jTable_tabela_usuario.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTable_tabela_usuario.getColumnModel().getColumn(0).setResizable(false);
		jTable_tabela_usuario.getColumnModel().getColumn(1).setPreferredWidth(300);
		jTable_tabela_usuario.getColumnModel().getColumn(1).setResizable(false);
		jTable_tabela_usuario.getColumnModel().getColumn(2).setPreferredWidth(250);
		jTable_tabela_usuario.getColumnModel().getColumn(2).setResizable(false);
		jTable_tabela_usuario.getColumnModel().getColumn(3).setPreferredWidth(160);
		jTable_tabela_usuario.getColumnModel().getColumn(3).setResizable(false);
		jTable_tabela_usuario.getTableHeader().setReorderingAllowed(false);
		jTable_tabela_usuario.setAutoResizeMode(jTable_tabela_usuario.AUTO_RESIZE_OFF);
		jTable_tabela_usuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		conex.desconectar();
		
		jTable_tabela_usuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String usuario = ""+jTable_tabela_usuario.getValueAt(jTable_tabela_usuario.getSelectedRow(),1);
				
				conex.conexao();
				
				conex.executaSQL("select * from usuarios where usu_nome='"+usuario+"'");
				try {
					conex.rs.first();
					jTextField_Cod_Usuario.setText(String.valueOf(conex.rs.getInt("usu_cod")));
					jTextField_nome.setText(conex.rs.getString("usu_nome"));
					jTextField_login.setText(conex.rs.getString("login_usuario"));
					jComboBox_tipo_usuario.setSelectedItem(conex.rs.getString("tipo_usuario"));
					jTextPaneObservacao.setText(conex.rs.getString("observacao"));
					
					jTextField_nome.setEnabled(true);
					jTextField_login.setEnabled(true);
					jComboBox_tipo_usuario.setEnabled(true);
					jTextPaneObservacao.setEnabled(true);

					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null,"Erro ao selecionar usuario/n Erro:"+e);
				}
				
				conex.desconectar();
				jButtonEditar.setEnabled(!false);
				jButtonExcluir.setEnabled(!false);
				jButtonCancelar.setEnabled(!false);
			}
		});
	}
}
