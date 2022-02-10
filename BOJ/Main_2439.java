import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2439 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t< T; t++) {
			for(int t1=0; t1<=t; t1++) {
				sb.append("*");
			}sb.append("\n");
		}
		System.out.println(sb);
	}

}
