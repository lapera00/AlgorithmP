import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12869 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] map = new int [3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int a=0;
		a = attack(map[0], map[1], map[2]);

		System.out.println(a);
	}
	
	static int dp[][][] = new int[61][61][61];
	
	private static int attack(int a, int b, int c) {
		if(a==0&&b==0&&c==0) return 0;
		if(dp[a][b][c] != 0) return dp[a][b][c];
		dp[a][b][c] = Integer.MAX_VALUE;
		dp[a][b][c] = Math.min(dp[a][b][c], attack(Math.max(0, a-9), Math.max(0, b-3), Math.max(0, c-1)) + 1);
		dp[a][b][c] = Math.min(dp[a][b][c], attack(Math.max(0, a-9), Math.max(0, b-1), Math.max(0, c-3)) + 1);
		dp[a][b][c] = Math.min(dp[a][b][c], attack(Math.max(0, a-3), Math.max(0, b-9), Math.max(0, c-1)) + 1);
		dp[a][b][c] = Math.min(dp[a][b][c], attack(Math.max(0, a-1), Math.max(0, b-9), Math.max(0, c-3)) + 1);
		dp[a][b][c] = Math.min(dp[a][b][c], attack(Math.max(0, a-3), Math.max(0, b-1), Math.max(0, c-9)) + 1);
		dp[a][b][c] = Math.min(dp[a][b][c], attack(Math.max(0, a-1), Math.max(0, b-3), Math.max(0, c-9)) + 1);
		return dp[a][b][c];
	}
	

}
