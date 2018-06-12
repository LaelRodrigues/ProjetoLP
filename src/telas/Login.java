package telas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

/**
 * Implementaï¿½ï¿½o da tela de acesso 
 * @author	Robson Lael
 * @author 	Samuel Lucas de Moura Ferino
 * @since   06.06.2018
 * @version 0.0.4
 */
public class Login {

	private JFrame frmTelaDeLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	/** 
	 * Construtor padrão 
	 */
	public Login() {
		initialize();
		LabelUsuario();
		LabelSenha();
		CampoTextoUsuario();
		CampoTextoSenha();
		BotaoAcesso();
		botaoRegistrar();
	}

	private void initialize() {
		frmTelaDeLogin = new JFrame();
		frmTelaDeLogin.setTitle("Tela de acesso");
		frmTelaDeLogin.getContentPane().setBackground(new Color(255, 255, 255));
		frmTelaDeLogin.setBounds(100, 100, 450, 300);
		frmTelaDeLogin.setLocationRelativeTo(null);
		frmTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeLogin.getContentPane().setLayout(null);
	}
	
	public void LabelUsuario() {
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsurio.setBounds(91, 79, 78, 15);
		frmTelaDeLogin.getContentPane().add(lblUsurio);
	}
	
	public void LabelSenha() {
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(106, 122, 70, 15);
		frmTelaDeLogin.getContentPane().add(lblSenha);
	}
	
	public void CampoTextoUsuario(){
		
		textField = new JTextField();
		textField.setBounds(171, 78, 114, 23);
		frmTelaDeLogin.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	public void CampoTextoSenha(){
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 119, 114, 23);
		frmTelaDeLogin.getContentPane().add(passwordField);
	}
	
	public void BotaoAcesso() {
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MediaPlayer window = new MediaPlayer();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				frmTelaDeLogin.dispose();
			}
		});
		btnEntrar.setBounds(203, 153, 82, 23);
		frmTelaDeLogin.getContentPane().add(btnEntrar);
	}
	
	public void botaoRegistrar(){
		JButton btnRegistrar = new JButton("Registrar-se");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(new Color(0, 102, 255));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MediaPlayer window = new MediaPlayer();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				frmTelaDeLogin.dispose();
			}
		});
		btnRegistrar.setBounds(302, 227, 122, 23);
		frmTelaDeLogin.getContentPane().add(btnRegistrar);

	}
	
	public JFrame getFrame() {
		return frmTelaDeLogin;
	}
}
