import java.io.*;
import java.util.*;

public class Main_20413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[4];
        for(int i =0; i<4; i++) {
        	arr[i] = Integer.parseInt(st.nextToken()); //b s g p d
        }
        
        String s = br.readLine();
        char[] s2 = s.toCharArray();
        
        int result = 0;
        int temp = 0;
        
        for(int i = 0; i < s2.length; i++) {
        	if(s2[i] == 'B') {
        		temp = arr[0] - 1 - temp;
        		result += temp;
        	}
        	if(s2[i] == 'S') {
        		temp = arr[1] - 1 - temp;
        		result += temp;
        	}
        	if(s2[i] == 'G') {
        		temp = arr[2] - 1 - temp;
        		result += temp;
        	}
        	if(s2[i] == 'P') {
        		temp = arr[3] - 1 - temp;
        		result += temp;
        	}
        	if(s2[i] == 'D') {
        		temp = arr[3];
        		result += temp;
        	}
        }
        
        System.out.println(result);

		
	}

}
