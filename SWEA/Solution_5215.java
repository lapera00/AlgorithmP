import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5215 {
	
	static int N,L, max;
	static int[][] input;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			input = new int[N][2];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;

			comb(0,0,0);
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
		}	
		System.out.println(sb);
	}
	
	
	public static void comb(int cnt, int score, int cal) {
		
		if(cal>L) return;
		
		if(cnt == N) {
			max = Math.max(max, score);
			return;
		}
		
		comb(cnt+1, score, cal);
		comb(cnt+1, score+input[cnt][0], cal+input[cnt][1]);
	}



}
