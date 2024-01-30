import java.io.*;
import java.util.*;

public class Softeer_강의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
        
        int fend = arr[0][1];
        int result = 1;
        
        for(int i = 1; i < N; i++) {
			if(fend > arr[i][0]) {
                continue;
            }else {
                ++result;
                fend = arr[i][1];
            }
		}

        System.out.print(result);
        

    }
}

/*

*/