import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2577 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int var = a*b*c;
		String str = String.valueOf(var);
		int arr[] = new int[10];
		
		for(int i=0; i<str.length(); i++) {
			arr[ (str.charAt(i) - 48) ]++;
		}
		for(int value : arr) {
			sb.append(value).append("\n");
		}
		
		System.out.println(sb);
	}

}
