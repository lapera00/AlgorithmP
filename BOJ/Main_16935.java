import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_16935{
	static int N; 
	static int M; 
	static int R; 
	static int[][] map; 
	static int[][] mapT; 
	static int num; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M]; 
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0;i<R;i++) {
			num = Integer.parseInt(st.nextToken());
			
			switch(num) {
			case 1 : 
				case1();
				break;
				
			case 2 : 
				case2();
				break;
				
			case 3 :
				case3();
				break;
				
			case 4 : 
				case4();
				break;
				
			case 5 : 
				case5();
				break;
				
			case 6 : 
				case6();
				break;
			}
		}
		

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	

	public static void case1() {
		int[][] mapT = new int[N][M]; 
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				mapT[N-i-1][j] = map[i][j];
			}
		}
		map = mapT;
	}
	
	public static void case2() {
		mapT = new int[N][M]; 
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				mapT[i][M-j-1] = map[i][j];
			}
		}
		map = mapT;
	}
	
	public static void case3() {
		mapT = new int[M][N]; 
		int C = N-1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				mapT[j][C] = map[i][j];
			}
			C--;
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		map = mapT;
	}
	
	public static void case4() {
		mapT = new int[M][N]; 
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				mapT[M-j-1][i] = map[i][j];
			}
		}

		int temp = N;
		N = M;
		M = temp;
		
		map = mapT;
	}
	
	public static void case5() {
		mapT = new int[N][M]; 
		
		int N_mid = N/2; 
		int M_mid = M/2; 

		for(int i=0;i<N_mid;i++) {
			for(int j=0;j<M_mid;j++) {
				mapT[i][M_mid+j] = map[i][j];
			}
		}

		for(int i=0;i<N_mid;i++) {
			for(int j=M_mid;j<M;j++) {
				mapT[N_mid+i][j] = map[i][j];
			}
		}
		
		for(int i=N_mid;i<N;i++) {
			int C = 0;
			for(int j=M_mid;j<M;j++,C++) {
				mapT[i][C] = map[i][j];
			}
		}
		
		int Row = 0;
		for(int i=N_mid;i<N;i++, Row++) {
			for(int j=0;j<M_mid;j++) {
				mapT[Row][j] = map[i][j];
			}
		}
		map = mapT;
	}
	
	public static void case6() {
		mapT = new int[N][M]; 
		
		int N_mid = N/2; 
		int M_mid = M/2; 

		for(int i=0;i<N_mid;i++) {
			for(int j=0;j<M_mid;j++) {
				mapT[N_mid+i][j] = map[i][j];
			}
		}
		
		for(int i=N_mid;i<N;i++) {
			for(int j=0;j<M_mid;j++) {
				mapT[i][M_mid+j] = map[i][j];
			}
		}
		
		int Row = 0;
		for(int i=N_mid;i<N;i++,Row++) {
			for(int j=M_mid;j<M;j++) {
				mapT[Row][j] = map[i][j];
			}
		}
		
		for(int i=0;i<N_mid;i++) {
			int C = 0;
			for(int j=M_mid;j<M;j++,C++) {
				mapT[i][C] = map[i][j];
			}
		}
		map = mapT;
	}
}