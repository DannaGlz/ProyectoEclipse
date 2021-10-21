package ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class ExpresionMatematica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtExpresionM;
	private JButton btnValidar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpresionMatematica frame = new ExpresionMatematica();
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
	public ExpresionMatematica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtExpresionM = new JTextField();
		txtExpresionM.setBounds(203, 122, 199, 29);
		contentPane.add(txtExpresionM);
		txtExpresionM.setColumns(10);

		JLabel lblTitulo = new JLabel("Expresi\u00F3n Matematica");
		lblTitulo.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblTitulo.setBounds(109, 11, 293, 23);
		contentPane.add(lblTitulo);

		JLabel lblInstruccion = new JLabel("Teclee la expresi\u00F3n: ");
		lblInstruccion.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblInstruccion.setBounds(10, 127, 183, 14);
		contentPane.add(lblInstruccion);

		btnValidar = new JButton("Validar");
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean error = false;
				Stack<Character> varPila = new Stack<>();
				char[] i = txtExpresionM.getText().toCharArray();
				for (int x = 0; x < i.length; x++) {
					
					if (i[x] == '(') {
						varPila.push('(');
					} else if (i[x] == ')') {
						if (varPila.empty()) {
							error = true;
							break;
						} else
							varPila.pop();
					}
				}
				if (!varPila.empty() || error) {JOptionPane.showMessageDialog(null, "La expresión tecleada NO es válida");
				} else if (varPila.isEmpty()) {JOptionPane.showMessageDialog(null, "La expresión tecleada Sí es válida");}
			}
		});
		btnValidar.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnValidar.setBounds(25, 198, 103, 37);
		contentPane.add(btnValidar);

		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnNewButton_1.setBounds(307, 198, 95, 37);
		contentPane.add(btnNewButton_1);
	}
}
