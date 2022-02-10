import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2588{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        
        int c1 = b%10;
		int c2 = b%100 - c1;
		int c3 = b%1000 - c1 -c2;
        
        StringBuilder sb = new StringBuilder();
        sb.append(a*c1).append("\n").append(a*c2/10).append("\n").append(a*c3/100).append("\n").append(a*b);
        System.out.println(sb);

    }
}