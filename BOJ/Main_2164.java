import java.io.*;
import java.util.*;

public class Main_2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N * 2];
		for(int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		int first_index = 1;
		int last_index = N;
		
		while(N > 1) {
			--N;
			++first_index;
			arr[last_index + 1] = arr[first_index];
			++last_index;
			++first_index;
		}
		
		System.out.println(arr[first_index]);

	}

}
