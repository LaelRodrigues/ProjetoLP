package telas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

import dadosDosArquivos.ArquivoUsuario;
import arvoreBinariaDeBusca.ABB;
import classes.Usuario;
/**
 * Implementacao da tela de acesso 
 * @author	Robson Lael
 * @author 	Samuel Lucas de Moura Ferino
 * @since   06.06.2018
 * @version 0.0.4
 */
public class Login {

	private JFrame frmTelaDeLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private ABB arvoreUsuarios;
	private ArquivoUsuario arqUsuario;
	
	/** 
	 * Construtor padrao 
	 */
	public Login() {

		arqUsuario = new ArquivoUsuario();
		arvoreUsuarios = arqUsuario.getListaUsuarios();
		
		initialize();
		LabelUsuario();
		LabelSenha();
		CampoTextoUsuario();
		CampoTextoSenha();
		BotaoAcesso();

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
		
		JLabel lblUsurio = new JLabel("ID");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsurio.setBounds(126, 80, 78, 15);
		frmTelaDeLogin.getContentPane().add(lblUsurio);
	}
	
	public void LabelSenha() {
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(106, 122, 70, 15);
		frmTelaDeLogin.getContentPane().add(lblSenha);
	}
	
	public void CampoTextoUsuario(){
		
		textField = new JTextField();
		textField.setBounds(171, 78, 144, 23);
		frmTelaDeLogin.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	public void CampoTextoSenha(){
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 119, 144, 23);
		frmTelaDeLogin.getContentPane().add(passwordField);
	}
	
	public void BotaoAcesso() {
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				String loginTemporaria = textField.getText();
				String senhaTemporaria = passwordField.getText();
								
				arvoreUsuarios = arqUsuario.getListaUsuarios();
				
				Usuario usuarioLogadoAtual = arvoreUsuarios.buscaLocal( new Usuario(loginTemporaria, "", senhaTemporaria, true) );
					
				if( usuarioLogadoAtual != null && usuarioLogadoAtual.getSenha().equals(senhaTemporaria) == true) { // -> A BUSCA DA ARVORE COMPARA APENAS O ID
					
					try {
						MediaPlayer window = new MediaPlayer(usuarioLogadoAtual);
						window.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					frmTelaDeLogin.dispose();
				}
				else {
					
					if( usuarioLogadoAtual != null &&  usuarioLogadoAtual.getSenha().equals(senhaTemporaria) == false) {
						JOptionPane.showMessageDialog(null, "Senha errada. Tente novamente!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Usuário não encontrado...");
					}	
					
					textField.setText("");	// -> LIMPANDO AS CAIXAS DE TEXTO
					passwordField.setText("");
				
				}
			}
		});
		btnEntrar.setBounds(269, 182, 82, 23);
		frmTelaDeLogin.getContentPane().add(btnEntrar);
	}
	
	public JFrame getFrame() {
		return frmTelaDeLogin;
	}
}
