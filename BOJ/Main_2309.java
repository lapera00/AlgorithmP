import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int arr[] = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum +=arr[i];
		}
		
		out : for(int i=0; i<9; i++) {
			for(int j=i+1; j<9 ; j++) {
				if(sum - (arr[i] + arr[j]) == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break out;
				}
			}
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<9; i++) {
			if(arr[i] != 0)	sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
