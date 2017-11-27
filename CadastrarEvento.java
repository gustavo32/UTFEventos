import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarEvento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarEvento frame = new CadastrarEvento();
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
	public CadastrarEvento() {
		setTitle("Cadastrar Evento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 12, 70, 15);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(12, 38, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descricao");
		lblNewLabel_1.setBounds(12, 65, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data");
		lblNewLabel_2.setBounds(12, 185, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Local");
		lblNewLabel_3.setBounds(12, 212, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("CPF/CNPJ Organizador");
		lblNewLabel_5.setBounds(12, 239, 169, 15);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(41, 10, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(67, 36, 246, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 92, 424, 81);
		contentPane.add(textPane);
		
		textField_2 = new JTextField();
		textField_2.setBounds(67, 183, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(67, 210, 150, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(180, 237, 114, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Organizador org = new Organizador();
				BD bd = new BD();
				org = bd.consultaOrganizador(Integer.parseInt(textField_4.getText()));
				Evento evento = new Evento(Integer.parseInt(textField.getText()), textField_1.getText(), textPane.getText(), textField_2.getText(), textField_3.getText(), org);
				if(bd.cadastraEvento(evento)) {
					dispose();
				}
			}
		});
		btnCadastrar.setBounds(160, 268, 117, 25);
		contentPane.add(btnCadastrar);
	}
}
