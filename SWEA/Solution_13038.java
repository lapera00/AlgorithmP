import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_13038 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[7];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i =0; i<7; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); 
			}
			
			int day = Integer.MAX_VALUE;
			boolean start = false;
			
			for(int x=0; x<7; x++) {
				int temp = 0;
				boolean first = true;
				int N=n;
				out : while(true) {
					if(N == 0) break;
					if(first) {
						for(int j = x; j<7; j++) {
							if(arr[j] == 1) {
								++temp;
								--N;
								start = true;
							}
							if(start && arr[j] == 0) ++temp;
							if(N == 0) break out;
						}
						first=false;
					}
					
					for(int i = 0; i<7; i++) {
						if(arr[i] == 1) {
							++temp;
							--N;
							start = true;
						}
						if(start && arr[i] == 0) ++temp;
						if(N == 0) break out;
					}
				}
				if(day>temp) day=temp;
			}
			
			sb.append("#").append(t+1).append(" ").append(day).append("\n");
		
		}
		System.out.println(sb);

	}

}
