package Views;
import Controller.ConexaoBD;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalCondominio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalCondominio frame = new TelaPrincipalCondominio();
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
	ConexaoBD conectar = new ConexaoBD();
	public TelaPrincipalCondominio(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblSpazio = new JLabel("Condominio Spazio");
		lblSpazio.setFont(new Font("Brush Script Std", Font.PLAIN, 33));
		panel.add(lblSpazio);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblSolicitacoes = new JLabel("Solicita\u00E7\u00F5es:");
		lblSolicitacoes.setVerticalAlignment(SwingConstants.TOP);
		lblSolicitacoes.setBounds(26, 81, 890, 28);
		lblSolicitacoes.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblSolicitacoes);
		
		JButton btnCadastrarUsuario = new JButton("Controle de Acesso");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					TelaUsuario tela = new TelaUsuario();
					tela.setVisible(true);
			}
		});
		btnCadastrarUsuario.setBounds(26, 126, 162, 54);
		btnCadastrarUsuario.setBackground(new Color(240, 240, 240));
		panel_1.add(btnCadastrarUsuario);
		
		JButton btnCadastrarProprietario = new JButton("Proprietarios / Moradores");
		btnCadastrarProprietario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadastrarProprietario tela = new CadastrarProprietario();
				tela.setVisible(true);
			}
		});
		btnCadastrarProprietario.setBackground(SystemColor.menu);
		btnCadastrarProprietario.setBounds(190, 126, 193, 54);
		panel_1.add(btnCadastrarProprietario);
		
		conectar.conexao();
	}
}
