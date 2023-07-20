import java.util.*;

class Solution_더맵게 {
    public int solution(int[] scoville, int K) {        
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue();

        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while (queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }
            int a = queue.poll();
            int b = queue.poll();

            int result = a + (b * 2);
            
            queue.add(result);
            
            answer++;
        }
        return answer;
    }
}
