import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808 {
	static int win,res;
	static int [] ins ;
	static int [] gus ;
	static boolean[] gu;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			win =0;
			res=0;
			ins = new int[9];
			gus = new int[9];
			gu = new boolean[18];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				ins[i] = Integer.parseInt(st.nextToken());
				gu[ins[i]-1] = true;
			}
			
			
			int cnt=0;
			for (int i = 0; i < 18; i++) {
				if(!gu[i]) {
					gus[cnt++]= i+1;

				}
			}
			
			permutation(new int [9],new boolean[9],0);
			
			sb.append("#").append(tc).append(" ").append(res-win).append(" ").append(win).append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	
	private static void permutation(int[] sel, boolean[] v, int k) {
		if(k==gus.length) {
			res++;
			int scorein=0;
			int scoregu=0;
			for (int i = 0; i < 9; i++) {
				int a = ins[i];
				int b = sel[i];
				if(a>b) scorein += a+b;
				if(a<b) scoregu += a+b;
			}
			if(scorein<scoregu) win++;
			return;	
		}
		
		
		for (int i = 0; i < 9; i++) {
			if(!v[i]) {
				v[i]=true;
				sel[k]=gus[i];
				permutation(sel, v, k+1);
				v[i]=false;	
			}
		}
		
	}


	
}




