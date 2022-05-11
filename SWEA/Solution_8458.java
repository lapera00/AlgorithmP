import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8458 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int [] arr= new int[N];
			int max = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i] = Math.abs(Integer.parseInt(st.nextToken())) +  Math.abs(Integer.parseInt(st.nextToken()));
				max = Math.max(max, arr[i]);
			}

			int count = 0;
			for(int i=1; i<N; i++) {//홀홀, 짝짝 
				if(arr[i] % 2 != arr[i-1] % 2) count = -1;
			}
			
			int dissum = 0;
			if(count == 0) {
				while(true) {//더한 거리> , //차이 짝수
					if(dissum >= max && (dissum - max)%2 == 0) break;
					dissum = dissum + ++count;
				}
			}
			/*
			 1 + 2 + 3 + 4 + 5 ...
			 1 = 1
			 2 = 1, 3
			 3 = 0, 2, 4, 6
			 4 = 0, 2, 4, 6, 8, 10..
			 5 = 1, 3, 5, 7, 9, 11, 13 15 
			 0, 0 = 0
			 6, 6 = 3
			 5, 3 = 5
			 */
			sb.append("#").append(t+1).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

}
