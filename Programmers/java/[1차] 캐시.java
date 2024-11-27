import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) { // 도시이름은 대소문자 구분 X
        int answer = 0;
        Set<String> cache = new HashSet<>();
        Deque<String> deque = new ArrayDeque<>(); // 뒷 부분이 최신, 앞 부분이 오래된 것
        
        if(cacheSize == 0) {
            return 5 * cities.length;
        }
        
        for(String city : cities) {
            city = city.toLowerCase();
            // 캐시에 있을 때 
            if (cache.contains(city)) {
                answer++;
                deque.remove(city); // deque에서 빼서 뒤로 옮긴다
                deque.addLast(city);
                continue;
            }
            
            // 캐시에 없을 때
            // 아직 캐시에 자리가 있다면 캐시에 추가
            if(cache.size() < cacheSize) { 
                deque.addLast(city);
            }
            else {
                // 캐시에 자리가 없다면 오래된 것 지우고 새로 추가
                String target = deque.pollFirst();
                cache.remove(target);
                deque.addLast(city);
            }
            answer += 5;
            cache.add(city);
        }
        
        return answer;
    }
}
