import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643 {

	static int N, M, shcnt, tacnt;
	static int[][] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());  //학생수
			M = Integer.parseInt(br.readLine());  //비교횟수
			arr = new int[N+1][N+1];
			for(int m=0; m<M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int sh = Integer.parseInt(st.nextToken());
				int ta = Integer.parseInt(st.nextToken());
				arr[sh][ta] = 1;
				
			}
			
			int result = 0;
			
			for(int i=1; i<N+1; i++) {
				shcnt = 0;
				tacnt = 0;
				visit = new boolean[N+1];
				shkey(i);
				visit = new boolean[N+1];
				takey(i);
				if(shcnt + tacnt == N-1) {
					++result;
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");			
		}
	
		System.out.println(sb);
	}
	
	private static void takey(int cur) {
		visit[cur] = true;
		for(int i=1; i<N+1; i++) {
			if(visit[i] == false && arr[cur][i] == 1) {// 나보다 큰사람
				++shcnt;
				takey(i);
			}
		}
		
	}

	private static void shkey(int cur) {
		visit[cur] = true;
		for(int i=1; i<N+1; i++) {
			if(visit[i] == false && arr[i][cur] == 1) {// 나보다 작은사람 
				++shcnt;
				shkey(i);
			}
		}
		
	}
	
}
