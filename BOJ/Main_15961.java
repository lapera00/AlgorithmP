import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961 {

	static int N, d, k ,c, result;
	static int [] arr, visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());//접시 수
		d = Integer.parseInt(st.nextToken());//초밥 가지수
		k = Integer.parseInt(st.nextToken());//연속먹는수
		c = Integer.parseInt(st.nextToken());//쿠본번호
		arr = new int[N];
		visited = new int[d+1];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		eat();
		System.out.println(result);

	}

	private static void eat() {
		int count = 0;
		for(int i=0; i<k; i++) {
			if(visited[arr[i]]== 0)	++count;
			++visited[arr[i]];
			
		}
		result = count;
		
		for(int i=1; i<N; i++) {
			//쿠폰꺼 안먹었으면 더함, 다음카운터 비교
			if(result <= count) {  
				if(visited[c] == 0) result = count+1;
				else result = count;
				
			}
			
			//처음먹은거지움
			--visited[arr[i-1]];
			if(visited[arr[i-1]] == 0) --count;
			
			//다음꺼 먹음
			if(visited[arr[(i-1+k) % N]] == 0) ++count;
			++visited[arr[(i-1+k) % N]];
		}
		
	}

}
