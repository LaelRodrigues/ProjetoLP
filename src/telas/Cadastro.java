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
	
/**
 * Representa a tela de cadastro
 * @author	Samuel Lucas de Moura Ferino
 * @since 	20.06.2018
 * @version 0.0.3
 */
public class Cadastro {

	private JFrame frmTelaDeCadastro;
	
	private JTextField textFieldNomeUsuario;
	private JPasswordField passwordFieldSenha;
	private JTextField textFieldID;
	private JRadioButton rdbtnSim;
	private JRadioButton rdbtnNao;
	
	private ABB arvoreUsuarios;
	private ArquivoUsuario arqUsuario;
	
	/** 
	 * Construtor padrão 
	 */
	public Cadastro( Usuario usuarioAtualLogado ) {
		
		arqUsuario = new ArquivoUsuario();
		arvoreUsuarios = arqUsuario.getListaUsuarios();
		
		initialize();
		labelNomeUsuario();
		labelSenhaUsuario();
		campoTextoNomeUsuario();
		campoTextoSenha();
		botaoConfirmar();
		labelAcessoVip();
		labelID();
		
		if( usuarioAtualLogado.isVip() == true ) {  // -> SE O USUARIO ATUAL LOGADO FOR VIP � QUE APARECE A OPCAO PARA CADASTRAR CONTA VIP
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
				
				String loginTemporaria = textFieldID.getText();
				String nomeTemporario = textFieldNomeUsuario.getText();
				String senhaTemporaria = passwordFieldSenha.getText();
				boolean modoDeAcesso;
				
				if( rdbtnSim.isSelected()) {
					modoDeAcesso = true;
				}
				else {
					modoDeAcesso = false;
				}
				
								
				arvoreUsuarios = arqUsuario.getListaUsuarios();
				Usuario usuarioEncontrado = arvoreUsuarios.buscaLocal( new Usuario(loginTemporaria, "", senhaTemporaria, false) );
				
				if(loginTemporaria.equals("") ) {
					JOptionPane.showMessageDialog(null, "Digite o id...");
				}
				else if(nomeTemporario.equals("") ) {
					JOptionPane.showMessageDialog(null, "Digite o nome...");
				}
				else if( !rdbtnSim.isSelected() && !rdbtnNao.isSelected()) {
					JOptionPane.showMessageDialog(null, "Selecione a opção do modo de acesso. É vip ou não?");
				}else if(senhaTemporaria.equals("") ) {
					JOptionPane.showMessageDialog(null, "Digite a senha...");
				}
				else if( usuarioEncontrado != null ) {
					
					JOptionPane.showMessageDialog(null, "Um usuário com esse login já está cadastrado...");

					textFieldID.setText("");
					textFieldNomeUsuario.setText("");
					passwordFieldSenha.setText("");
					rdbtnSim.setSelected(false);
					rdbtnNao.setSelected(false);
				}
				else {
					arvoreUsuarios.insere( new Usuario(loginTemporaria, nomeTemporario, senhaTemporaria, modoDeAcesso) );
					arqUsuario.add( new Usuario(loginTemporaria, nomeTemporario, senhaTemporaria, modoDeAcesso) );
					
					boolean a = arqUsuario.criaOuAtualiza();
					System.out.println("LINHA 156" + a);
					
					frmTelaDeCadastro.setVisible(false);
				}
				
			}
		});
		btnConfirmar.setBounds(194, 165, 114, 23);
		frmTelaDeCadastro.getContentPane().add(btnConfirmar);
		
		
		textFieldID = new JTextField();
		textFieldID.setBounds(95, 23, 161, 23);
		frmTelaDeCadastro.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		
	}
	
	private void labelAcessoVip() {
		
		JLabel lblAcessoVip = new JLabel("Acesso VIP");
		lblAcessoVip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAcessoVip.setBounds(22, 81, 78, 23);
		frmTelaDeCadastro.getContentPane().add(lblAcessoVip);
		
	}
	
	private void labelID() {
		
		JLabel lblIDUsuario = new JLabel("ID");
		lblIDUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIDUsuario.setBounds(42, 27, 46, 14);
		frmTelaDeCadastro.getContentPane().add(lblIDUsuario);
		
	}
	
	private void btnsNaoSim() {
		
		rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(105, 83, 55, 23);
		
		rdbtnNao = new JRadioButton("Não");
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
