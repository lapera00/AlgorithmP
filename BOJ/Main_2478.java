import java.io.*;
import java.util.*;

public class Main_2478 {
	
	static int N;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		StringTokenizer st;
		int maxH = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > maxH) maxH = arr[i][j];
			}
		}
		
		int result = 0;
		
		for(int h = 0; h < maxH; h++) {
			check = new boolean[N][N];
			int cnt = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(check[i][j] == false && arr[i][j] > h) {
						cnt += dfs(i, j, h);
					}
				}
			}
			result = Math.max(result, cnt);
		}
		
		
		System.out.print(result);
		
		
	}

	private static int dfs(int x, int y, int h) {
		check[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1 || check[nx][ny] == true) continue;
			if(arr[nx][ny] > h) dfs(nx, ny, h);
		}
		
		return 1;
	}

}
