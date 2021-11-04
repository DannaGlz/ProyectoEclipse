package Hilos;

import javax.swing.JProgressBar;

public class HiloProceso implements Runnable {
	private javax.swing.JProgressBar bar;

	public HiloProceso(JProgressBar barra) {
		this.bar = barra;
	}

	@Override
	public void run() {
		while (!Hilo.acabo) {
			bar.setValue(Hilo.p);
			bar.repaint();
			if (Hilo.acabo) {
				bar.setValue(100);
				System.out.print("FINAL");
				System.out.print("\nSe ha compleado al 100%");
				break;
			}
		}
	}

}
