import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1712 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int count = 0;


		if(B >= C) {
			count = -1;
		}
		else count = A/(C-B)+1 ;
		System.out.println(count);
		
//시간초과
//		if(B >= C) {
//			System.out.println(-1);
//			return;
//		}
//		while(true) {
//			count++;
//			if(A+(B*count) < C*count) {
//				System.out.println(count);
//				break;
//			}
//		}

	}

}
