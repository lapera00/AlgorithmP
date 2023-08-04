import java.util.*;
import java.io.*;

public class Main_7785 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String now = st.nextToken();
			
			if(now.equals("enter")) set.add(name);
			else set.remove(name);
		}

		ArrayList<String> result = new ArrayList<>(set);
		Collections.sort(result, Collections.reverseOrder());
		
		for(int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		
		System.out.println(sb);
		

	}

}
