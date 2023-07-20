import java.util.*;

class Solution_더맵게 {
    public int solution(int[] scoville, int K) {        
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int i = 0; i < scoville.length; i++) {
            heap.offer(scoville[i]);
        }

        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            int a = heap.poll();
            int b = heap.poll();

            int result = a + (b * 2);
            
            heap.offer(result);
            
            ++answer;
        }
        return answer;
    }
}