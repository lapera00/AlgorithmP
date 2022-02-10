import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2564 {
	static int pos;
	static int pik;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int store = Integer.parseInt(br.readLine());
		
		int line = (N+M) * 2;
		int map[] = new int[line];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int s = 0; s<store+1; s++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 pos = Integer.parseInt(st.nextToken());
			 pik = Integer.parseInt(st.nextToken());
			  //1ºÏ 2³² 3¼­ 4µ¿
			 int in = 1;
			 if(s == store) in = 2;
			 
			 if(pos == 1) map[pik] = in;
			 else if(pos == 2) map[N+M+(N-pik)] = in;
			 else if(pos == 3) map[N+M+N+(M-pik)] = in;
			 else if(pos == 4) map[N+pik] = in;
			 
		}
		
		int sum=0;
		for(int i=0; i<line; i++) {
			if(map[i] == 2) {
				for(int x=0; x<line; x++) {
					if(map[x]==1) {
						sum += Math.min(Math.abs(i-x),	(line)-Math.abs(i-x));
					}
				}
			}	
		}
		
		System.out.println(sum);
		

	}

}
