class Solution {
    
    static int answer = 0;
    static boolean[] visit;
    
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        visit = new boolean[len];
        
        dfs(0, k, dungeons);
        
        
        return answer;
    }
    
    public static void dfs(int dep, int k, int[][] dungeons){
        for(int i=0; i<dungeons.length; i++){
            if( visit[i] == false && dungeons[i][0] <= k){
                visit[i] = true;
                dfs(dep + 1, k-dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        
        answer = Math.max(answer, dep);
    }
    
}