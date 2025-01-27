import java.util.*;

// 1) 같은 사용자 여러 번 신고 -> 1번 신고로 처리
// 2) 특정 사용자 정지 시, 해당 사용자를 신고한 이용자의 count++

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        Map<String, Set<String>> reportBook = new HashMap<>();
        Map<String, Integer> indexBook = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            reportBook.put(id, new HashSet<>());
            indexBook.put(id, i);
        }
        
        // 신고 내용을 토대로 기록
        for(String report : reports) {
            String reporter = report.split(" ")[0];
            String respondent = report.split(" ")[1];
            
            Set<String> reporters = reportBook.get(respondent);
            reporters.add(reporter);
        }
        
        for(Set<String> reporters : reportBook.values()) {
            if(reporters.size() < k)   continue;
            for(String name : reporters) {
                int index = indexBook.get(name);
                answer[index]++;
            }
        }
        
        
        return answer;
    }
}
