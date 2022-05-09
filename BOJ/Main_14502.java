import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {

	static int N, M, result;
	static int[][] map;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static Queue<Vir> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		//0 빈칸
		//1 벽 -3칸만듬
		//2 바이러스
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		
		result = 0;
		wall(0);

		System.out.println(result);

	}

	static int[][] submap;
	static int safe;
	
	//벽만들기
	private static void wall(int wcnt) {
		if(wcnt == 3) {
			submap = new int[N][M];
			safe = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0 ;j<M; j++) {
					submap[i][j] = map[i][j];
					if(map[i][j] == 0) ++safe;
				}
			}
			virus();
			for(int i = 0; i<N; i++) {
				for(int j = 0 ;j<M; j++) {
					map[i][j] = submap[i][j];
				}
			}
			return;
		}
		
		for(int i=0; i<N; i++){
			for(int j =0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(wcnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	static class Vir{
		int r, c;

		public Vir(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	//확산
	private static void virus() {
		Queue<Vir> queue = new LinkedList<>();
		for(int i = 0; i<N; i++) {
			for(int j = 0 ;j<M; j++) {
				if(map[i][j] == 2 ) {
					queue.offer(new Vir(i, j));
				}
				
			}
		}
		
		while(!queue.isEmpty()) {
			Vir cur = queue.poll();
			
			for(int d = 0; d <4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] == 0) {
					map[nr][nc] = 2;
					--safe;
					queue.add(new Vir(nr, nc));
				}
			}
		}

		result = Math.max(result, safe);
	}

}
