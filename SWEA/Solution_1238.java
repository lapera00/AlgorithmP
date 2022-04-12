import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238 {
	
	static boolean[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			arr = new boolean[101][101];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int c= 0; c<N/2; c++) {
				int from = Integer.parseInt(st.nextToken());;
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = true;
			}
			int result = bfs(V);
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int bfs(int v) {
		int result = 0;
		
		boolean[] visited = new boolean[101];
		int size = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			size = queue.size();
			int maxNode = 0;
			
			while(--size >= 0) {
				int current = queue.poll();
				for(int i=1; i<=100; i++) {
					if(arr[current][i] && !visited[i]) {
						queue.offer(i);
						if(maxNode < i) maxNode = i;
						visited[i] = true;
					}
				}
			}
			if(maxNode>0) result = maxNode;
		}
		
		return result;
	}

}
