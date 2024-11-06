import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> people = new HashMap<>();
        
        for(String person : participant) {
            if(!people.containsKey(person)) {
                people.put(person, 1);
                continue;
            }
            int cur = people.get(person);
            people.put(person, cur + 1);
        }
        
        for(String archive : completion) {
            int cur = people.get(archive);
            people.put(archive, cur - 1);
        }
        
        for(Map.Entry<String, Integer> entry : people.entrySet()) {
            if(entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        
        return answer;
    }
}
