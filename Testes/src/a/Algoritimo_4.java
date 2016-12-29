package a;


public class Algoritimo_4 {

	static int valor = 0;
	static boolean ca = false, cb = false;
	static int i=0;

	public static void main(String[] args) {
		Thread1_Alg4 nova1 = new Thread1_Alg4("Thread 1");
		Thread2_Alg4 nova2 = new Thread2_Alg4("Thread 2");
		nova1.start();
		nova2.start();
	}
}
