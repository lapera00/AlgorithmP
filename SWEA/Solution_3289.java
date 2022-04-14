import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289 {
	
	static int N;
	static int[] parents;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			sb.append("#").append(t+1).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			
			for(int i=1; i<N; i++) makeSet(i);
			
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int o = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(o == 0) {
					union(a, b);
				} else if(o == 1) { 
					if(findSet(a) == findSet(b))
						sb.append("1");
					else sb.append("0");
				}
				
			}
			
			sb.append("\n");	
		}
		System.out.println(sb);
	}

	
	// 단위 집합 생성
	public static void makeSet(int i) {
//		parents = new int[N];
		//자신으 ㅣ부모노드를 자신으 ㅣ값으로 세팅
//		for(int i = 0; i< N; i++) {
		parents[i] = i;
//		}

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
