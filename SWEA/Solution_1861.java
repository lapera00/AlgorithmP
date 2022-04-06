import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		int dx[] = {-1, 1, 0, 0};
		int dy[] = {0, 0, -1, 1};
		
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];	
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int firstroom = 0;
			int count = 0;
			int count_max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					count = 1;
					int x=i;
					int y=j;
					while(true) {
						for(int dir=0; dir<4; dir++) {
							int nx = x+dx[dir];
							int ny = y+dy[dir];
							if(nx >= 0 && ny >= 0 && nx < N && ny < N && arr[x][y] == (arr[nx][ny] -1)) {
								++count;
								x = nx;
								y = ny;
								dir = 0;
							}
						}break;
					}
					int firstroom_T = arr[i][j];
					if(count_max < count) {
						count_max = count;
						firstroom = firstroom_T;
					}else if(count_max == count) {
						firstroom = (firstroom < firstroom_T)?firstroom : firstroom_T;
					}
					
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(firstroom).append(" ").append(count_max).append("\n");
			
		}
		
		System.out.println(sb);

	}

}
