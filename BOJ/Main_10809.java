import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10809 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str= br.readLine();
		int alpha[] = new int[26];
		
		for(int i=0; i<26; i++) {
			alpha[i] = -1; 
		}
		for(int i=0; i<str.length(); i++) {
			char cha = str.charAt(i);
			if(alpha[cha-'a'] == -1) alpha[cha-'a'] = i; 
		}
		for(int val : alpha) {
			sb.append(val).append(" ");
		}
		System.out.println(sb);
	}

}
