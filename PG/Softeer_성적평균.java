import java.io.*;
import java.util.*;

public class Softeer_성적평균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            double sum = 0;
            double count = 0;
            for(int j= a-1; j<=b-1; j++){
                sum += arr[j];
                ++count;
            }

            double result = Math.round(sum / count *100)/100.0;
            String rr = String.format("%.2f",result);
            sb.append(rr).append("\n");
            
        }

        System.out.println(sb);
        
    }
}
