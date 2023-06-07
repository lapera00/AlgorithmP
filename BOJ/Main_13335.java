import java.util.*;
import java.io.*;

public class Main_13335 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); //트럭수
		int w = Integer.parseInt(st.nextToken()); //다리 길이
		int l = Integer.parseInt(st.nextToken()); //최대하중
		
		Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        int count = 0; // 시간
        int bw = 0; //다리 무게

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            truck.offer(Integer.parseInt(st.nextToken())); // 트럭 무게
        }

        for(int i = 0; i < w; i++){
            bridge.add(0); 
        }

        while(bridge.isEmpty() == false) {
            count++;
            bw -= bridge.poll();
            if(truck.isEmpty() == false){
                if(truck.peek() + bw <= l) { 
                    bw += truck.peek();
                    bridge.offer(truck.poll()); // 다리에 트럭 추가
                }else{ // 최대 하중 초과
                    bridge.offer(0);
                }
            }
        }
        
        System.out.println(count);
        
        
		
	}

}
