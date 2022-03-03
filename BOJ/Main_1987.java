import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 {
	static int result, R, C;
	static char[][] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R+1][C+1];
		for(int r=1; r<=R; r++) {
			String s = br.readLine();
			for(int c=1; c<=C; c++) {
				arr[r][c] = s.charAt(c-1);
			}
		}
		visit = new boolean[27];
		alpha(1, 1, 1);
		System.out.println(result);
	}

	
	static int[] dx = {-1, 1, 0, 0 };
	static int[] dy = {0, 0, -1, 1 };
	private static void alpha(int x, int y, int cnt) {
		visit[arr[x][y]-'A'] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>0 && ny>0 && nx<=R && ny<=C) {
				if(visit[arr[nx][ny]-'A'] == false ) {
					alpha(nx, ny, cnt+1);
				}
			}
		}
		visit[arr[x][y] - 'A'] = false;
		result = Math.max(result,  cnt);
		
	}



}
