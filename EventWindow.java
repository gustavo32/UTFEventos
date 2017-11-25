import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class EventWindow{

	private JFrame frame;
	private JLabel lID;
	private JLabel lName;
	private JLabel lDate;
	private JLabel lLocal;
	private JLabel lOrganizer;
	private JTextArea taDescription;

	public EventWindow(Evento evt){
		frame = new JFrame(evt.getNome());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.requestFocus();

		lID = new JLabel("ID: "+String.valueOf(evt.getId()));
		lID.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		frame.add(lID);

		lName = new JLabel(evt.getNome());
		lName.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		frame.add(lName);

		lDate = new JLabel(evt.getData());
		lDate.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		frame.add(lDate);

		lLocal = new JLabel(evt.getLocal());
		lLocal.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		frame.add(lLocal);

		if(evt.getOrganizador() != null) {
			lOrganizer = new JLabel(evt.getOrganizador().getNome());
			lOrganizer.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			frame.add(lOrganizer);
		}
		taDescription = new JTextArea(evt.getDescricao());
		taDescription.setEditable(false);
		frame.add(taDescription);

		frame.setVisible(true);
	}
}
