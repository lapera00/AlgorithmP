import java.util.*;
import java.io.*;

public class Main_10159 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = -1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(arr[i][k] == arr[k][j] && arr[i][k]!=0)
						arr[i][j] = arr[i][k];
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			int result = 0;
			for(int j = 1; j <= N; j++) {
				if(i == j)
					continue;
				
				if(arr[i][j] == 0 && arr[j][i] == 0)
					result++;
			}
			System.out.println(result);
		}
		
	
	}

}
