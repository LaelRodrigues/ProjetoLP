package telas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	/** Construtor padrao */
	public Login() {
		initialize();
		LabelUsuario();
		LabelSenha();
		CampoTextoUsuario();
		CampoTextoSenha();
		BotaoAcesso();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
	
	public void LabelUsuario() {
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUsurio.setBounds(97, 80, 70, 15);
		frame.getContentPane().add(lblUsurio);
	}
	
	public void LabelSenha() {
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSenha.setBounds(106, 122, 70, 15);
		frame.getContentPane().add(lblSenha);
	}
	
	public void CampoTextoUsuario(){
		
		textField = new JTextField();
		textField.setBounds(171, 78, 114, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	public void CampoTextoSenha(){
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 119, 114, 23);
		frame.getContentPane().add(passwordField);
	}
	
	public void BotaoAcesso() {
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MediaPlayer window = new MediaPlayer();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnEntrar.setBounds(207, 154, 78, 23);
		frame.getContentPane().add(btnEntrar);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
