import java.io.*;
import java.util.*;

public class Softeer_한양대HCPC2023TrendelFindelMundo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];

        int result = -1;
        int temp = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if(arr[i][1] < temp) {
                temp = arr[i][1];
                result = i;
            }
        }

        System.out.println(arr[result][0]+ " " + arr[result][1]);
        
    }
}
