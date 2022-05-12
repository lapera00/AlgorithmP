import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891 {

	static int K, result;
	static int[][] map;
	static int[] roll;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
			map = new int[5][8];
			StringTokenizer st;
			for(int i =1; i<5; i++) {
				String str = br.readLine();
				for(int j =0 ;j<8; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
		}
		// 돌릴떄 다른 극이면 / 1 - 시계바향 / N - 0 / S=1 (1,2,4,8)
		// 2, 6번 물림
		// 돌릴방향 - 돌림 -점수
		K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			roll = new int[5];
			roll[n] = d;
			for (int i = n; i < 4; i++) {// 오른쪽애들 방향저장
				if (map[i][2] == map[i + 1][6])
					break;
				else
					roll[i + 1] = -roll[i];
			}
			for (int i = n; i > 1; i--) {// 왼쪽
				if (map[i][6] == map[i - 1][2])
					break;
				else
					roll[i - 1] = -roll[i];
			}

			for (int i = 1; i <= 4; i++) {// 돌리기
				if (roll[i] == 0)
					continue;
				else if (roll[i] == 1) {
					int temp = map[i][7];
					for (int a = 7; a > 0; a--) {
						map[i][a] = map[i][a - 1];
					}
					map[i][0] = temp;
				} else if (roll[i] == -1) {
					int temp = map[i][0];
					for (int a = 0; a < 7; a++) {
						map[i][a] = map[i][a + 1];
					}
					map[i][7] = temp;
				}
			}
		}
		result = 0;
		for (int i = 1; i <= 4; i++) {
			if (map[i][0] == 1) {
				if (i == 1)
					result += 1;
				else if (i == 2)
					result += 2;
				else if (i == 3)
					result += 4;
				else if (i == 4)
					result += 8;
			}
		}
		System.out.println(result);

	}

}
