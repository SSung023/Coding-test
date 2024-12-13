import java.util.*;

class Solution {
    Map<String, List<Integer>> map;
    
    public List<Integer> solution(String[] infos, String[] queries) {
        List<Integer> answer = new ArrayList<>();
        map = new HashMap<>();
        
        for(String info : infos) {
            String parts[] = info.split(" ");
            addValidCondition(parts, "", 0);
        }
        
        // 엔트리별로 value(점수)를 정렬
        for(List<Integer> score : map.values()) {
            Collections.sort(score);
        }
        
        // 쿼리들을 살펴보며 조건 확인
        for(String query : queries) {
            query = query.replace(" and ", "");
            String target[] = query.split(" ");
            String targetCondition = target[0];
            int targetScore = Integer.parseInt(target[1]);
            
            if(map.containsKey(targetCondition)) {
                int num = binarySearch(map.get(targetCondition), targetScore);
                answer.add(num);
            }
            else {
                answer.add(0);
            }
        }
        return answer;       
    }
    
    public int binarySearch(List<Integer> scores, int targetScore) {
        int start = 0;
        int end = scores.size() - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(scores.get(mid) < targetScore) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return scores.size() - start;
    }
    
    
    // DFS를 통해 검색 가능한 조건을 모두 추가
    // cnt가 4일때 까지만 진행
    public void addValidCondition(String[] parts, String condition, int cnt) {
        if(cnt == 4) {
            if(!map.containsKey(condition)) {
                List<Integer> scores = new ArrayList<>();
                map.put(condition, scores);
            }
            map.get(condition).add(Integer.parseInt(parts[4])); // 점수 추가
            return;
        }
        
        addValidCondition(parts, condition + parts[cnt], cnt + 1);
        addValidCondition(parts, condition + "-", cnt + 1);
    }
}
