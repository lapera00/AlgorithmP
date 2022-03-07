import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15683 {
	
	static int N, M;
	static int[][] arr, arrC;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<CCTV> cctv;
	static int[] endline;
	static int result = Integer.MAX_VALUE;
	
	static class CCTV{
		int n;
		int x;
		int y;
		
		CCTV(int n, int x, int y){
			this.n = n;
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cctv = new ArrayList<CCTV>();
		
		for(int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m = 0; m<M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
				if(arr[n][m] != 0 && arr[n][m] != 6){
					cctv.add(new CCTV(arr[n][m], n, m));
				}
			}
		}
		
		int cn = cctv.size();
		endline = new int[cn];
		blindpoint(0, cn);
		
		System.out.println(result);
		
	}
	
	

	private static void blindpoint(int in, int cn) {
		if(in == cn) {
			arrC = new int[N][M];
			for(int i = 0; i<N; i++) {
				for( int j =0; j<M; j++) {
					arrC[i][j] = arr[i][j];
				}
			}
			
			for(int i = 0; i<cn; i++) {
				cctvline(cctv.get(i), endline[i]);
			}
			
			blindcount();
			return;
		}
		
		for(int i = 0; i<4; i++) {
			endline[in] = i;	
			blindpoint(in+1, cn);
		}
		
		
	}



	private static void cctvline(CCTV cctvN, int i) {
		int num = cctvN.n;
		
		if(num == 1) {
			if(i == 0) watch(cctvN, 0); // 상 
			else if(i == 1) watch(cctvN, 1); // 우 
			else if(i == 2) watch(cctvN, 2); // 하  
			else if(i == 3) watch(cctvN, 3); // 좌 
		}else if(num == 2) {
			if(i == 0 || i == 2) {
				watch(cctvN, 0);
				watch(cctvN, 2);
			}else {
				watch(cctvN, 1);
				watch(cctvN, 3);
			}
		}else if(num == 3) {
			if(i==0) {
				watch(cctvN, 0);
				watch(cctvN, 1);
			}else if(i==1) {
				watch(cctvN, 1);
				watch(cctvN, 2);
			}else if(i==2) {
				watch(cctvN, 2);
				watch(cctvN, 3);
			}else if(i == 3) {
				watch(cctvN, 3);
				watch(cctvN, 0);
			}
		}else if(num ==4) {
			if(i==0) {
				watch(cctvN, 3);
				watch(cctvN, 0);
				watch(cctvN, 1);
			}else if(i==1) {
				watch(cctvN, 0);
				watch(cctvN, 1);
				watch(cctvN, 2);
			}else if(i==2) {
				watch(cctvN, 3);
				watch(cctvN, 2);
				watch(cctvN, 1);
			}else if(i==3) {
				watch(cctvN, 2);
				watch(cctvN, 3);
				watch(cctvN, 0);
			}
		}else if(num == 5) {
			watch(cctvN, 0);
			watch(cctvN, 1);
			watch(cctvN, 2);
			watch(cctvN, 3);
		}
		
		
	}


	private static void watch(CCTV cctvN, int i) {
		LinkedList<CCTV> check = new LinkedList<>();
		check.add(cctvN);
		
		while(!check.isEmpty()) {
			int nx = check.peek().x + dx[i];
			int ny = check.poll().y + dy[i];
			
			if(nx<0 || nx>=N || ny < 0 || ny >= M || arrC[nx][ny] == 6) {
				break;
			}
			
			if(arrC[nx][ny] == 0) {
				arrC[nx][ny] = -1;
				check.add(new CCTV(cctvN.n, nx, ny));
			}else {
				check.add(new CCTV(cctvN.n, nx, ny));
			}
			
			
		}
	}

	

	private static void blindcount() {
		int cnt = 0;
		for( int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(arrC[n][m] == 0 ) {
					cnt++;
				}
			}
		}
		result = Math.min(cnt, result);
		
	}


	
	
	
}
