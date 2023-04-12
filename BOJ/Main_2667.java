import java.io.*;
import java.util.*;

public class Main_2667 {
	
	static int N;
	static int arr[][];
	static int result[];
	static boolean visit[][];
	static int danji = 0;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		result = new int[N*N];
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j] == 1 && visit[i][j] == false) {
					++danji;
					sol(i,j);
				}
			}
		}
		
		Arrays.sort(result);
		StringBuilder sb = new StringBuilder();
		sb.append(danji).append("\n");
		for(int i = 0; i<N*N; i++) {
			if(result[i] != 0) sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void sol(int x, int y) {
		visit[x][y] = true;
		++result[danji-1];
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny>=0 && nx<N && ny<N && arr[nx][ny] == 1 && visit[nx][ny] == false) {
				sol(nx, ny);
			}
		}
	}

}
