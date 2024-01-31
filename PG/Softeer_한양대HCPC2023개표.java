import java.io.*;
import java.util.*;

public class Softeer_한양대HCPC2023개표 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int arr[] = new int[T];
        
        //StringBuilder sb = new StringBuilder();
        String str1 = "++++ ";
        String str2 = "|";
        String result = "";
        for(int i = 0; i < T; i++){
            arr[i] = Integer.parseInt(br.readLine());
            int plus = arr[i] / 5;
            int line = arr[i] % 5;
            for(int j =0; j<plus; j++) {
                result += str1; 
            }
            for(int j =0; j<line; j++) { 
                result += str2;
            }
            result += "\n";
        }
        result = result.substring(0, result.length() - 1);
        if(result.charAt(result.length()-1) == ' ') {
            result = result.substring(0, result.length() - 1);
        }

        System.out.print(result);
        
    }
}
