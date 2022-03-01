import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1992 {
	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			for(int j = 0; j<N; j++) {
				arr[i][j]= s.charAt(j) - '0';
			}
		}
		
		zeroone(0, 0, N);
		System.out.println(sb);

	}

	private static void zeroone(int x, int y, int n) {
		if(zip(x, y, n)) {
			sb.append(arr[x][y]);
			return;
		}
		
		sb.append("(");
		int n2 = n/2;
		zeroone(x, y, n2);//좌 상
		zeroone(x, y+n2, n2);//우 상
		zeroone(x+n2, y, n2);//좌 하
		zeroone(x+n2, y+n2, n2);//우 하
		sb.append(")");
		
	}

	private static boolean zip(int x, int y, int n) {
		int poi = arr[x][y];
		
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(poi != arr[i][j] ) {
					return false;
				}
			}
		}
		return true;
	}


}
