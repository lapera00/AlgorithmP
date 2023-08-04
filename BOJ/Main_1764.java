import java.util.*;
import java.io.*;

public class Main_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> A = new HashSet<>();
		
		for(int i = 0 ; i<N; i++) {
			A.add(br.readLine());
		}
		
		ArrayList<String> result = new ArrayList<>();
		for(int i = 0 ; i<N; i++) {
			String s = br.readLine();
			if(A.contains(s)) result.add(s);
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(String s : result) System.out.println(s);

	}

}
