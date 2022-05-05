import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249 {

	static int N;
	static int[][] arr, cost;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			N = Integer.parseInt(br.readLine());  
			arr = new int[N][N];
			cost = new int[N][N];
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j =0; j<N; j++) {
					arr[i][j] = str.charAt(j) - '0';
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			
			restore();
			
			sb.append("#").append(t).append(" ").append(cost[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}

	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	private static void restore() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0));
		cost[0][0] = 0;
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if( cost[cur.x][cur.y]+arr[nx][ny] < cost[nx][ny]) {
					cost[nx][ny] = cost[cur.x][cur.y]+arr[nx][ny];
					queue.offer(new Node(nx, ny));
				}
			}
		}
		
	}
	

}
