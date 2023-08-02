public class Solution_단어변환 {
    
    static boolean visit[];
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visit = new boolean[words.length];
        
        sol(begin, target, words, 0);
        
        return answer;
    }
    
    static void sol(String n, String target, String[] words, int cnt){
        if(n.equals(target)){
            answer = cnt;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(visit[i] == true) continue;
            
            int x = 0;
            
            for(int j = 0; j < n.length(); j++){
                if(n.charAt(j) != words[i].charAt(j)) ++x;
            }

            if(x == 1){
                visit[i] = true;
                sol(words[i], target, words, cnt + 1);
                visit[i] = false;
                
            }
        }
        
        
    }
    
}