package Serie;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SerieFibo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8053442951542665165L;
	private JPanel contentPane;
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JTextField txtIteraciones;
	private JTextArea txtAreaSerie;

	public static void main(String[] args) {
		SerieFibo frame = new SerieFibo();
	    frame.setVisible(true);
		
	}

	public SerieFibo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumero1 = new JLabel("Num 1");
		lblNumero1.setBounds(26, 38, 46, 14);
		contentPane.add(lblNumero1);
		
		txtNumero1 = new JTextField();
		txtNumero1.setBounds(95, 35, 86, 20);
		contentPane.add(txtNumero1);
		txtNumero1.setColumns(10);
		
		JLabel lblNumero2 = new JLabel("Num 2");
		lblNumero2.setBounds(26, 69, 46, 14);
		contentPane.add(lblNumero2);
		
		txtNumero2 = new JTextField();
		txtNumero2.setColumns(10);
		txtNumero2.setBounds(95, 66, 86, 20);
		contentPane.add(txtNumero2);
		
		txtAreaSerie = new JTextArea();
		txtAreaSerie.setEditable(false);
		txtAreaSerie.setBounds(273, 27, 86, 197);
		contentPane.add(txtAreaSerie);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String varN1 = txtNumero1.getText();
				String varN2 = txtNumero2.getText();
				String varCiclo = txtIteraciones.getText();
				
				int N1 = Integer.parseInt(varN1);
				int N2 = Integer.parseInt(varN2);
				int ciclo = Integer.parseInt(varCiclo);
				int s = 0;
				String cadena = "";
				
				for (int x=0; x<ciclo; x++) {
		            System.out.println(N1);
		            s= N1+N2;
		            N1=N2;
		            N2=s;
		            cadena = cadena +"\n"+ s; 
		        }
				txtAreaSerie.setText(cadena);
			}
		});
		btnGenerar.setBounds(10, 201, 89, 23);
		contentPane.add(btnGenerar);
		
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
		btnSalir.setBounds(116, 201, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblIteraciones = new JLabel("Iteraciones");
		lblIteraciones.setBounds(10, 104, 75, 14);
		contentPane.add(lblIteraciones);
		
		txtIteraciones = new JTextField();
		txtIteraciones.setColumns(10);
		txtIteraciones.setBounds(95, 101, 86, 20);
		contentPane.add(txtIteraciones);
	}
}
