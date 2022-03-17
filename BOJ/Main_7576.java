import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
	
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, -1, 1}; 
	static int M, N, zerotomato, result;
	static int [][] map;
	static Queue<Node> queue;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());//세로
		N = Integer.parseInt(st.nextToken());//가로
		
		map = new int[N][M];
		queue = new LinkedList<>();
		zerotomato = 0;
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] == 1) queue.add(new Node(n, m));
				else if(map[n][m] == 0 ) ++zerotomato;
			}
		}
		
		if(zerotomato == 0) {
			System.out.println(result);
			return;
		}
		
		bfs();

		if(zerotomato != 0) {
			System.out.println("-1");
			return;
		}
		
		System.out.println(result-1);
		

	}

	private static void bfs() {
		while(zerotomato>0 && !queue.isEmpty()) {
			Node tom = queue.poll();
			for(int i =0; i<4; i++) {
				int nx = tom.x + dx[i];
				int ny = tom.y + dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] == 0) {
					--zerotomato;
					map[nx][ny] = map[tom.x][tom.y] + 1;
					if(result < map[nx][ny]) result = map[nx][ny];
					queue.add(new Node(nx, ny));
				}
			}
		}
		
	}

}
