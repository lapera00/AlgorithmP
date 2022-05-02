import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656 {

	
	static int N, W, H, min;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	//횟수
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());	//높이
			int [][] map = new int[H][W];

			for(int i = 0; i<H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j =0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			fire(0, map);
			
			if(min == Integer.MAX_VALUE) {
				sb.append("#").append(t+1).append(" ").append("0").append("\n");
			}
			else sb.append("#").append(t+1).append(" ").append(min).append("\n");
					
		}
		
		System.out.println(sb);
	}

	private static void fire(int cnt, int[][] arr) {
		if(cnt == N) {
			int result = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(arr[i][j] != 0) ++result;
				}
			}
			if(min > result) min = result;
			return;
		}

		
		for (int j = 0; j < W; j++) {
			int i = 0;
			while(i < H) {
				if(arr[i][j] != 0 ) break;
				i++;
			}
			if(i == H) continue;
			
			int[][] copy = new int[H][W];
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					copy[h][w] = arr[h][w];
				}
			}
			cruch(i, j, copy);
			down(copy);
			fire(cnt+1, copy);
		}

	}
	
	private static void down(int[][] arr) {
		for(int j=0; j<W; j++) {
			for(int i=H-1; i>0; i--) {	
				if(arr[i][j] == 0) {
					int k = i-1;
					while(k >= 0) {
						if(arr[k][j] != 0) { 
							arr[i][j] = arr[k][j]; 
							arr[k][j] = 0;
							break;
							
						}
						k--;
					}
					if(k < 0) break;
				}
			}
		}
		
	}

	static class Pair {
		int x;
		int y;
		int num;
		Pair(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	
	private static void cruch(int x, int y, int[][] arr) {
		Queue<Pair>queue = new LinkedList<>();
		queue.add(new Pair(x, y, arr[x][y]));
		arr[x][y] = 0;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			for(int d=0; d<4; d++) {
				int nx = p.x;
				int ny = p.y;
				int num = p.num;
			
				for(int i=0; i<num-1; i++) {
					nx += dx[d];
					ny += dy[d];
					if(nx>=0 && nx<H && ny>=0 && ny<W) {
						if(arr[nx][ny] > 1)
							queue.offer(new Pair(nx,ny,arr[nx][ny]));
						arr[nx][ny] = 0; 
					}
				}
	
			}
		}
	}
	
}
