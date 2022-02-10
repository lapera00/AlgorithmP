import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int arr[] = new int[43];
		for(int i=0; i<10; i++) {
			arr[Integer.parseInt(br.readLine())%42] = 1;
		}
		
		int cnt = 0;
		for(int i=0; i<43; i++) {
			if(arr[i] ==1) cnt++;
		}
		
		System.out.println(cnt);
		
		
	}

}
