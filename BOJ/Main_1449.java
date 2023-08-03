import java.util.*;
import java.io.*;

public class Main_1449 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken()); //테이프의 길이
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		
		Arrays.sort(arr);
		
		int tapeL = (int)(arr[0] - 0.5 + L); //붙였을떄 테이프 길이
		++result;
		
		for(int i = 1; i<arr.length; i++) {
			if(tapeL < (int)(arr[i] + 0.5)) { //다음 지점보다 커진다면
				++result;
				tapeL = (int)(arr[i] - 0.5 + L); //
			}
		}
		
		System.out.print(result);
		

	}

}
