import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11720 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String num = br.readLine();
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += num.charAt(i) - '0';
		}
		
		System.out.println(sum);

	}

}
