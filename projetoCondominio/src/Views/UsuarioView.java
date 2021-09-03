package views;

import controller.DBConnection;
import controller.UsuarioController;
import model.TableModel;
import model.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class UsuarioView extends JFrame {

	private final JTextField jTextFieldPesquisa;
	private final JTextField jTextFieldNome;
	private final JTextField jTextFieldDocumento;
	private JTextField jTextFieldCodUsuario;
	private JTextPane jTextPaneObservacao;
	@SuppressWarnings("rawtypes")
	private final JComboBox jComboBoxTipo = new JComboBox();
	private final JButton jButtonNovo = new JButton("Novo");
	private final JButton jButtonEditar = new JButton("Editar");
	private final JButton jButtonCancelar = new JButton("Cancelar");
	private final JButton jButtonExcluir = new JButton("Excluir");
	private final JButton jButtonSalvar = new JButton("Salvar");
	private final JTable jTableTabelaUsuario;
	
	

	int flag = 0;
	
	DBConnection conex  = new DBConnection();
	UsuarioController control = new UsuarioController();
	Usuario mod = new Usuario();
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				UsuarioView frame = new UsuarioView();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public UsuarioView(){
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1023, 679);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Condominio Spazio");
		lblNewLabel.setFont(new Font("Brush Script Std", Font.PLAIN, 40));
		lblNewLabel.setBounds(5, 5, 997, 119);
		contentPane.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Controle de Acesso ao Condominio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(53, 135, 967, 473);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		jTextFieldPesquisa = new JTextField();
		jTextFieldPesquisa.setBounds(543, 28, 293, 20);
		panel_1.add(jTextFieldPesquisa);
		jTextFieldPesquisa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(24, 81, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		jTextFieldNome = new JTextField();
		jTextFieldNome.setEnabled(false);
		jTextFieldNome.setBounds(59, 78, 376, 20);
		panel_1.add(jTextFieldNome);
		jTextFieldNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Documento");
		lblNewLabel_2.setBounds(445, 81, 74, 14);
		panel_1.add(lblNewLabel_2);
		
		jTextFieldDocumento = new JTextField();
		jTextFieldDocumento.setEnabled(false);
		jTextFieldDocumento.setBounds(516, 78, 208, 20);
		panel_1.add(jTextFieldDocumento);
		jTextFieldDocumento.setColumns(10);
		
		jComboBoxTipo.setEnabled(false);
		jComboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Prestador", "Visitante"}));
		jComboBoxTipo.setBounds(774, 78, 161, 20);
		panel_1.add(jComboBoxTipo);
		
		jButtonSalvar.setBounds(145, 171, 89, 23);
		panel_1.add(jButtonSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 220, 881, 242);
		jTableTabelaUsuario = new JTable();
		panel_1.add(scrollPane);
		scrollPane.setViewportView(jTableTabelaUsuario);
		jTableTabelaUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		jTableTabelaUsuario.setBounds(20, 200, 930, 260);
		
		jButtonNovo.addActionListener(e -> {
			flag = 1;

			jButtonSalvar.setEnabled(true);
			jButtonEditar.setEnabled(false);
			jButtonCancelar.setEnabled(true);
			jButtonExcluir.setEnabled(false);

			jTextFieldNome.setEnabled(true);
			jTextFieldDocumento.setEnabled(true);
			jComboBoxTipo.setEnabled(true);
			jTextPaneObservacao.setEnabled(true);

			jTextFieldNome.setText("");
			jTextFieldDocumento.setText("");
			jComboBoxTipo.setSelectedItem("");
			jTextFieldPesquisa.setText("");
			jTextPaneObservacao.setText("");


		});
		jButtonNovo.setBounds(46, 171, 89, 23);
		panel_1.add(jButtonNovo);
		
		jButtonCancelar.addActionListener(e -> {

			jButtonSalvar.setEnabled(false);
			jButtonEditar.setEnabled(false);
			jButtonCancelar.setEnabled(false);
			jButtonExcluir.setEnabled(false);
			jButtonNovo.setEnabled(true);

			jTextFieldNome.setEnabled(false);
			jTextFieldDocumento.setEnabled(false);
			jComboBoxTipo.setEnabled(false);
			jTextPaneObservacao.setEnabled(false);

			jTextFieldCodUsuario.setText("");
			jTextFieldNome.setText("");
			jTextFieldDocumento.setText("");
			jComboBoxTipo.setSelectedItem("");
			jTextPaneObservacao.setText("");
			jTextFieldPesquisa.setText("");
						});
		jButtonCancelar.setEnabled(false);
		jButtonCancelar.setBounds(344, 171, 89, 23);
		panel_1.add(jButtonCancelar);
		
		jButtonExcluir.addActionListener(e -> {

			int confirma;
			confirma = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente Excluir usuario?");
			if(confirma == JOptionPane.YES_OPTION) {
				mod.setCodigo(Integer.parseInt(jTextFieldCodUsuario.getText()));
				control.Excluir(mod);

				jButtonSalvar.setEnabled(false);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(false);
				jButtonNovo.setEnabled(true);

				jTextFieldNome.setEnabled(false);
				jTextFieldDocumento.setEnabled(false);
				jComboBoxTipo.setEnabled(false);
				jTextPaneObservacao.setEnabled(false);



				jTextFieldCodUsuario.setText("");
				jTextFieldNome.setText("");
				jTextFieldDocumento.setText("");
				jComboBoxTipo.setSelectedItem("");
				jTextPaneObservacao.setText("");

				jTextFieldPesquisa.setText("");
				preencherTabela("select * from usuario order by nome");

			}


		});
		jButtonExcluir.setEnabled(false);
		jButtonExcluir.setBounds(444, 171, 89, 23);
		panel_1.add(jButtonExcluir);
		
		JLabel lblNewLabel_5 = new JLabel("C\u00F3digo");
		lblNewLabel_5.setBounds(24, 31, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		jTextFieldCodUsuario = new JTextField();
		jTextFieldCodUsuario.setEnabled(false);
		jTextFieldCodUsuario.setBounds(70, 28, 86, 20);
		panel_1.add(jTextFieldCodUsuario);
		jTextFieldCodUsuario.setColumns(10);
		
		jButtonEditar.addActionListener(e -> {
			flag = 2;
			jButtonNovo.setEnabled(false);
			jButtonSalvar.setEnabled(true);
			jButtonEditar.setEnabled(false);
			jButtonCancelar.setEnabled(false);
			jButtonExcluir.setEnabled(false);

			jTextFieldNome.setEnabled(true);
			jTextFieldDocumento.setEnabled(true);
			jComboBoxTipo.setEnabled(true);
			jTextPaneObservacao.setEnabled(true);

		});
		jButtonEditar.setEnabled(false);
		jButtonEditar.setBounds(245, 171, 89, 23);
		panel_1.add(jButtonEditar);

		JButton jButtonPesquisar = new JButton("Pesquisar");
		jButtonPesquisar.addActionListener(e -> {

			mod.setPesquisa(jTextFieldPesquisa.getText());
			Usuario model  = control.buscaUsuario(mod);

			jTextFieldCodUsuario.setText(String.valueOf(mod.getCodigo()));
			jTextFieldNome.setText(model.getNome());
			jTextFieldDocumento.setText(model.getDocumento());
			jComboBoxTipo.setSelectedItem(model.getTipo());
			jTextPaneObservacao.setText(model.getObservacao());


			jButtonNovo.setEnabled(false);
			jButtonEditar.setEnabled(true);
			jButtonCancelar.setEnabled(true);
			jButtonExcluir.setEnabled(true);
			jButtonSalvar.setEnabled(false);

			preencherTabela("select * from usuario where nome like '%"+jTextFieldPesquisa.getText()+"%' or documento like '%"+jTextFieldPesquisa.getText()+"%'");

			jTextFieldPesquisa.setText("");


		});
		jButtonPesquisar.setBounds(846, 27, 89, 23);
		panel_1.add(jButtonPesquisar);
		
		jButtonSalvar.setEnabled(false);
		
		JLabel lblNewLabel_3 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_3.setBounds(24, 134, 79, 14);
		panel_1.add(lblNewLabel_3);
		
		jTextPaneObservacao = new JTextPane();
		jTextPaneObservacao.setBounds(97, 123, 453, 36);
		panel_1.add(jTextPaneObservacao);
		jButtonSalvar.addActionListener(arg0 -> {

			if (jTextFieldNome.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o campo nome de usuario para continuar");
				jTextFieldNome.requestFocus();
			}else if(jTextFieldDocumento.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Preencha o campo telefone para continuar");
				jTextFieldDocumento.requestFocus();
			}else if(Objects.equals(jComboBoxTipo.getSelectedItem(), "")){
				JOptionPane.showMessageDialog(null, "Preencha o campo tipo de usuario para continuar");
				jComboBoxTipo.requestFocus();
			}

			if(flag == 1) {
			mod.setNome(jTextFieldNome.getText());
			mod.setDocumento(jTextFieldDocumento.getText());
			mod.setTipo((String)jComboBoxTipo.getSelectedItem());
			mod.setObservacao(jTextPaneObservacao.getText());
			control.Salvar(mod);

			jButtonSalvar.setEnabled(false);
			jButtonEditar.setEnabled(false);
			jButtonCancelar.setEnabled(true);
			jButtonExcluir.setEnabled(false);
			jButtonNovo.setEnabled(true);

			jTextFieldNome.setEnabled(false);
			jTextFieldDocumento.setEnabled(false);
			jComboBoxTipo.setEnabled(false);
			jTextPaneObservacao.setEnabled(false);

			jTextFieldCodUsuario.setText("");
			jTextFieldNome.setText("");
			jTextFieldDocumento.setText("");
			jComboBoxTipo.setSelectedItem("");
			jTextPaneObservacao.setText("");

			}else {
				mod.setCodigo(Integer.parseInt(jTextFieldCodUsuario.getText()));
				mod.setNome(jTextFieldNome.getText());
				mod.setDocumento(jTextFieldDocumento.getText());
				mod.setTipo((String)jComboBoxTipo.getSelectedItem());
				mod.setObservacao(jTextPaneObservacao.getText());

				control.Editar(mod);
				jButtonNovo.setEnabled(true);
				jButtonSalvar.setEnabled(false);
				jButtonEditar.setEnabled(false);
				jButtonCancelar.setEnabled(true);
				jButtonExcluir.setEnabled(false);

				jTextFieldNome.setEnabled(false);
				jTextFieldDocumento.setEnabled(false);
				jComboBoxTipo.setEnabled(false);
				jTextPaneObservacao.setEnabled(false);

				jTextFieldCodUsuario.setText("");
				jTextFieldNome.setText("");
				jTextFieldDocumento.setText("");
				jComboBoxTipo.setSelectedItem("Selecione o Tipo de Usuario");
				jTextPaneObservacao.setText("");
				jTextFieldPesquisa.setText("");


			}
			preencherTabela("select * from usuario order by nome");


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
		String[] colunas = new String[] {"C�DIGO","NOME","DOCUMENTO","TIPO"};
		conex.conexao();
		conex.executaSQL(SQL);
		
		try {
			
			conex.rs.first();
			
			do{
				
						dados.add(new Object[]{
						conex.rs.getInt("codigo"),
						conex.rs.getString("nome"),
						conex.rs.getString("documento"),
						conex.rs.getString("tipo"),
						});
				
			}while(conex.rs.next());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"N�o existe usuario cadastrado no sistema. Por favor cadastre um usuario!");
		}
		
		TableModel modelo  = new TableModel(dados, colunas);
		jTableTabelaUsuario.setModel(modelo);
		jTableTabelaUsuario.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTableTabelaUsuario.getColumnModel().getColumn(0).setResizable(false);
		jTableTabelaUsuario.getColumnModel().getColumn(1).setPreferredWidth(300);
		jTableTabelaUsuario.getColumnModel().getColumn(1).setResizable(false);
		jTableTabelaUsuario.getColumnModel().getColumn(2).setPreferredWidth(250);
		jTableTabelaUsuario.getColumnModel().getColumn(2).setResizable(false);
		jTableTabelaUsuario.getColumnModel().getColumn(3).setPreferredWidth(160);
		jTableTabelaUsuario.getColumnModel().getColumn(3).setResizable(false);
		jTableTabelaUsuario.getTableHeader().setReorderingAllowed(false);
		jTableTabelaUsuario.setAutoResizeMode(jTableTabelaUsuario.AUTO_RESIZE_OFF);
		jTableTabelaUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		conex.desconectar();
		
		jTableTabelaUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String usuario = ""+jTableTabelaUsuario.getValueAt(jTableTabelaUsuario.getSelectedRow(),1);
				
				conex.conexao();
				
				conex.executaSQL("select * from usuario where nome='"+usuario+"'");
				try {
					conex.rs.first();
					jTextFieldCodUsuario.setText(String.valueOf(conex.rs.getInt("codigo")));
					jTextFieldNome.setText(conex.rs.getString("nome"));
					jTextFieldDocumento.setText(conex.rs.getString("documento"));
					jComboBoxTipo.setSelectedItem(conex.rs.getString("tipo"));
					jTextPaneObservacao.setText(conex.rs.getString("observacao"));
					
					jTextFieldNome.setEnabled(true);
					jTextFieldDocumento.setEnabled(true);
					jComboBoxTipo.setEnabled(true);
					jTextPaneObservacao.setEnabled(true);

					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null,"Erro ao selecionar usuario/n Erro:"+e);
				}
				
				conex.desconectar();
				jButtonEditar.setEnabled(true);
				jButtonExcluir.setEnabled(true);
				jButtonCancelar.setEnabled(true);
			}
		});
	}
}
