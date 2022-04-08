import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int dx[] = {0, -1, 0, 1, 0 };	// x, 상, 우, 하, 좌
		int dy[] = {0, 0, 1, 0, -1};
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); //총이동횟수
			int A = Integer.parseInt(st.nextToken()); //bc개수
			int goA[] = new int[M+1];	//1 이동방향 + 첫자리
			int goB[] = new int[M+1];	//2 이동방향 + 첫자리
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<M+1; i++) {	//처음 자리 0 추가
				goA[i] = Integer.parseInt(st.nextToken()); 
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<M+1; i++) {	//처음 자리 0 추가
				goB[i] = Integer.parseInt(st.nextToken()); 
			}
			int xycp[][] = new int[A][4]; //bc정보: x,y,범위,처리량
			for(int a=0; a<A; a++) {
				st = new StringTokenizer(br.readLine(), " ");
				xycp[a][0] = Integer.parseInt(st.nextToken());
				xycp[a][1] = Integer.parseInt(st.nextToken());
				xycp[a][2] = Integer.parseInt(st.nextToken());
				xycp[a][3] = Integer.parseInt(st.nextToken());
			}
			
			
			
			int bc = xycp.length;
			int result = 0;
			int xA = 1, yA = 1;
			int xB = 10, yB = 10;
			
			for(int m=0; m<=M; m++) {
				int ya = xA + dx[goA[m]];	//행렬에서 xy로 좌표변환
				int xa = yA + dy[goA[m]];
				int yb = xB + dx[goB[m]];
				int xb = yB + dy[goB[m]];

				int full = 0;
				for( int i = 0; i< bc; i++) {
					int temp1=0;
					if(Math.abs(xa-xycp[i][0])+Math.abs(ya-xycp[i][1]) <= xycp[i][2]) {
						temp1 = xycp[i][3]; //a충전량
					}
						for(int j = 0; j<bc; j++) {
							int sum = 0; 
							int temp2=0;
							if(Math.abs(xb-xycp [j][0])+Math.abs(yb-xycp[j][1]) <= xycp[j][2]) {	//b충전량
								temp2 = xycp[j][3];
							}
							
							if(i != j) sum = temp1+temp2;
							else sum = Math.max(temp1, temp2);//a b 중복시
							
							if(sum>full) full = sum;
						}
				}
				
				xA = ya; 
				yA = xa;
				xB = yb;
				yB = xb;
				
				result += full;
				
			}
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}

}
