import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7465 {
	
	static int[] parents;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int result = 0;
			parents = new int[N + 1];

			for(int i = 1; i <= N; i++) {
				 makeSet(i);
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for(int i = 1; i <= N; i++) {
				if(findSet(i) == i) result++;
			}
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");	
		}
		
		System.out.println(sb);
		
	}

	// 단위 집합 생성
	public static void makeSet(int i) {
		parents[i] = i;
	}
	
	//a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	//a,b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
