package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaSplashCondominio extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TelaSplashCondominio frame = new TelaSplashCondominio();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaSplashCondominio() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 701);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 11, 1008, 640);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Condominio Spazio");
		lblNewLabel.setFont(new Font("Brush Script Std", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(301, 134, 392, 80);
		panel.add(lblNewLabel);
		
		JProgressBar jProgressBarTelaSplash = new JProgressBar();
		jProgressBarTelaSplash.setBounds(361, 250, 285, 14);
		panel.add(jProgressBarTelaSplash);
		
		JLabel jLabelMostraProgresso = new JLabel("");
		jLabelMostraProgresso.setBounds(371, 225, 275, 14);
		panel.add(jLabelMostraProgresso);
		
		JLabel lblNewLabel_1 = new JLabel("Vers\u00E3o 1.0 ");
		lblNewLabel_1.setBounds(463, 615, 92, 14);
		panel.add(lblNewLabel_1);
		
		new Thread(() -> {
			for(int i = 0; i<=100;i++) {
				try {
					Thread.sleep(60);
					jProgressBarTelaSplash.setValue(i);

					if(jProgressBarTelaSplash.getValue()<=40) {
						jLabelMostraProgresso.setText("Carregando Banco de Dados...");
					}else if (jProgressBarTelaSplash.getValue()<=70) {
						jLabelMostraProgresso.setText("Carregando Tabelas...");
					}else if (jProgressBarTelaSplash.getValue()==100) {
						jLabelMostraProgresso.setText("Conectando no Sistema...");
						TelaPrincipalCondominio tela = new TelaPrincipalCondominio();
						tela.setVisible(true);
						dispose();
					}
				}catch(Exception e) {
					Logger.getLogger(TelaSplashCondominio.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}).start();
	}
}
