import java.io.*;
import java.util.*;

public class Main_1012 {
	
	static int T, M, N, K, result;
	static int arr[][];
	static boolean visit[][];
	
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[M][N];
			visit = new boolean[M][N];
			result = 0;
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				arr[m][n] = 1;
			}
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == 1 && visit[i][j] == false) {
						sol(i, j);
						++result;
					}
				}
			}
			
			sb.append(result).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

	
	private static void sol(int x, int y) {
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >=0 && nx < M && ny < N && visit[nx][ny] == false && arr[nx][ny] == 1) {
				sol(nx, ny);
			}
		}
		
		
	}

}

