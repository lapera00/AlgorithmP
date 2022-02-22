import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int arr[][] = new int[100][100];
		
		int T = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = x; i<x+10; i++) {
				for(int j = y; j<y+10; j++) {
					if(arr[i][j] == 0) {
						arr[i][j] = 1;
						sum++;
					}
				}
			}
			
		}
		sb.append(sum);
		System.out.println(sb);
		

	}

}
