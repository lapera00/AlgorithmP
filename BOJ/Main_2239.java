import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2239 {

	static int [][] arr;
	static ArrayList<Node> list;
	static class Node{
		int x,y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		};
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		arr = new int[10][10];
		list = new ArrayList<>();
		
		for(int i=1; i<=9; i++) {
			String str = br.readLine();
			for(int j = 1; j<=9; j++) {
				arr[i][j] = str.charAt(j-1) - '0';
				if(arr[i][j] == 0 ) list.add(new Node(i,j));
			}
		}
		
		sudoku(0);
		
		for(int i =1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				sb.append(arr[i][j]);
			}sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}

	static boolean end;
	private static void sudoku(int d) {
		if(d == list.size()) {
			end = true;
			return;
		}
		
		Node cur = list.get(d);
		for(int i=1; i<=9; i++) {
			if(arr[cur.x][cur.y]==0 ) {
				if(check(cur.x, cur.y, i)== true) {
					arr[cur.x][cur.y] = i;
					sudoku(d+1);
					if(end == true) return;
					arr[cur.x][cur.y] = 0;
				}
			}
		}
	}
	
	private static boolean check(int x, int y, int num) {
		//가로, 세로, 박스
		for(int i=1; i<=9; i++) {
			if(x != i && arr[i][y] == num) return false;
			if(y != i && arr[x][i] == num) return false;
		}
		
		int xbox, ybox;
		if(x % 3 == 0) xbox = x - 2;
		else xbox = x - x % 3 + 1;
		if(y % 3 == 0) ybox = y - 2;
		else ybox = y - y % 3 + 1;
		
		for(int i=xbox; i<xbox+3; i++) {
			for(int j=ybox; j<ybox+3; j++) {
				if(x!=i && y != j && arr[i][j] == num) return false;
			}
		}		
		
		return true;
	}

}
