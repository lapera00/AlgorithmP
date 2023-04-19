import java.util.*;

class Solution_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int prolen = progresses.length;
        int[] time = new int[prolen];
        
        for (int i = 0; i < prolen; i++) {
            int prog = progresses[i];
            int day = 0;

            while (true) {
                prog += speeds[i];
                day++;
                if (prog >= 100) {
                    break;
                }
            }
            time[i] = day;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int pre = time[0];
        int count = 1;
        for (int i = 1; i < time.length; i++){
            if (pre < time[i]){
                list.add(count);
                count = 1;
                pre = time[i];
            } else{
                count++;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}