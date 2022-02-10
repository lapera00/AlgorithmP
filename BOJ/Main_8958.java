import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_8958 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int t=0; t<N; t++) {
			
			String str = br.readLine();
			
			int cnt = 0;
			int sum = 0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) =='O') {
					++cnt;
					sum +=cnt;
				}
				else if(str.charAt(i) =='X') cnt=0;
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
