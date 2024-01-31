import java.io.*;
import java.util.*;

public class Softeer_한양대HCPC2023XmarkstheSpot {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            
            int index = str1.indexOf("X");
            if(index == -1) index = str1.indexOf("x");    

            char c = str2.charAt(index);
            c = Character.toUpperCase(c);
                
            sb.append(c);
            
        }
     
        System.out.println(sb);

    }
}
