import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289{

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		
		int ts = Integer.parseInt(br.readLine());
		for(int t = 0; t < ts; t++) {
			String str = br.readLine();
			int cnt = 0;
			char chek = '0';
			for(int i =0; i<str.length(); i++) {
				if(chek != str.charAt(i)) {
					++cnt;
					chek = str.charAt(i);
				}
			}
			sb.append('#').append(t+1).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		
	}

}
