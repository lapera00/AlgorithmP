import java.io.*;
import java.util.*;

public class Softeer_연탄배달의시작 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int dist = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(dist > Math.abs(arr[i] - arr[j])){
                    count = 0;
                    dist = Math.abs(arr[i] - arr[j]);
                    ++count;
                }else if(dist == Math.abs(arr[i] - arr[j])){
                    ++count;
                }
            }
        }

        System.out.print(count);

    }
}
