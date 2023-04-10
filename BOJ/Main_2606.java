import java.io.*;
import java.util.*;

public class Main_2606 {

	static int arr[][];
	static boolean visit[];
	static int n, m;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i =0; i< m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		sol(1);
		
		System.out.println(count);
		
	}
	
	static void sol(int a) {
		visit[a] = true;
		for(int i = 0; i<=n; i++) {
			if(arr[a][i] == 1 && visit[i] == false) {
				++count;
				sol(i);
			}
		}
		
	}

}
