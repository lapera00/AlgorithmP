import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int dx[] = {-1, 1, 0, 0};	//0�� 1�� 2�� 3��
		int dy[] = {0, 0, -1, 1};
		
		for(int t=0; t<T; t++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char arr[][] = new char[H][W];
			for(int i = 0; i<H; i++) {
				str = br.readLine();
				for(int j = 0; j<W; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			int go = Integer.parseInt(br.readLine());
			if(go<0 || go>100)return;
			else if (go == 0) {
				sb.append("#").append(t+1).append(" ");
				for(int i = 0; i<H; i++) {
					for(int j = 0; j<W; j++) {
						sb.append(arr[i][j]);
					}sb.append("\n");
				}
				continue;
			}
			
			str = br.readLine();
			char move[] = new char[go];
			for(int i=0; i<go; i++) {
				move[i] = str.charAt(i);
			}
			
			int x = 0;
			int y = 0;
			int d = 0;
			
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					if(arr[i][j]=='^') {
						x = i;
						y = j;
						d = 0;
					}else if(arr[i][j] == 'v') {
						x = i;
						y = j;
						d = 1;
					}else if(arr[i][j] == '<') {
						x = i;
						y = j;
						d = 2;
					}else if(arr[i][j] == '>') {
						x = i;
						y = j;
						d = 3;
					}
				}
			}
			
			int shotp=1;

			for(int i=0; i<go; i++) {
				
				if(move[i]=='S') {
					int nr = x;
					int nc = y;
					while (true) { 
						nr += dx[d];
						nc += dy[d];
						if (nr < 0 || nr >= H || nc < 0 || nc >= W)
							break;
						if (arr[nr][nc] == '#')
							break;
						if (arr[nr][nc] == '*') { 
							arr[nr][nc] = '.';
							break;
						}
					}

				}else if(move[i]=='U') {
					shotp=1;
					arr[x][y] = '^';
					d = 0;
					if(x+dx[d] < H && y+dy[d] <W &&x+dx[d]>=0 && y+dy[d]>=0 && arr[x+dx[d]][y+dy[d]] == '.') {
						arr[x][y] = '.';
						x = x+dx[d];
						y = y+dy[d];
						arr[x][y] = '^';
						continue;
					}
					
				}else if(move[i]=='D') {
					shotp=1;
					arr[x][y] = 'v';
					d = 1;
					if(x+dx[d] < H && y+dy[d] <W &&x+dx[d]>=0 && y+dy[d]>=0 && arr[x+dx[d]][y+dy[d]] == '.') {
						arr[x][y] = '.';
						x = x+dx[d];
						y = y+dy[d];
						arr[x][y] = 'v';
						continue;
					}
					
				}else if(move[i]=='L') {
					shotp=1;
					arr[x][y] = '<';
					d = 2;
					if(x+dx[d] < H && y+dy[d] <W &&x+dx[d]>=0 && y+dy[d]>=0 && arr[x+dx[d]][y+dy[d]] == '.') {
						arr[x][y] = '.';
						x = x+dx[d];
						y = y+dy[d];
						arr[x][y] = '<';
						continue;
					}
					
				}else if(move[i]=='R') {
					shotp=1;
					arr[x][y] = '>';
					d = 3;
					if(x+dx[d] < H && y+dy[d] <W &&x+dx[d]>=0 && y+dy[d]>=0 && arr[x+dx[d]][y+dy[d]] == '.') {
						arr[x][y] = '.';
						x = x+dx[d];
						y = y+dy[d];
						arr[x][y] = '>';
						continue;
					}
					
				}
				
			}
			
			
			
			
			sb.append("#").append(t+1).append(" ");
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					sb.append(arr[i][j]);
				}sb.append("\n");
			}
			
			
		}
		System.out.println(sb);

	}

}
