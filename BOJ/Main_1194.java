import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194 {

	static char [][] map;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static boolean visited[][][];
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		visited = new boolean[N][M][124];
		
		int startx = 0;
		int starty = 0;
		for(int i =0; i<N; i++) {
			String str = br.readLine();
			for(int j =0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					startx = i;
					starty = j;
				}
			}
		}
		
		int out = moon(startx, starty);
		System.out.println(out);

	}

	private static int moon(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, 0, 0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int i = 0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				int key = node.key;
				
				if(nx<0 || ny<0 || nx>=N ||ny>=M || map[nx][ny] == '#' || visited[nx][ny][node.key]== true ) continue;
				
				if(map[nx][ny] == '1') return node.cnt + 1;
				
				if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					key |= (1 << (map[nx][ny] - 'a'));
				}
				if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					if( (node.key & (1 <<map[nx][ny] - 'A')) == 0 ) continue;

				}
				
				visited[nx][ny][key] = true;
				queue.offer(new Node(nx, ny ,key, node.cnt+1));
							
			}
			
		}
		
		return -1;
	}

	static class Node {
		int x;
		int y;
		int key;
		int cnt;
		
		public Node(int x, int y, int key, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
			this.cnt = cnt;
		}
		
		
	}
}
