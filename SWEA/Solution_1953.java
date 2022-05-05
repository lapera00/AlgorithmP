import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953 {

	static int N, M, R, C, L, result;
	static int[][] map;
	static boolean[][] visit; 
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};//상하좌우
	static int type[][] = {{0, 0, 0, 0},{1, 1, 1, 1},{1, 1, 0, 0},
			{0, 0, 1, 1},{1, 0, 0, 1},{0, 1, 0, 1},{0, 1, 1, 0},{1, 0, 1, 0},
	}; // 0,1,2,3,4,5,6,7
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());//세로
			M = Integer.parseInt(st.nextToken());//가로
			R = Integer.parseInt(st.nextToken());//맨홀 세로 위치
			C = Integer.parseInt(st.nextToken());//맨홀 가로 위치
			L = Integer.parseInt(st.nextToken());//탈출 시간
			
			map = new int [N][M];
			visit = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = 1;
			run();
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static class Node{
		int x, y, t;
		public Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	private static void run() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(R, C, 1));
		visit[R][C] = true;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(cur.t >= L) continue;
			
			int curpipe = map[cur.x][cur.y]; //현재파이프
			
			for(int d=0; d<4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(type[curpipe][d] == 0) continue;
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(visit[nx][ny]==true || map[nx][ny] == 0) continue;
				
				int goin = 0;
				if( d == 0) goin = 1;
				else if(d==1) goin = 0;
				else if(d==2) goin = 3;
				else if(d==3) goin = 2;
				if(type[map[nx][ny]][goin] != 0) {  //다음칸 입구 존재하면
					++result;//가는칸마다
					visit[nx][ny] = true;
					queue.offer(new Node(nx, ny, cur.t+1));

					
				}
				
			}
			
		}
		
	}

}
