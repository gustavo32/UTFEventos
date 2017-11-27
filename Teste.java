import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;

public class Teste extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JMenu mnArquivo;
	private JMenuItem mntmLogin;
	/**
	 * Create the frame.
	 */
	public Teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setEnabled(false);
		menuBar.add(mnArquivo);
		
		
		JMenuItem mntmCadastrarEvento = new JMenuItem("Cadastrar Evento");
		mntmCadastrarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarEvento cadE = new CadastrarEvento();
				cadE.setVisible(true);
			}
		});
		mnArquivo.add(mntmCadastrarEvento);
		
		JMenuItem mntmConsultarEvento = new JMenuItem("Cadastrar Organizador");
		mntmConsultarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarOrganizador cadO = new CadastrarOrganizador();
				cadO.setVisible(true);
			}
		});
		mnArquivo.add(mntmConsultarEvento);
		
		JSeparator separator_4 = new JSeparator();
		mnArquivo.add(separator_4);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		
		JMenuItem mntmFaq = new JMenuItem("FAQ");
		mnAjuda.add(mntmFaq);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		menuBar.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		menuBar.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		menuBar.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		menuBar.add(separator_3);
		
		mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmLogin);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(0, 0, 448, 254);
		contentPane.add(list);
	}
	
	public void setMnArquivoEnabled(boolean enabled) {
		mnArquivo.setEnabled(enabled);
	}
	public boolean getMntmLoginEnabled() {
		return mntmLogin.isEnabled();
	}
	public void setMntmLoginEnabled(boolean enabled_1) {
		mntmLogin.setEnabled(enabled_1);
	}
}
