import java.util.*;

class Solution {
    Map<String, Integer> weight;
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        weight = init();
        
        for(int i = 0; i < survey.length; i++) {
            String negative = String.valueOf(survey[i].charAt(0));
            String positive = String.valueOf(survey[i].charAt(1));
            int choice = choices[i] - 4;
            
            if (choice > 0) {
                weight.compute(positive, (key, value) -> value + Math.abs(choice));
            }
            else {
                weight.compute(negative, (key, value) -> value + Math.abs(choice));
            }
            
        }
        answer += calculate("R", "T");
        answer += calculate("C", "F");
        answer += calculate("J", "M");
        answer += calculate("A", "N");

        return answer;
    }
    
    public String calculate(String type1, String type2) {
        int weight1 = weight.get(type1);
        int weight2 = weight.get(type2);
        
        if(weight1 == weight2) {
            if(type1.compareTo(type2) > 0) {
                return type2;
            }
            return type1;
        }
        return weight1 > weight2 ? type1 : type2;
    }
    
    public Map<String, Integer> init() {
        Map<String, Integer> weight = new HashMap<>();
        weight.put("R", 0);
        weight.put("T", 0);
        weight.put("C", 0);
        weight.put("F", 0);
        weight.put("J", 0);
        weight.put("M", 0);
        weight.put("A", 0);
        weight.put("N", 0);
        return weight;
    }
}
