package Serie;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana2 extends JFrame {

	private JPanel contentPane;
	private JRadioButton radOp2;
	private JRadioButton radOp3;
	private JButton btnEvaluar;
	private JButton btnSalir;
	private JButton btnAnterior;
	private JButton btnSiguiente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana2 frame = new Ventana2();
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
	public Ventana2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton radOp1 = new JRadioButton("Opcion 1");
		radOp1.setBounds(20, 57, 89, 23);
		contentPane.add(radOp1);

		radOp2 = new JRadioButton("Opcion 2");
		radOp2.setBounds(20, 95, 89, 23);
		contentPane.add(radOp2);
		
		radOp3 = new JRadioButton("Opcion 3");
		radOp3.setBounds(20, 136, 89, 23);
		contentPane.add(radOp3);
		
		JLabel lblPregunta = new JLabel("Pregunta");
		lblPregunta.setBounds(10, 36, 61, 14);
		contentPane.add(lblPregunta);
		
		ButtonGroup radOpciones = new ButtonGroup();
		radOpciones.add(radOp1);
		radOpciones.add(radOp2);
		radOpciones.add(radOp3);
		
		btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Su calificación es");
			}
		});
		btnEvaluar.setBounds(47, 203, 89, 23);
		contentPane.add(btnEvaluar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(172, 203, 89, 23);
		contentPane.add(btnSalir);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(272, 203, 89, 23);
		contentPane.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(272, 169, 89, 23);
		contentPane.add(btnSiguiente);
	}
}
