import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681 {
//정올
	
	static int N, result;
	static int [][] map;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		result = Integer.MAX_VALUE;
		dfs(0, 0, 0);
		
		System.out.println(result);
		
	}

	static void dfs(int start, int index, int sum) {
		if(sum >= result) return;
		if(index == N-1) {
			if(map[start][0] != 0) {
				result = Math.min(result, sum+map[start][0]);
				return;
			}
		}
		
		for(int i = 1; i<N; i++) {
			if(map[start][i] != 0 && visited[i] == false) {
				visited[i] = true;
				dfs(i, index+1, sum+map[start][i]);
				visited[i] = false;
			}
		}
	}

}
