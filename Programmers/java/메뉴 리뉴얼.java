import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int cnt : course) {
            map.clear(); // 각 코스 길이에 대해 초기화
            
            for (String order : orders) {
                char[] menus = order.toCharArray();
                Arrays.sort(menus); // 메뉴 정렬
                makeCourse(0, "", menus, cnt);
            }
            
            if (!map.isEmpty()) { // map이 비어 있지 않을 때만 처리
                int max = map.values().stream().max(Integer::compareTo).orElse(0);
                
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == max && max > 1) { // 2회 이상 주문된 조합만 추가
                        answer.add(entry.getKey());
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
    
    private void makeCourse(int idx, String cur, char[] menus, int len) {
        if (cur.length() == len) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }
        if (idx >= menus.length) {
            return;
        }
        
        makeCourse(idx + 1, cur + menus[idx], menus, len); // 현재 메뉴 포함
        makeCourse(idx + 1, cur, menus, len); // 현재 메뉴 포함하지 않음
    }
}
