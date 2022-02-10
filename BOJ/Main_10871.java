import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10871 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		
		for(int i = 0; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i< N; i++) {
			if(arr[i] < X) sb.append(arr[i]).append(" "); 
		}
		
		System.out.println(sb);
	}

}
