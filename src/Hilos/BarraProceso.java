package Hilos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BarraProceso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnIniciar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarraProceso frame = new BarraProceso();
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
	public BarraProceso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(87, 105, 266, 33);
		contentPane.add(progressBar);

		JLabel lblTitulo = new JLabel("Proceso de la barra");
		lblTitulo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblTitulo.setBounds(158, 45, 154, 23);
		contentPane.add(lblTitulo);

		setContentPane(contentPane);
		setVisible(true);
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hilo miHilo = new Hilo("HiloProceso");
				Thread miThread = new Thread(miHilo);

				HiloProceso miProceso = new HiloProceso(progressBar);
				Thread varThread = new Thread(miProceso);
				miThread.start();
				varThread.start();
				
			}
		});
		btnIniciar.setBounds(173, 181, 89, 23);
		contentPane.add(btnIniciar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBounds(173, 215, 89, 23);
		contentPane.add(btnSalir);
	}
}
