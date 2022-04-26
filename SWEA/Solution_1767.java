import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767 {
	
	static class Core{
		int x;
		int y;
		
		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static ArrayList<Core> core;
	static int min, max, N;
	static int [][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			core = new ArrayList<>();
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1) {
						if(i==0 || i==N-1 || j==0 || j==N-1) continue;
						else core.add(new Core(i, j));
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			line(0, 0, 0);
			
			
			sb.append("#").append(t+1).append(" ").append(min).append("\n");
			
		}
		
		System.out.println(sb);
	}

	private static void line(int idx, int cnt, int len) {	
		///////
		if( idx == core.size()) {
			if(max < cnt) {
				max = cnt;
				min = len;
			}else if(max == cnt) {
				if(min > len) min = len;
			}
			return;
		}
		///////
		int x = core.get(idx).x;
		int y = core.get(idx).y;
		
		for(int d = 0; d<4; d++) {
			int count = 0;
			int nx = x;
			int ny = y;
			int originx = x;
			int originy = y;
			
			while(true) {
				nx += dx[d];
				ny += dy[d];
				if(nx<0 || nx>=N || ny<0 || ny>=N) break;
				if(arr[nx][ny] == 1) {
					count = 0;
					break;
				}
				count++;
			}
			for(int i =0; i<count; i++) {
				originx += dx[d];
				originy += dy[d];
				arr[originx][originy] = 1;
			}
			
			if(count == 0) {
				line(idx+1, cnt, len);
			}
			else {
				line(idx+1, cnt+1, len+count);
				
				originx = x;
				originy = y;
				
				for(int i =0; i<count; i++) {
					originx += dx[d];
					originy += dy[d];
					arr[originx][originy] = 0;
				}
			}
		}
		
		
	}

}
