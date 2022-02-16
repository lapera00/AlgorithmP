import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N][M];
		
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m=0; m<M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		int dx[] = {0, 1, 0, -1};
		int dy[] = {1, 0, -1, 0};
		int idx;
		int temp = 0;
		int rol = Math.min(N, M)/2;
		
		for(int r = 0; r<R; r++) {
			for(int i=0; i<rol; i++) {
				int x = i;
				int y = i;
				temp = arr[x][y];
				idx = 0;
				while(idx<4) {
					int nx = x + dx[idx];
					int ny = y + dy[idx];

					if(nx>=i && ny>=i && nx<N-i && ny<M-i) {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					}else ++idx;
				}
				arr[i+1][i] = temp;
			}
		}
		

		
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				sb.append(arr[n][m]).append(" ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}

}
