import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int oring = N;
		int cnt = 0;
		int temp = 0;
		
		while(true) {
			int temp1 = N/10;
			int temp2 = N%10;
			
			temp = (temp1 + temp2)%10;
			
			N = temp2*10+temp;
			
			++cnt;
			if(N==oring)break;
		}
		
		System.out.println(cnt);
	}

}
