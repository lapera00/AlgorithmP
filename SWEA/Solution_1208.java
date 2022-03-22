import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int arr[] = new int[100];
		
		for(int t=0; t<10; t++) {
			int dump = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			for(int i=0; i<100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			for(int i = 0; i<dump; i++) {
				if(arr[0] < arr[99]) {
					arr[0]++;
					arr[99]--;
					Arrays.sort(arr);
				}
			}
			
			int result = arr[99] - arr[0];
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
