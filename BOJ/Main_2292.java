import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2292 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 1; 
		int sixangle = 0; //현재층 개수
		int lastnum = 1;//마지막수
		
		while(true) {
			if( N <= lastnum) {
				break;
			}
			else {
				sixangle += 6;
				lastnum +=sixangle;
				count++;
			}
			
		}
		System.out.println(count);
	
	}
}
