import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109 {
	static int R, C, result;
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		
		for(int r= 0; r<R; r++) {
			String s = br.readLine();
			arr[r] = s.toCharArray();
		}
		
		for(int r = 0; r<R; r++) {
			out = 0;
			gasline(r, 0);
		}
		
		System.out.println(result);
		
	}
	
	static int[] dx = {-1, 0, 1}; //우상, 우, 우하
	static int[] dy = {1, 1, 1};
	static int out = 0;
	
	private static void gasline(int x, int y) {
		if( y == C-1) {
			out = 1;
			++result;
			
			return;
		}
		
		for( int i =0; i<3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>=0 && nx<R && ny<C ) {
				if(arr[nx][ny] == '.') {
					arr[nx][ny] = 'x';
					gasline(nx, ny);
					if(out==1) return;
				}
			}
			
		}
		
	}

		
	
}
