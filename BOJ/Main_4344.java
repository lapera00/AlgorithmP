import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4344 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(br.readLine());
		
		for(int t=0; t<C; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			double arr[] = new double[N];
			
			int sum = 0;
			double avg = 0;
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			avg = sum/N;
			double cnt = 0;
			for(int i=0; i<N; i++) {
				if(arr[i] > avg) {
					cnt++;
				}
			}
			
			double per = cnt/N*100;
			sb.append(String.format("%.3f", per)).append("%\n");
			
		}
		System.out.println(sb);
		
	}

}
