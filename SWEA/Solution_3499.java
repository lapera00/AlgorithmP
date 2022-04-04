import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_3499{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		LinkedList<String> list = new LinkedList<>();
		
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String arr[] = new String[N];
			
			for(int i =0; i<N; i++ ) {
				list.add(i, st.nextToken());
			}
			
//			int in = 1;
//			int getin = N/2;
//			int getin2 = N/2+1;
//			for(int i = N/2; i<N; i++ ) {
//				if(N%2 == 0) list.add(in, list.get(getin));
//				else list.add(in, list.get(getin2));
//				in += 2;
//				getin +=2;
//				getin2 +=2;
//			}
//			
			int mid = 0;
			if(N%2 == 0) mid = N/2;
			else mid = N/2+1;
			
			for(int i = mid, j =1 ; i<N+2; i+=2, j+=2 ) {
				 list.add(j, list.get(i));
				
			}
			
			
			sb.append("#").append(t+1).append(" ");
			for(int i = 0; i<N; i++ ) {
				sb.append(list.poll()).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
