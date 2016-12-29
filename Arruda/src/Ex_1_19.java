
public class Ex_1_19 {
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			if(hePrimo(i))
				System.out.println(i+" - é primo");
			else
				System.out.println(i+" - Não é primo ");
		}
	}

	public static boolean hePrimo(int num) {
		int cont = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				cont++;
			}
		}
		if (cont == 2) {
			return true;
		} else {
			return false;
		}
	}
}
