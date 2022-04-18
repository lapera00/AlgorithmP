import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124 {
	
	static int V, E;
	static long result;
	static int[] parent;
	static Edge[] edge;
	
	static class Edge implements Comparable<Edge>{
		int start, end, value;

		public Edge(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			result = 0;
			parent = new int[V+1];
			edge = new Edge[E];
			
			for(int i = 0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				edge[i] = new Edge(s, e, v);
			}
			makeSet();
			Arrays.sort(edge);
			int cnt = 0;
			
			for(int i = 0; i< E; i++) {
				Edge e = edge[i];
				if(findSet(e.start) == findSet(e.end)) continue;
				union(e.start, e.end);
				cnt++;
				result += e.value;
				if (cnt == V-1) break;
			}
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}


	static void makeSet() {
		for(int i = 1; i<= V; i++) {
			parent[i] = i;
		}
	}
	

	static int findSet(int a) {
		if(a == parent[a]) return a;
		return parent[a] = findSet(parent[a]);
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px < py)
			parent[py] = px;
		else
			parent[px] = py;
		
	}
	

}
