package b;

public class Thread2_Alg3 extends Thread {
	public Thread2_Alg3(String threadName) {
		super(threadName);
	}

	public void run() {
		int valorTotal = 0;
		for (int i = 0; i < 100; i++) {
			do {
				Algoritimo_3.cb = true;
			} while (Algoritimo_3.ca);
			
			valorTotal = Algoritimo_3.valor;
			Algoritimo_3.cb = false;
			valorTotal++;
			Algoritimo_3.valor = valorTotal;
			System.out.println(Algoritimo_3.valor + " - II");
		}
	}
}
