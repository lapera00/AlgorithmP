import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
	
		for(int t = 0; t<10; t++) {
			int N = Integer.parseInt(br.readLine());
			int aw = 1;
			
			for(int n=0; n<N; n++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				st.nextToken();
				String node = st.nextToken();

				if(st.countTokens() == 2) {
					if(node.equals("+") || node.equals("-") || node.equals("*") || node.equals("/")) {
						continue;	
					}
					else {
						aw = 0;
					}
					
				}
				
				if(st.countTokens() == 0) {
					if(node.equals("+") || node.equals("-") || node.equals("*") || node.equals("/")) {
						aw = 0;
					}
					
				}				
			}
		
			sb.append("#").append(t+1).append(" ").append(aw).append("\n");
			
			
		}
		
		System.out.println(sb);
		
	}
}
