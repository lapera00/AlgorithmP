import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String t = "";
		String str = "";
		int arr[] = new int[8];
		
		Queue<Integer >queue = new LinkedList<Integer>();
		
		while((t=br.readLine()) != null) {
			int T = Integer.parseInt(t);
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int temp =0;
			
			out : while(true) {
				for(int i=1; i<=5; i++) {
					temp = queue.poll()-i;

					if(temp <= 0) {
						queue.offer(0);
						break out;
					}
					queue.offer(temp);
				}
			}
			
			sb.append("#").append(t).append(" ");
			for(int i = 0; i<8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

		
	}

}
