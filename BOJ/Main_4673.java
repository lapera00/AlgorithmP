import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4673 {
	
	public static void main(String[] args) throws IOException {

		int index = 10000; 
		boolean[] selfarr = new boolean[index]; 
		
		for(int i=0; i<selfarr.length; i++) {
			if(d(i+1) < index+1)
				selfarr[d(i+1)-1] = true;
		}
		for(int i=0; i<selfarr.length; i++) {
			if(selfarr[i] == false)
				System.out.println(i+1);
		}
	}
	
	static int d(int n) {
		
		int self = n;
		
		while(n > 0) {
			self += (n % 10);
			n /= 10;
		}
		
		return self;
	}

}
