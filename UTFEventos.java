import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public UTFEventos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnAtualizar = new JButton("Atualizar");
		frame.getContentPane().add(btnAtualizar, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		JList list = new JList();
		scrollPane.setColumnHeaderView(list);

		DefaultListModel<String> lista = new DefaultListModel<String>();

		ArrayList<Evento> l = new ArrayList<Evento>();

		for(int i = 0; i<100; i++){
			Evento evento = new Evento(i, "Nome:"+i, "Descricao:"+i, "Data:"+i, "Local"+i);
			l.add(evento);
		}
		for(int i = 0; i<100; i++){
			lista.addElement(l.get(i).getData() + "     " + l.get(i).getNome());
		}

		list.setModel(lista);
		scrollPane.setViewportView(list);

		list.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {

		            // Double-click detected
							Evento jobson = l.get(list.getSelectedIndex());
							JFrame frame = new JFrame(jobson.getNome());

		        	frame.setSize(500, 500);
		        	frame.setVisible(true);
		        } else if (evt.getClickCount() == 3) {

		            // Triple-click detected
		            int index = list.locationToIndex(evt.getPoint());
		        }
		    }
		});

		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//lista.addElement(String.valueOf((list.getSelectedIndex())));

			}
		});

	}

}
