import java.io.*;
import java.util.*;

public class Softeer_연탄의크기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        Arrays.sort(arr);
        for(int i = 2; i <= arr[n-1]; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(arr[j] % i == 0) ++count;
            }
            result = Math.max(result, count);
        }

        System.out.println(result);
        
        
    }
}
