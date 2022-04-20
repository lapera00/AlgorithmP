import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144 {

	static int R, C, T, cleaner;
	static int [][] map;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	static class Dust {
		int x, y, a;

		public Dust(int x, int y, int a) {
			super();
			this.x = x;
			this.y = y;
			this.a = a;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for( int j = 0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) cleaner = i;
			}
		}
		
		while(T != 0) {
			--T;
			check();
			diffus();
			air();
		}
		
		int result = 0;
		for (int i = 0; i<R; i++) {
			for( int j = 0; j<C; j++) {
				if(map[i][j] != -1) {
					result += map[i][j];
				}
			}
		}
		System.out.println(result);
		
	}
	
	private static void air() {
		int first = cleaner -1;
		int second = cleaner;
		
		//역으로
		for(int i = first-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		for(int i = 0; i<C -1; i++) {
			map[0][i] = map[0][i+1];
		}
		for(int i = 0; i< first; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for(int i = C-1; i>1; i--) {
			map[first][i] = map[first][i-1];
		}
		map[first][1] = 0;
		
		for(int i = second +1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for(int i = 0; i<C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		for(int i = R-1; i>second; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for(int i = C-1; i>1; i--) {
			map[second][i] = map[second][i-1];
		}
		map[second][1] = 0;
		
	}

	private static void diffus() {
		while(!dust.isEmpty()) {
			Dust cur = dust.poll();
			if(cur.a >= 5) {
				int slice = cur.a / 5;
				int cnt = 0;
				for(int i = 0; i< 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					if(nx>=0 && ny>=0 && nx<R && ny<C && map[nx][ny] != -1) {
						map[nx][ny] += slice;
						++cnt;
					}
				}
				map[cur.x][cur.y] -= slice * cnt; 
			}
		}
		
	}

	static Queue<Dust> dust;
	private static void check() {
		dust = new LinkedList<>();
		for (int i = 0; i<R; i++) {
			for( int j = 0; j<C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0) {
					dust.offer(new Dust(i, j, map[i][j]));
				}
			}
		}
	}
	
	
	
	


}
