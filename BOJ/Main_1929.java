import java.util.*;
import java.io.*;

public class Main_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb= new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N+1];
		
		// 0 소수, 1 소수x
		for(int i = 2; i <= N; i++) {
			if(arr[i] == 1) continue;
			
			if(i >= M) sb.append(i).append('\n');
			
			for(int j = i + i; j <= N; j += i) {	
				arr[j] = 1;
			}
			
		}
		
		System.out.println(sb);
		
		
	}

}
