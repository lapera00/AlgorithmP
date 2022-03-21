import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		int dx[] = {0, 1, 0, -1};
		int dy[] = {1, 0, -1, 0};
		
		for(int tt = 0; tt<t; tt++) {
			int n = Integer.parseInt(br.readLine());
			if(n>10 || n<=0) return;
			if(n ==1) {
				sb.append("#").append(tt+1).append("\n");
				sb.append(1).append("\n");
				continue;
			}
			
			int arr[][] = new int[n][n];
			
			int x = 0;
			int y = 0;
			int dir = 0;
			
			for(int i=0; i<n*n; i++) {
				arr[x][y] = i+1;
				x += dx[dir];
				y += dy[dir];
				if( x>=n || y>=n || x<0 || y<0 ) {
					x -= dx[dir];
					y -= dy[dir];
					dir = (dir+1)%4;
					x += dx[dir];
					y += dy[dir];
				}
				if(arr[x][y] != 0) {
					x -= dx[dir];
					y -= dy[dir];
					dir = (dir+1)%4;
					x += dx[dir];
					y += dy[dir];
				}
			}
			
			
			sb.append("#").append(tt+1).append("\n");
			for(int x1=0; x1<n; x1++) {
				for(int y1=0; y1<n; y1++) {
					sb.append(arr[x1][y1]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);

	}

}
