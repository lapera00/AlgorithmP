import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026 {

	static int N, count, count2;
	static char[][] map, map2;
	static boolean [][] visited, visited2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N]; //정상인
		map2 = new char[N][N];	//적록색약
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j =0; j<N; j++) {
				char color = str.charAt(j);
				map[i][j] = color;
				
				if(color == 'G') map2[i][j] = 'R'; //적록색약
				else map2[i][j] = color;
				
			}
		}

		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		count = 0;
		count2 = 0;
		
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(visited[i][j] == false) {
					dfs(i, j, map[i][j], visited, map);
					count++;
				}
				
				if(visited2[i][j] == false) {
					dfs(i, j, map2[i][j], visited2, map2);
					count2++;
				}
			}
		}
		System.out.println(count + " " + count2);

		
	}
	
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static void dfs(int x, int y, char color, boolean[][] visit, char[][] arr) {
		visit[x][y] = true;
		for(int i = 0; i< 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<N && visit[nx][ny] == false && arr[nx][ny]==color) {
				dfs(nx, ny, color, visit, arr);
			}
		}
		
	}



}
