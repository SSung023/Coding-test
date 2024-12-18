import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1000000;
        
        if(s.length() == 1) {
            return 1;
        }
        
        for(int i = 1; i < s.length(); i++) {
            String compacted = compact(s, i);
            answer = Math.min(answer, compacted.length());
        }
        
        return answer;
    }
    
    private String compact(String s, int unit) {
        StringBuilder sb = new StringBuilder();
        List<String> parsed = parse(s, unit);
        String prev = parsed.get(0);
        int cnt = 1;
      
        for(int i = 1; i < parsed.size(); i++) {
            String compare = parsed.get(i);
            if(prev.equals(compare)) {
                cnt++;
                continue;
            }
            
            if(cnt > 1) { // 2 이상 반복인 경우 숫자를 앞에 붙여줌
                sb.append(cnt);
            }
            sb.append(prev);
            prev = compare;
            cnt = 1;
        }
        
        if(cnt > 1) {
            sb.append(cnt);
        }
        sb.append(parsed.get(parsed.size() - 1));
        
        return sb.toString();
    }
    
    private List<String> parse(String s, int unit) {
        List<String> parsed = new ArrayList<>();
        for(int start = 0; start < s.length(); start += unit) {
            int end = start + unit;
            if(end >= s.length()) {
                parsed.add(s.substring(start));
                continue;
            }
            parsed.add(s.substring(start, start + unit));
        }
        return parsed;
    }
}
