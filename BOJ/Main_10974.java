import java.io.*;
import java.util.*;

public class Main_10974 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int arrp[] = new int[N];
        boolean[] visit = new boolean[N];
        
        for(int i = 0; i<N; i++) {
        	arr[i] = i+1;
        }
        
        sol(arr, arrp, visit, 0, N, N);
        System.out.println(sb);
	}
	
	static void sol(int[] arr, int[] arrp, boolean[] visit, int dep, int n, int r) {
		if(dep == r) {
			for(int i=0; i<r; i++) {
				sb.append(arrp[i]).append(" ");
			}
			sb.append("\n");
		}
		
		for(int i = 0; i<n; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				arrp[dep] = arr[i];
				sol(arr, arrp, visit, dep+1, n, r);
				visit[i] = false;
			}
		}
	}
	
	
	
}
