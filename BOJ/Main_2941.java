import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		char ch[] = str.toCharArray();
		int count = 0;
		for(int i = 0; i<ch.length; i++) {
			if(i+2<ch.length && ch[i]=='d' && ch[i+1]=='z' && ch[i+2]=='=') {
				++count;
				i+=2;
			}
			else if(i+1 < ch.length && ch[i]=='c' &&ch[i+1]=='=') {
				count++;
				++i;
			}
			else if(i+1 < ch.length && ch[i]=='c' &&ch[i+1]=='-') {
				count++;
				++i;
			}
			else if(i+1 < ch.length && ch[i]=='d' &&ch[i+1]=='-') {
				count++;
				++i;
			}
			else if(i+1 < ch.length && ch[i]=='l' &&ch[i+1]=='j') {
				count++;
				++i;
			}
			else if(i+1 < ch.length && ch[i]=='n' &&ch[i+1]=='j') {
				count++;
				++i;
			}
			else if(i+1 < ch.length && ch[i]=='s' &&ch[i+1]=='=') {
				count++;
				++i;
			}
			else if(i+1 < ch.length && ch[i]=='z' &&ch[i+1]=='=') {
				count++;
				++i;
			}
			else count++;
		}
		System.out.println(count);
	
	}
}
