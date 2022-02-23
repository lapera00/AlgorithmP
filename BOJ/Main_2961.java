import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961 {
	
	static int[][] food;
	static boolean[] use;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		food = new int[T][2];
		use = new boolean[T];
		
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			food[t][0] = Integer.parseInt(st.nextToken());
			food[t][1] = Integer.parseInt(st.nextToken());
		}
		
		result = Integer.MAX_VALUE;
		make(0);
		System.out.println(result);

	}
	
	public static void make(int cur) {
		if(cur == food.length) {
			int first = 1;
			int second = 0;
			int cnt = 0;
			for(int i=0; i<use.length; i++) {
				if(use[i]) {
					cnt++;
					first *= food[i][0];
					second += food[i][1];
				}
			}
			if(cnt ==0) return;
			int min = Math.abs(first-second);
			if(result> min) result =min; 
			return;
			
		}
		use[cur] = true;
		make(cur+1);
		use[cur] = false;
		make(cur +1);
		
	}

}

