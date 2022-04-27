import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3306 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++){
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N]; 
			int[] LIS = new int[N];
			
			int max = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i<N; i++) { 
				LIS[i] = 1;
				for(int j = 0; j<i; j++) {
					if(arr[j] < arr[i] && LIS[i] < LIS[j] +1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				if(max<LIS[i]) max = LIS[i];
			}
			sb.append("#").append(t+1).append(" ").append(max).append("\n");

		}
		
		System.out.println(sb);

	}

}
