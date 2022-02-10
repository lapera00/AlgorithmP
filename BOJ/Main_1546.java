import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1546 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double arr[] = new double[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		double M = arr[N-1];

		double sum =0;
		double avg = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = arr[i]/M*100;
			sum += arr[i];
		}
		avg = sum/N;
		System.out.println(avg);
	}
}
