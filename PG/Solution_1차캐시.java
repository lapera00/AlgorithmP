import java.util.*;

class Solution_1차캐시 {
    public int solution(int cacheSize, String[] cities) {
        
        Queue<String> caches = new LinkedList<>();
        int time = 0;
        
        if(cacheSize ==0){
            return cities.length * 5;
        }
        for(String city : cities){
            String city2 = city.toLowerCase();
            if(caches.contains(city2)){
                caches.remove(city2);
                caches.offer(city2);
                ++time;
            }else{
                if(caches.size() < cacheSize){
                    caches.offer(city2);
                }
                else{
                    caches.poll();
                    caches.offer(city2);
                }
                time += 5;
            }
        }
        
        return time;
    }
}