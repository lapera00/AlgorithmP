import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2908 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String a= st.nextToken();
		String b= st.nextToken();
		
		int a1 = Integer.parseInt(sb.append(a).reverse().toString());
		sb.setLength(0); 
		int b1 = Integer.parseInt(sb.append(b).reverse().toString());
		
		int max = b1;
		if(a1>=b1) max = a1;
		System.out.println(max);
		

	}

}
