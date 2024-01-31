import java.io.*;
import java.util.*;

public class Softeer_진정한효도 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int arr[][] = new int[3][3];

        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minCost = Integer.MAX_VALUE;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                int cost = cost(arr, i, j, i, j + 2);
                minCost = Math.min(minCost, cost);
            }
        }

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 3; j++) {
                int cost = cost(arr, i, j, i + 2, j);
                minCost = Math.min(minCost, cost);
            }
        }

        System.out.println(minCost);
        
    }


    static int cost(int[][] arr, int x1, int y1, int x2, int y2) {
        int[] heights = new int[3];
        int index = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                heights[index++] = arr[i][j];
            }
        }
        
        Arrays.sort(heights);

        int minCost = Integer.MAX_VALUE;
        for (int h = 1; h <= 3; h++) {
            int cost = 0;
            for (int i = 0; i < 3; i++) {
                cost += Math.abs(heights[i] - h);
            }
            minCost = Math.min(minCost, cost);
        }
        
        return minCost;
    }


    
}
