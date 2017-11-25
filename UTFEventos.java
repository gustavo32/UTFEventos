import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class UTFEventos {
	private JFrame frame;
	JButton btnAtualizar = new JButton("Atualizar");
	JScrollPane scrollPane = new JScrollPane();
	@SuppressWarnings("rawtypes")
	JList list = new JList();
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	ArrayList<Evento> eventArray = new ArrayList<Evento>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UTFEventos window = new UTFEventos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public UTFEventos() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("UTFEventos");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(btnAtualizar, BorderLayout.NORTH);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		scrollPane.setColumnHeaderView(list);
		scrollPane.setViewportView(list);
		list.setModel(listModel);

		// Add fake events for testing
		for(int i = 0; i<100; i++){
			Evento evento = new Evento(i, "Nome: "+i, "Descricao: "+i, "Data: "+i, "Local: "+i, null);
			eventArray.add(evento);
		}
		for(int i = 0; i<100; i++){
			listModel.addElement(eventArray.get(i).getData() + "     " + eventArray.get(i).getNome());
		}

		//List click
		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2) {
		            // Double-click detected
							Evento selEvent = eventArray.get(list.getSelectedIndex());
							@SuppressWarnings("unused")
							EventWindow ew = new EventWindow(selEvent);
		        }
		    }
		});
		// Button click
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//listModel.addElement(String.valueOf((list.getSelectedIndex())));

			}
		});

	}

}
