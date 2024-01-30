import java.io.*;
import java.util.*;

public class Softeer_위험한효도 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int len = d;
        int len2 = d;
        int time = 0;

        while(len > 0){
            len -= a;
            time += a;
            if(len > 0) time += b;
            else time += len;
        }

        while(len2 > 0){
            len2 -= b;
            time += b;
            if(len2 > 0) time += a;
            else time += len2;
        }

        System.out.println(time);

    }
}
