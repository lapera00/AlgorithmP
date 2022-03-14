import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686{
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N, M;
	static int [][] map;
	static ArrayList<Node> house;
	static ArrayList<Node> chicken;
	static boolean [] visited;
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//1-집, 2-치킨
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //최대 치킨집

		map = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) house.add(new Node(i, j));
				else if(map[i][j] == 2) chicken.add(new Node(i, j));
			}
		}
		
		result = Integer.MAX_VALUE;
		visited = new boolean[chicken.size()];
		dfs(0, 0);
		System.out.println(result);
		
		
	}

	private static void dfs(int cnt, int index) {
		if(cnt == M) {
			int length = 0;
			for(int i = 0; i< house.size(); i++) {
				int sum = Integer.MAX_VALUE;
				for(int j = 0; j< chicken.size(); j++) {
					if(visited[j] == true) {
						int way = Math.abs(chicken.get(j).x - house.get(i).x) + Math.abs(chicken.get(j).y - house.get(i).y);
						sum = Math.min(sum, way);
					}
				}
				length += sum;
			}
			result = Math.min(result, length);
		}
		
		for(int i = index; i< chicken.size(); i++) {
			if(visited[i] == false) {
				visited[i] = true;
				dfs(cnt + 1, i+1);
				visited[i] = false;
			}
		}
		
	}

}
