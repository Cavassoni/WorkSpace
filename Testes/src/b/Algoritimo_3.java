package b;


public class Algoritimo_3 {

	static int valor = 0;
	static boolean ca = false, cb = false;

	public static void main(String[] args) {
		Thread1_Alg3 nova1 = new Thread1_Alg3("Thread 1");
		Thread2_Alg3 nova2 = new Thread2_Alg3("Thread 2");
		nova1.start();
		nova2.start();
	}
}
