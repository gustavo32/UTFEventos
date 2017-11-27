import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarOrganizador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarOrganizador frame = new CadastrarOrganizador();
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
	public CadastrarOrganizador() {
		setTitle("Cadastrar Organizador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setBounds(12, 12, 70, 15);
		contentPane.add(lblCpfcnpj);
		
		textField = new JTextField();
		textField.setBounds(101, 10, 126, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 41, 70, 15);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 39, 218, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 68, 70, 15);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 66, 218, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(12, 95, 70, 15);
		contentPane.add(lblTelefone);
		
		textField_3 = new JTextField();
		textField_3.setBounds(101, 93, 127, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Organizador org = new Organizador();
				org.setCpf_cnpj(Integer.parseInt(textField.getText()));
				org.setEmail(textField_1.getText());
				org.setNome(textField_2.getText());
				org.setTelefone(Integer.parseInt(textField_3.getText()));
				BD bd = new BD();
				
				//org = bd.consultaOrganizador(org.getCpf_cnpj());
				if(bd.cadastraOrganizador(org))
					dispose();
			}
		});
		btnCadastrar.setBounds(110, 134, 117, 25);
		contentPane.add(btnCadastrar);
	}
}
