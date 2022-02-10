import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10430{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int q1 = (A+B)%C;
        int q2 = ((A%C) + (B%C))%C; 
        int q3 = (A*B)%C;
        int q4 = ((A%C) * (B%C))%C;
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
        System.out.println(q4);

    }
}