import java.util.*;
import java.io.*;

public class Main_15651 {
		
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());  //몇까지
		M = Integer.parseInt(st.nextToken());  //수열 크기
		
		arr = new int[M];

		sol( 0);
		
		System.out.println(sb);
		
		
	}
	
	static void sol( int dep) {
		if(dep == M) {
			for(int i = 0; i< M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++){
			arr[dep] = i;
			sol(dep+1);
			
		}
		
	}

}
