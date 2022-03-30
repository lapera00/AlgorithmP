import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine()); 
		
		for(int t = 0; t<TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); 
			int M = Integer.parseInt(st.nextToken()); 
			
			st = new StringTokenizer(br.readLine(), " ");
			int arr[] = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int weight = 0;
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					weight = arr[i]+arr[j];
					if(weight <=M && weight>max) max = weight;
				}
			}
			if(max == 0) max = -1;
			
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}

}
