import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247 {
	static int N, result;
	static int[] comp, home, customerNum;
	static int[][] customer;
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			comp = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			customer = new int[N][2];
			for(int n=0; n<N; n++) {
				customer[n][0] = Integer.parseInt(st.nextToken());
				customer[n][1] = Integer.parseInt(st.nextToken());
			}
			
			customerNum = new int[N];
			visit = new boolean[N];
			result = Integer.MAX_VALUE;
			nevi(0);
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	
	private static void nevi(int cnt) {
		if(cnt == N) {
			int sum = 0;
			sum += Math.abs(comp[0] - customer[customerNum[0]][0]) + Math.abs(comp[1] - customer[customerNum[0]][1]);
			for( int n =0; n<N-1; n++) {
				int num = customerNum[n];
				int numN = customerNum[n+1];
				sum += Math.abs(customer[num][0] - customer[numN][0]) + Math.abs(customer[num][1] - customer[numN][1]);
			}
			sum += Math.abs(home[0] - customer[customerNum[N - 1]][0]) + Math.abs(home[1] - customer[customerNum[N - 1]][1]);
			result = Math.min(sum, result);
			return;
		}
		
		for(int n=0; n<N; n++) {
			if(!visit[n]) {
				customerNum[cnt] = n;
				visit[n] = true;
				nevi(cnt +1);
				visit[n] = false;
			}
		}
		
	}

}
