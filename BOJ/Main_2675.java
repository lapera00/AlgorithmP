import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2675 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			String ans = "";
			
			for(int i = 0; i<str.length(); i++) {
				for(int j = 0; j<R; j++) {
					ans += str.charAt(i);
				}
			}sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

}
