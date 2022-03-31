import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int dx[] = {0, 0, -1};	
		int dy[] = {1, -1, 0};
		int dir = 0;
		
		int map[][] = new int[100][100];
		for(int t=0; t<10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			int x=0, y=0;
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			
			int out =0;
			
			--x; //���� �� ���ٺ��� Ž��
			
//			while(true) {
//				dir = 0;
//				while(dir<4) {
//					int nx = x+dx[dir];
//					int ny = y+dy[dir];
//					if( nx>=0 && ny>=0 && nx<100 && ny<100 && map[nx][ny] == 1) {
//						map[nx][ny] = -1;
//						x = nx;
//						y = ny;
//						++dir;
//						break;
//					}
//					++dir;
//				}
//				
//				if(x == 0) {
//					out = y;
//					break;
//				}
//			}
			
			
			
			while(true) {
				for(int i =0; i<3; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if( nx>=0 && ny>=0 && nx<100 && ny<100 && map[nx][ny] == 1) {
						map[nx][ny] = -1;
						x = nx;
						y = ny;
						break;
					}
				}
				
				if(x == 0) {
					out = y;
					break;
				}
			}
			
			sb.append("#").append(T).append(" ").append(out).append("\n");
			
		}
		System.out.println(sb);
	}

}


