import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=0; i<N; i++) {
			boolean check[] = new boolean[26];
			boolean group = true;
			
			String str = br.readLine();
			
			for(int j = 0; j<str.length(); j++) {
				int index = str.charAt(j)-'a';
				
				if(check[index]) {
					if(j-1 >= 0 &&str.charAt(j) != str.charAt(j-1)) {
						group = false;
						break;
					}
				}else check[index] = true;
				
			}
			if(group) ++cnt;
		}
		System.out.println(cnt);
		

	}

}
