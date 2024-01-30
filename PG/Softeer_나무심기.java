import java.io.*;
import java.util.*;

public class Softeer_나무심기 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(result < arr[i] * arr[j]){
                    result = arr[i] * arr[j];
                }
            }
        }

        System.out.println(result);
        
    }
}
