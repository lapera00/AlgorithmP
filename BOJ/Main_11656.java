import java.util.*;
import java.io.*;

public class Main_11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		String arr[] = new String[s.length()];
		
		for(int i = 0; i < s.length(); i++) {
			arr[i] = s.substring(i, s.length());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < s.length(); i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);

	}

}
