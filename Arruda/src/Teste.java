
public class Teste {
	public static void main(String[] args) {
		int n=6,r=0,c=1,s=-1;
		
		while (c<=n){
			if(c%2==0){
				r=r+c*s;
			}else
				r=r+c;
			c++;
		}
		System.out.println(r);
	}
}
