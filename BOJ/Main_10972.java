import java.io.*;
import java.util.*;

public class Main_10972 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(np(arr) == true) {
        	for(int i=0; i<N; i++) {
        		System.out.print(arr[i] + " ");
        	}
        }else {
        	System.out.println("-1");
        }
        
	}
	
	static boolean np(int arr[]) {
		int i = arr.length - 1;
		
		while(i > 0 && arr[i-1] >= arr[i]) {
			--i;
		}
		
		if(i<=0) return false; 
		
		int j = arr.length - 1;
		
		while(arr[i-1] >= arr[j]) {
			--j;
		}
		
		int temp = arr[j];
		arr[j] = arr[i-1];
		arr[i-1] = temp;
		
		j = arr.length-1;
		
		while(i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			++i;
			--j;
		}
				
		return true;
	}
	
}
