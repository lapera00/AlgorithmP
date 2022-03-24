import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		

		
		for(int t=0; t<T; t++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int arr[][] = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				str = br.readLine();
				st = new StringTokenizer(str, " ");
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum =0;
			int temp = 0;
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					temp = 0;
					for(int x = i; x<M+i; x++) {
						for(int y = j; y<M+j; y++) {
							temp += arr[x][y];
						}
					}if(sum<temp) sum=temp;
				}
			}

			
			sb.append("#").append(t+1).append(" ").append(sum).append("\n");
			
			
		}
		System.out.println(sb);
		
	
	}

}
