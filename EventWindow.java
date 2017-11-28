import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventWindow{

	private JFrame frame;
	private JLabel lID;
	private JTextField lName;
	private JTextField lDate;
	private JTextField lLocal;
	private JTextField lOrganizer;
	private JTextArea taDescription;
	private JLabel lblData;
	private JLabel lblLocal;
	private BD bd = new BD(); 
	private JLabel lblNewLabel;
	private JTextField textField;
	
	public EventWindow(Evento evt){
		frame = new JFrame(evt.getNome());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(297, 323);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.requestFocus();
		frame.getContentPane().setLayout(null);

		lID = new JLabel("ID: "+String.valueOf(evt.getId()));
		lID.setBounds(23, 5, 121, 15);
		lID.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		frame.getContentPane().add(lID);

		lName = new JTextField(evt.getNome());
		lName.setBounds(70, 22, 78, 15);
		lName.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		frame.getContentPane().add(lName);

		lDate = new JTextField(evt.getData());
		lDate.setBounds(66, 39, 78, 15);
		lDate.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		frame.getContentPane().add(lDate);

		lLocal = new JTextField(evt.getLocal());
		lLocal.setBounds(69, 56, 78, 15);
		lLocal.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		frame.getContentPane().add(lLocal);
		
		textField = new JTextField(String.valueOf(evt.getOrganizador().getCpf_cnpj()));
		textField.setBounds(140, 73, 70, 15);
		frame.getContentPane().add(textField);
		
		

	/*	if(evt.getOrganizador() != null) {
			lOrganizer = new JTextField(evt.getOrganizador().getNome());
			lOrganizer.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			frame.getContentPane().add(lOrganizer);
		}
	*/
		taDescription = new JTextArea(evt.getDescricao());
		taDescription.setBounds(23, 108, 251, 155);
		frame.getContentPane().add(taDescription);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(23, 93, 75, 15);
		frame.getContentPane().add(lblDescrio);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(23, 22, 70, 15);
		frame.getContentPane().add(lblNome);
		
		lblData = new JLabel("Data:");
		lblData.setBounds(23, 39, 70, 15);
		frame.getContentPane().add(lblData);
		
		lblLocal = new JLabel("Local:");
		lblLocal.setBounds(23, 56, 70, 15);
		frame.getContentPane().add(lblLocal);
		
		lblNewLabel = new JLabel("ID Organizador:");
		lblNewLabel.setBounds(23, 73, 117, 15);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bd.removeEvento(evt);
				Teste.listModel.clear();
				Teste.eventArray=bd.consultaEvento();
				for(int i=0;i<Teste.eventArray.size();i++) {
					Teste.listModel.addElement(Teste.eventArray.get(i).getData() + "     " + Teste.eventArray.get(i).getNome() + "       " + Teste.eventArray.get(i).getLocal());
				}
				frame.dispose();
			}
		});
		btnNewButton.setBounds(23, 267, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Organizador org = new Organizador();
				org = bd.consultaOrganizador(Integer.parseInt(textField.getText()));
				Evento evento = new Evento(evt.getId(), lName.getText(), lblDescrio.getText(), lDate.getText(), lLocal.getText(), org);
				bd.alteraEvento(evento);
			}
		});
		btnAlterar.setBounds(157, 267, 117, 25);
		frame.getContentPane().add(btnAlterar);
		

		if(!Teste.admin) {
			lName.setEditable(false);
			lDate.setEditable(false);
			lLocal.setEditable(false);
			textField.setEditable(false);
			taDescription.setEditable(false);
			btnNewButton.setVisible(false);
			btnAlterar.setVisible(false);
		}
		
		frame.setVisible(true);
	}
}
