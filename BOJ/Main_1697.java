import java.util.*;
import java.io.*;

public class Main_1697 {
	
	static int N, K;
	static int visited[] = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int result = sol(N);
		System.out.println(result);
		
	}
	
	static int sol(int node) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(node);
		
		int index = node;
		int n = 0;
		visited[index] = 1;
		
		while (que.isEmpty() == false)
		{
			n = que.poll();
			if (n == K) return visited[n]-1;
			
			if (n-1 >= 0 && visited[n-1] == 0){
				visited[n-1] = visited[n]+1;
				que.offer(n-1);
			}
			if (n+1 <= 100000 && visited[n+1] == 0) {
				visited[n+1] = visited[n]+1;
				que.offer(n+1);
			}
			if (2*n <= 100000 && visited[2*n] == 0) {
				visited[2*n] = visited[n]+1;
				que.offer(2*n);
			}
		}
		return -1;
	}

}
