import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135 {

	static int N, M, D, result, kill;
	static int[][] map, submap;
	static int[] pos;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken()); //사정거리
		
		map = new int[N+1][M];
		submap = new int[N+1][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} 

		pos = new int[3];
		result = 0;
		archer(0, 0);
		
		System.out.println(result);
	}

	private static void archer(int start, int cnt) {
		if(cnt == 3) {
			fire(pos);
			result = Math.max(kill, result);
			return;
		}
		
		for(int i = start; i<M; i++) {
			pos[cnt] = i;
			archer(i+1, cnt+1);
		}
		
	}

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	private static void fire(int[] pos) {
		for(int i = 0; i<N; i++) {
			for(int j=0; j<M; j++) {
				submap[i][j] = map[i][j];
			}
		}
		kill = 0;
		int down = 0;
		Queue<Node> queue = new LinkedList<>();
		while(down < N) {
			for(int a = 0; a<3; a++) {
				int r = N - down;
				int c = pos[a];
				
				int min = 20;
				int minr = 20;
				int minc = 20;
				for(int i= N-1-down; i>=0; i--) {
					for(int j=0; j<M; j++) {
						if(submap[i][j] == 1) {
							int range = Math.abs(i-r) + Math.abs(j-c);
							if(range > D) continue;
							if(range < min) {
								min = range;
								minr = i;
								minc = j;
							}else if(range == min) {
								if(j<minc) {
									minr = i;
									minc = j;
								}
							}
								
						}
					}
					
				}
				if(minr == 20 || minc == 20 ) continue;
				queue.offer(new Node(minr, minc));
			}
			
			while(!queue.isEmpty()) {
				Node cur = queue.poll();
				int r = cur.r;
				int c = cur.c;
				
				if(submap[r][c] == 1) {
					submap[r][c] = 0;
					kill +=1;
				}
			}
			down +=1;
		}
	}
	
	
}
