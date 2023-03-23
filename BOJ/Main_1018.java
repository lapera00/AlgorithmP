import java.io.*;
import java.util.*;

public class Main_1018 {

	static boolean arr[][];
	static int result = 64;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0 ; j<M; j++) {
				if(s.charAt(j) == 'W') {
					arr[i][j] = true;
				}
				else {
					arr[i][j] = false;
				}
			}
		}
		
		int N2 = N-7;
		int M2 = M-7;
		
		for(int i=0; i<N2; i++) {
			for(int j=0; j<M2; j++) {
				find(i, j);
			}
		}
		
		System.out.println(result);

	}
	
	static void find(int n, int m) {
		int endN = n + 8;
		int endM = m + 8;
		int cnt = 0;
		
		boolean now = arr[n][m];
		
		for(int i=n; i<endN; i++) {
			for(int j=m; j<endM; j++) {
				if(arr[i][j] != now) {
					++cnt;
				}
				now = !now;
			}
			now = !now;
		}
		cnt = Math.min(cnt, 64-cnt);
		result = Math.min(result, cnt);
	}

}
