import java.util.*;
import java.io.*;

public class Main_2644 {

	static List<Integer>[] arr;
	static boolean[] checked;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		arr = new ArrayList[n+1];
		checked = new boolean[n+1];
		for(int i = 1; i < n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(br.readLine());
		
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[p].add(c);
			arr[c].add(p);
		}
		
		sol(x, y, 0);
		System.out.println(result);
		
	}
	
	static void sol(int start, int end, int cnt) {
		if(start == end) {
			result = cnt;
			return; 
		}
		
		checked[start] = true;
		for(int i = 0; i < arr[start].size(); i++) { 
			int next = arr[start].get(i);
			if(checked[next] == false) {
				sol(next, end, cnt+1);
			}
		}
	}

}
