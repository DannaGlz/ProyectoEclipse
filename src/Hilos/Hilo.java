package Hilos;

public class Hilo implements Runnable {
	public static boolean acabo = false;
	public static int p = 0;
	public String nombre;

	public Hilo(String n) {
		this.nombre = n;
	}

	@Override
	public void run() {
		acabo = false;
		for (int x = 1; x <= 100; x++) {
			System.out.print("PROCESANDO \n");
			p = x;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.print("INTERRUMPIDO");
			}

		}

		acabo = true;
	}

}
