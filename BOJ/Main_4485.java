import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_4485 {

	static class Vertex implements Comparable<Vertex>{
		int x, y, minDisance;
		
		public Vertex(int x, int y, int minDisance) {
			super();
			this.x = x;
			this.y = y;
			this.minDisance = minDisance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDisance - o.minDisance;
		}
		
	}
	static int N;
	static int[][] map, len;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 0;
		while(true) {
			++t;
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int[N][N];
			len = new int[N][N];
			
			for(int i =0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					len[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkastra(map, len);
			
			sb.append("Problem ").append(t).append(": ").append(len[N-1][N-1]).append("\n");
		}
		System.out.println(sb);

	}
	
	static int dx[] = {-1, 1, 0 ,0};
	static int dy[] = {0, 0, -1, 1};

	private static void dijkastra(int[][] map, int[][] len) {
		PriorityQueue<Vertex> pqueue = new PriorityQueue<Vertex>();
		len[0][0] = map[0][0];
		pqueue.offer(new Vertex(0, 0, map[0][0]));
		
		while (!pqueue.isEmpty()) {
			Vertex p = pqueue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = p.x + dy[d];
				int ny = p.y + dx[d];

				if (nx>=0 && nx<N && ny>=0 && ny<N) {
					if (len[nx][ny] > len[p.x][p.y] + map[nx][ny]) {
						len[nx][ny] = len[p.x][p.y] + map[nx][ny];
						pqueue.offer(new Vertex(nx, ny, len[nx][ny]));
					}
				}
			}
		}
		
	}

}
