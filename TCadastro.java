import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFormattedTextField;

public class TCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JFormattedTextField tfCPF;
	private JFormattedTextField tfNascimento;
	private JFormattedTextField tfTelefone;
	private JTextField tfEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TCadastro frame = new TCadastro();
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
	public TCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 11, 251, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(28, 97, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		//=========LABELS DE AUXILIO DE CAMPOS, AVISAM SE O CAMPO ESTA VALIDO OU NAO==================
		
		JLabel lblCPF = new JLabel("");
		lblCPF.setBounds(284, 128, 63, 14);
		contentPane.add(lblCPF);
		
		JLabel lblNome = new JLabel("");
		lblNome.setBounds(284, 100, 63, 14);
		contentPane.add(lblNome);
		
		JLabel lblNascimento = new JLabel("");
		lblNascimento.setBounds(230, 153, 66, 14);
		contentPane.add(lblNascimento);
		
		JLabel lblEndereco = new JLabel("");
		lblEndereco.setBounds(284, 212, 63, 14);
		contentPane.add(lblEndereco);
		
		//=================================
		
		tfNome = new JTextField();
		tfNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(verificaNome(tfNome.getText())) {
					lblNome.setText("OK");
				}else {
					lblNome.setText("INVALIDO");
				}
			}
		});
		tfNome.setBounds(71, 97, 203, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		//=====================CAMPOS CPF==========================
		JLabel lblNewLabel_2 = new JLabel("CPF\r\n");
		lblNewLabel_2.setBounds(28, 122, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		try {
			tfCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tfCPF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(verificaCPF(tfCPF.getText())) {
					lblCPF.setText("OK");
				}else {
					lblCPF.setText("INVALIDO");
				} 
			}
		});
		tfCPF.setBounds(71, 122, 203, 20);
		contentPane.add(tfCPF);
		tfCPF.setColumns(11);		
		//=====================================
		
		//================CAMPOS DATA NASCIMENTO=======================
		JLabel lblNewLabel_3 = new JLabel("Nascimento\r\n");
		lblNewLabel_3.setBounds(28, 150, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		try {
			tfNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tfNascimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(verificaNascimento(tfNascimento.getText())) {
					lblNascimento.setText("OK");
				}else {
					lblNascimento.setText("INVALIDO");
				}
			}
		});
		tfNascimento.setBounds(101, 147, 119, 20);
		contentPane.add(tfNascimento);
		tfNascimento.setColumns(10);
		//============================================
		
		//===========CAMPOS TELEFONE==============
		JLabel lblNewLabel_4 = new JLabel("Telefone\r\n");
		lblNewLabel_4.setBounds(28, 175, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		try {
			tfTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tfTelefone.setBounds(84, 175, 190, 20);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		//=====================CAMPOS ENDERECO======================
		JLabel lblNewLabel_5 = new JLabel("Endereço");
		lblNewLabel_5.setBounds(28, 208, 46, 14);
		contentPane.add(lblNewLabel_5);
			
		tfEndereco = new JTextField();
		tfEndereco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(verificaEndereco(tfEndereco.getText())) {
					lblEndereco.setText("OK");
				}else {
					lblEndereco.setText("INVALIDO");
				}
			}
		});
		tfEndereco.setBounds(84, 206, 190, 20);
		contentPane.add(tfEndereco);
		tfEndereco.setColumns(10);
		//===============================
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean nomeValido = verificaNome(tfNome.getText());
				boolean CPFValido = verificaCPF(tfCPF.getText());
				boolean nascimentoValido = verificaNascimento(tfNascimento.getText());
				boolean enderecoValido = verificaEndereco(tfEndereco.getText());
				
				if(nomeValido && CPFValido && nascimentoValido && enderecoValido) {
					JOptionPane.showMessageDialog(null, "Cadastro feito");
					tfNome.setText("");
					tfCPF.setText("");
					tfNascimento.setText("");
					tfTelefone.setText("");
					tfEndereco.setText("");
					lblCPF.setText("");
					lblNome.setText("");
					lblNascimento.setText("");
					lblEndereco.setText("");
					
				}else {
					JOptionPane.showMessageDialog(null, "Cadastro nao realizado, verifique os campos");
				}
			}
		});
		btnCadastrar.setBounds(116, 237, 104, 23);
		contentPane.add(btnCadastrar);
		
		
		
		
	}
	
	//================ METODOS VERFICADORES ======================
	private static boolean verificaNome(String nome) {
		if(nome.isBlank() || nome.isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	private static boolean verificaCPF(String cpf) {
		try {
		if(cpf.isBlank() && cpf.isEmpty()) {
			return false;
		}
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		if(cpf.length() != 11) { // SE CPF NAO TIVER 11 DIGITOS, NAO IRA EXECUTAR AS VERIFICACOES E RETORNARA FALSE
			return false;
		}
				
		//========CODIGO DA VERIFICAÇAO DO PRIMEIRO DIGITO VERIFICADOR========
		boolean primeiraVer = false;
		int valor1 = 0;
		int j = 10;
		for(int i = 0; i <= 8; i++) {
			String num = "" + cpf.charAt(i);
			valor1 += Integer.parseInt(num, 10) * j;
			j--;
		}
		int digitoVer1 = 11 - (valor1 % 11);
		if(digitoVer1 == 10 || digitoVer1 == 11) {
			digitoVer1 = 0;
		} 
		if(digitoVer1 == Integer.parseInt(cpf.charAt(9) + "", 10)) {
			primeiraVer = true;
		}
		//=====================
		
		//==========CODIGO DA VERIFICAÇAO DO SEGUNDO DIGITO VERIFICADOR=======
		boolean segundaVer = false;
		int valor2 = 0;
		j = 11;
		for(int i = 0; i <= 9; i++) {
			String num = "" + cpf.charAt(i);
			valor2 += Integer.parseInt(num, 10) * j;
			j--;
		}
		int digitoVer2 = 11 - (valor2 % 11);
		if(digitoVer2 == 10 || digitoVer2 == 11) {
			digitoVer2 = 0;
		} 
		if(digitoVer2 == Integer.parseInt(cpf.charAt(10) + "", 10)) {
			segundaVer = true;
		}
		
		if(primeiraVer && segundaVer) {
			return true;
		}
		}catch(NumberFormatException e) {
			return false;
		}
		
		//==========================
		
		
		
		return false;			
	}
	
	
	private static boolean verificaNascimento(String data) {
		try {
	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	         LocalDate d = LocalDate.parse(data, formatter);    
	         return true;
	      } catch (DateTimeParseException e) {
	        return false;
	      } 
	}
	
	private static boolean verificaEndereco(String end) {
		if(end.isBlank() || end.isEmpty()) {
			return false;
		}
		return true;
	}
	//============================= 
}
