import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {
	
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, n);
		
		zzz(size, r, c);
		System.out.println(cnt);

	}

	private static void zzz(int size, int r, int c) {
		if(size == 1) return;
		
		if( r < size/2 && c < size/2) {//좌상
			zzz(size/2, r, c);
		}
		else if( r < size/2 && c>= size/2) {//우상
			cnt += size* size /4;
			zzz(size/2, r, c-size/2);
		}
		else if( r >= size/2 && c < size/2) {//좌하
			cnt += (size * size /4) * 2;
			zzz(size/2, r-size/2, c);
		}
		else if( r >= size/2 && c >= size/2) {//우하
			cnt += (size * size/4) * 3;
			zzz(size/2, r-size/2, c-size/2);
		}
		
	}
	
	

}
