package view;
import service.DBConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaPrincipalCondominio extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TelaPrincipalCondominio frame = new TelaPrincipalCondominio();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipalCondominio(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 708);
		JPanel contentPane = new JPanel();
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
		btnCadastrarUsuario.addActionListener(e -> {
				UsuarioView tela = new UsuarioView();
				tela.setVisible(true);
		});
		btnCadastrarUsuario.setBounds(26, 126, 162, 54);
		btnCadastrarUsuario.setBackground(new Color(240, 240, 240));
		panel_1.add(btnCadastrarUsuario);
		
		JButton btnCadastrarProprietario = new JButton("Proprietarios / Moradores");
		btnCadastrarProprietario.addActionListener(arg0 -> {

			ProprietarioView tela = new ProprietarioView();
			tela.setVisible(true);
		});
		btnCadastrarProprietario.setBackground(SystemColor.menu);
		btnCadastrarProprietario.setBounds(190, 126, 193, 54);
		panel_1.add(btnCadastrarProprietario);
		
	}
}
