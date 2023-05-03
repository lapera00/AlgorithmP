import java.util.*;
import java.io.*;

public class Main_17182 {
	
	static int N, K, result;
	static int[][] arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visit = new boolean[N];
		result = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 플로이드 와샬 알고리즘
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		visit[K] = true;
		sol(K, 0, 0);
		System.out.println(result);
		
	}
	
	static void sol(int start, int sum, int dep) {
		if(dep == N-1) {
			result = Math.min(result,  sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				sol(i, sum + arr[start][i], dep+1);
				visit[i] = false;
			}
		}
		
	}

}
