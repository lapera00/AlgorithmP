import java.io.*;
import java.util.*;

public class Main_5014 {

	static int visited[];
	static String result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int F = Integer.parseInt(st.nextToken()); //총
		int S = Integer.parseInt(st.nextToken()); //현재
		int G = Integer.parseInt(st.nextToken()); //도착점
		int U = Integer.parseInt(st.nextToken()); //위로
		int D = Integer.parseInt(st.nextToken()); //아래로
		
		visited = new int[F + 1];
		sol(F, S, G, U, D);
		System.out.println(result);
		
	}

	static void sol(int f, int start, int goal, int u, int d) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		
		visited[start] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == goal) {
				result = Integer.toString(visited[now] - 1);
			}
			
			if(now + u <= f && visited[now + u] == 0) {
				visited[now + u] = visited[now] + 1;
				q.add(now + u);
			}
			
			if(now - d > 0 && visited[now - d] == 0) {
				visited[now - d] = visited[now] + 1;
				q.add(now - d);
			}
			
		}
		
		if(visited[goal] == 0)
			result = "use the stairs";
	}
}
