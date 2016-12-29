package a;


public class Thread1_Alg4 extends Thread {
	public Thread1_Alg4(String threadName) {
		super(threadName);
	}

	public void run() {
		for (Algoritimo_4.i = 0; Algoritimo_4.i < 100; Algoritimo_4.valor++) {
			Algoritimo_4.ca = true;
			do {
				Algoritimo_4.ca = false;
				try {
					Thread1_Alg4.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Algoritimo_4.ca = true;
			} while (Algoritimo_4.cb=false);
			System.out.println(Algoritimo_4.valor + " - I");

		}
	}
}