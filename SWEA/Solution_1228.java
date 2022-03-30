import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		String str = "";
		while( (str=br.readLine())!=null ) {
			++cnt;
			int N = Integer.parseInt(str); 
			
			LinkedList<Integer> list = new LinkedList<>();
			
			str= br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			for(int i=0; i<N; i++) {	
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine()); 
			
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			for(int m=0; m<M; m++) {
				if(st.nextToken().equals("I")) {
					int index = Integer.parseInt(st.nextToken());
					int last = Integer.parseInt(st.nextToken());
					for(int in = 0; in<last; in++) {
						list.add(index, Integer.parseInt(st.nextToken()));
						++index;
					}
				}
			}
			
			sb.append("#").append(cnt).append(" ");
			for(int i = 0; i<10; i++) {
				sb.append(list.poll()).append(" ");
			}
			sb.append("\n");

		}
		
		System.out.println(sb);
		
		
		
	}
}
