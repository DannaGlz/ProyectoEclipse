package Quiz;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
//import java.unit.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaQuiz extends JFrame {

	private static final long serialVersionUID = 5433772910807993642L;
	private JPanel contentPane;

	String[] Quiz = { "¿Cuál es el país más grande del mundo?", "¿Qué año solo tuvo 355 días?",
			"¿Cuál es la obra más importante de la literatura en español?",
			"¿Cuál es el primer elemento de la Tabla periódica?", "¿Cuántos huesos tiene en total un ser humano?" };
	String[][] opcionesQuiz = { { "China", "Rusia", "India" }, { "1582", "1615", "1823" },
			{ "El Principito", "Don Quijote de la Mancha", "Cien años de soledad" }, { "Helio", "Argon", "Hidrogreno" },
			{ "60", "206", "416" } };
	char[] respuestasQuiz = { '2', '1', '2', '3', '2' };
	char[] respuestasSeleccionadas = new char[5];
	int p;
	private JRadioButton radOpcion1;
	private JLabel lblPregunta;
	private JRadioButton radOpcion2;
	private JRadioButton radOpcion3;
	private ButtonGroup btnGroup;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaQuiz frame = new VentanaQuiz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void mostrarSiguientePregunta() {
		btnGroup.clearSelection();
		lblPregunta.setText(Quiz[p]);
		radOpcion1.setText(opcionesQuiz[p][0]);
		radOpcion2.setText(opcionesQuiz[p][1]);
		radOpcion3.setText(opcionesQuiz[p][2]);
	}

	/**
	 * Create the frame.
	 */
	public VentanaQuiz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPregunta = new JLabel("\u00BFCu\u00E1l es el pa\u00EDs m\u00E1s grande del mundo?");
		lblPregunta.setBounds(6, 45, 418, 14);
		contentPane.add(lblPregunta);

		radOpcion1 = new JRadioButton("China");
		radOpcion1.setBounds(6, 75, 109, 23);
		contentPane.add(radOpcion1);

		radOpcion2 = new JRadioButton("Rusia");
		radOpcion2.setBounds(6, 111, 109, 23);
		contentPane.add(radOpcion2);

		radOpcion3 = new JRadioButton("India");
		radOpcion3.setBounds(6, 147, 109, 23);
		contentPane.add(radOpcion3);

		btnGroup = new ButtonGroup();
		btnGroup.add(radOpcion1);
		btnGroup.add(radOpcion2);
		btnGroup.add(radOpcion3);

		JLabel lblTitulo = new JLabel("CULTURA GENERAL");
		lblTitulo.setBounds(170, 11, 167, 23);
		contentPane.add(lblTitulo);

		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (0 < p) {
					p--;
					mostrarSiguientePregunta();
				} else {
					JOptionPane.showMessageDialog(null, "No hay siguiente pregunta");
				}
			}
		});
		btnAnterior.setBounds(21, 203, 89, 23);
		contentPane.add(btnAnterior);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (radOpcion1.isSelected()) {
					respuestasSeleccionadas[p] = '1';
				}
				if (radOpcion2.isSelected()) {
					respuestasSeleccionadas[p] = '2';
				}
				if (radOpcion3.isSelected()) {
					respuestasSeleccionadas[p] = '3';
				}
				if (p < Quiz.length - 1) {
					p++;
					mostrarSiguientePregunta();
				} else {
					JOptionPane.showMessageDialog(null, "No hay siguiente pregunta");
				}
			}
		});
		btnSiguiente.setBounds(135, 203, 89, 23);
		contentPane.add(btnSiguiente);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(322, 203, 89, 23);
		contentPane.add(btnSalir);

		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numAciertos = 0;
				for (int x = 0; x < respuestasSeleccionadas.length; x++) {
					if (respuestasSeleccionadas[x] == respuestasQuiz[x])
						numAciertos++;
				}
				JOptionPane.showMessageDialog(null,
						String.format("Tienes correctas %d preguntas de %d", numAciertos, Quiz.length));
			}
		});
		btnEvaluar.setBounds(322, 171, 89, 23);
		contentPane.add(btnEvaluar);
	}

}
