import java.util.*;
import java.io.*;


public class Main_18429 {
	
	static int N, K, result;
	static int[] kit, day;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		kit = new int[N];
		day = new int[N];
		visit = new boolean[N];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		result = 0;
		sol(0);
		
		System.out.println(result);
		

	}
	static void sol(int dep) {
		if(dep == N) {
			int check = 500;
			int check2 = 0;
			for(int i = 0 ; i < N; i++) {
				check += kit[day[i]];
				check -= K;
				if(check < 500) {
					check2 = 0;
					break;
				}
				check2 = 1;
			}
			if(check2 == 1) ++result;
			
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				day[dep] = i;
				sol(dep+1);
				visit[i] = false;
			}
		}
		
	}

}
