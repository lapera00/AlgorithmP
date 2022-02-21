

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1158 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i<=N; i++) {
			list.add(i);
		}
		sb.append("<");
		while(!list.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				list.add(list.get(0));
				list.remove(0);
			}
			sb.append(list.get(0)).append(", ");
			list.remove(0);
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}

}
