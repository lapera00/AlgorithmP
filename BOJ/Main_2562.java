import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2562 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int arr[] = new int[9];
		int max =0;
		int cnt =0;
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max) {
				max = arr[i];
				cnt = i;
			}
		}
		sb.append(max).append("\n").append(cnt+1);
		
		System.out.println(sb);
	}

}

