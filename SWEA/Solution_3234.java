import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234 {
	static boolean use[];
	static int N, result;
	static int [] arr, weight;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t= 0; t< T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			weight = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int n=0; n<N; n++) {	
				arr[n] = Integer.parseInt(st.nextToken());
			}
			
			use = new boolean[N];
			result = 0;
			perm(0);
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);

	}

	private static void perm(int cnt) {
		if(cnt == N ) {
//			for (int a  : weight) {
//				System.out.print(a + " ");
//			}System.out.println();
			
			weight(0,0,0);
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(use[i]) continue;
			use[i] = true;
			weight[cnt] = arr[i];
			perm(cnt+1);
			use[i] = false;
		}
	}

	private static void weight(int in, int left, int right) {
		if(left<right) return;
		if(in == N) {
			++result;
			return;
		}
		weight(in+1, left+weight[in], right);
		if(left>=right+weight[in]) {
			weight(in+1, left, right+weight[in]);
		}
	}


}
