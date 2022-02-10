import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1157 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int arr[] = new int[26];
		String str = br.readLine().toUpperCase();
		for(int i = 0; i<str.length(); i++) {
			char cha = str.charAt(i);
			arr[cha - 'A'] += 1;
		}
		int max = -1;
		int cha = -2;
		boolean out = false;
	
		for(int i =0; i<26; i++) {
			if(arr[i]>max) {
				max=arr[i];
				cha = i;
			}
		}
		Arrays.sort(arr);
		if(arr[24]==arr[25]) sb.append("?");
		else {
			sb.append((char)(cha+'A'));
		}
		System.out.println(sb);
	}

}
