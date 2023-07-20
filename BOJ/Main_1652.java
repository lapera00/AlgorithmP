import java.util.*;
import java.io.*;

public class Main_1652 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j<N; j++) {
				arr[i][j] = s[j].charAt(0);
			}
		}
		
		int row = 0;
		int col = 0;
		
		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(i+1 < N) {
					if(arr[i][j] == '.' && arr[i+1][j] == '.' && (i + 2 >= N || arr[i+2][j] =='X')) {
						++col;
					}
				}
				if(j+1 < N) {
					if(arr[i][j] == '.' && arr[i][j+1] == '.' && (j + 2 >= N || arr[i][j+2] =='X')) {
						++row;
					}
				}
			}
		}
		
		System.out.println(row + " " + col);

	}

}
