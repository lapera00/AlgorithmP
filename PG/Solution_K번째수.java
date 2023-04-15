import java.util.*;

public class Solution_K번째수 {

	public int[] solution(int[] array, int[][] commands) {
        int clen = commands.length;
        int[] answer = new int[clen];
        
        for(int i = 0; i<clen; i++){
            int[] temp = new int[commands[i][1] - commands[i][0] + 1];
            for(int x = 0, a = commands[i][0]-1; a<commands[i][1]; a++, x++){
                temp[x] = array[a];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        
        return answer;
    }
}
