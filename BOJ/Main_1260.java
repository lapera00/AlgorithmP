import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {
	
	static int N, M, V;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	//정점수
		M = Integer.parseInt(st.nextToken());	//간선
		V = Integer.parseInt(st.nextToken());	//시작 정점

		int arr[][] = new int[N+1][N+1];
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());;
			int to = Integer.parseInt(st.nextToken());
			arr[to][from] = arr[from][to] = 1;
		}
		visited = new boolean[N+1];
		dfs(arr, visited, V);
		System.out.println();
		bfs(arr, V);

	}
	
	
	
	public static void dfs(int[][] arr, boolean[] visited, int current) {
		
		visited[current] = true;
		System.out.print(current+ " ");
		
		//current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
		for (int j = 1; j < N+1; j++) {
			if(!visited[j] && arr[current][j] !=0) {
				dfs(arr, visited, j);
			}
			
		}
		
	}
	
	
	public static void bfs(int[][] arr, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			
			//current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for (int j = 1; j < N+1; j++) {
				if(!visited[j] && arr[current][j] !=0) {
					queue.offer(j);
					visited[j] = true;
				}
				
			}
		}
		
	}
	
}
