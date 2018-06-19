package telas;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
import javax.swing.JRadioButton;
	
public class Cadastro {

	private JFrame frmTelaDeCadastro;
	private JTextField textFieldNomeUsuario;
	private JPasswordField passwordFieldSenha;
	
	private ABB arvoreUsuarios;
	private ArquivoUsuario arqUsuario;
	private JTextField textField;
	
	/** 
	 * Construtor padrao 
	 */
	public Cadastro( Usuario usuarioAtualLogado ) {
		
		arvoreUsuarios = new ABB();
		arqUsuario = new ArquivoUsuario();
		
		initialize();
		labelNomeUsuario();
		labelSenhaUsuario();
		campoTextoNomeUsuario();
		campoTextoSenha();
		botaoConfirmar();
		labelAcessoVip();
		labelID();
		
		if( usuarioAtualLogado.isVip() == true ) {  // -> SE O USUARIO ATUAL LOGADO FOR VIP É QUE APARECE A OPCAO PARA CADASTRAR CONTA VIP
			btnsNaoSim();
		}

	}

	private void initialize() {
		frmTelaDeCadastro = new JFrame();
		frmTelaDeCadastro.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmTelaDeCadastro.setTitle("Tela de cadastro");
		frmTelaDeCadastro.getContentPane().setBackground(new Color(255, 255, 255));
		frmTelaDeCadastro.setBounds(100, 100, 350, 250);
		frmTelaDeCadastro.setLocationRelativeTo(null);
		frmTelaDeCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeCadastro.getContentPane().setLayout(null);
	}
	
	private void labelNomeUsuario() {
		
		JLabel lblNomeUsuario = new JLabel("Nome");
		lblNomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeUsuario.setBounds(26, 55, 55, 15);
		frmTelaDeCadastro.getContentPane().add(lblNomeUsuario);
	}
	
	private void labelSenhaUsuario() {
		
		JLabel lblSenhaUsuario = new JLabel("Senha");
		lblSenhaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenhaUsuario.setBounds(26, 116, 45, 15);
		frmTelaDeCadastro.getContentPane().add(lblSenhaUsuario);
	}
	
	public void campoTextoNomeUsuario(){
		
		textFieldNomeUsuario = new JTextField();
		textFieldNomeUsuario.setBounds(95, 53, 161, 23);
		frmTelaDeCadastro.getContentPane().add(textFieldNomeUsuario);
		textFieldNomeUsuario.setColumns(10);
	}
	
	public void campoTextoSenha(){
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(96, 114, 160, 23);
		frmTelaDeCadastro.getContentPane().add(passwordFieldSenha);
	}
	
	public void botaoConfirmar() {
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmar.setForeground(new Color(0, 0, 0));
		btnConfirmar.setBackground(new Color(255, 255, 255));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
		//		String loginTemporaria = textFieldNomeUsuario.getText();
		//		String senhaTemporaria = passwordFieldSenha.getText();
								
		//		arvoreUsuarios = arqUsuario.getListaUsuarios();
				
		//		if( arvoreUsuarios.buscaLocal( new Usuario(loginTemporaria, "", senhaTemporaria, false) ) != null ) {
					
			//	try {
			//		MediaPlayer window = new MediaPlayer();
				//	window.getFrame().setVisible(true);
			//	} catch (Exception e) {
				//	e.printStackTrace();
			//	}
				
				//frmTelaDeCadastro.dispose();
				frmTelaDeCadastro.setVisible(false);
	//			}
		//		else {
			//		JOptionPane.showMessageDialog(null, "Usuario nao encontrado...");
	//			}
			}
		});
		btnConfirmar.setBounds(194, 165, 114, 23);
		frmTelaDeCadastro.getContentPane().add(btnConfirmar);
		
		
		textField = new JTextField();
		textField.setBounds(95, 23, 161, 23);
		frmTelaDeCadastro.getContentPane().add(textField);
		textField.setColumns(10);
		
		
	}
	
	private void labelAcessoVip() {
		
		JLabel lblAcessoVip = new JLabel("Acesso VIP");
		lblAcessoVip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAcessoVip.setBounds(22, 81, 78, 23);
		frmTelaDeCadastro.getContentPane().add(lblAcessoVip);
		
	}
	
	private void labelID() {
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(42, 27, 46, 14);
		frmTelaDeCadastro.getContentPane().add(lblId);
		
	}
	
	private void btnsNaoSim() {
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(105, 83, 55, 23);
		
		JRadioButton rdbtnNao = new JRadioButton("Não");
		rdbtnNao.setBounds(181, 84, 55, 23);
		
		rdbtnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNao.isSelected() ) {
					rdbtnNao.setSelected(false);
				}
			}
		});
		
		rdbtnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnSim.isSelected() ) {
					rdbtnSim.setSelected(false);
				}
			}
		});	
			
		frmTelaDeCadastro.getContentPane().add(rdbtnSim);
		frmTelaDeCadastro.getContentPane().add(rdbtnNao);

	}
	
	public JFrame getFrame() {
		return frmTelaDeCadastro;
	}
}
