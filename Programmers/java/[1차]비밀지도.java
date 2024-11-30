import java.util.*;

class Solution {
    public List<String> solution(int n, int[] arr1, int[] arr2) {
        List<String> answer = new ArrayList<>();
        
        for(int i = 0; i < arr1.length; i++) {
            int num1 = arr1[i];
            int num2 = arr2[i];
            
            String converted1 = String.format("%" + n + "s", Long.toBinaryString(num1).replace(' ', '0'));
            String converted2 = String.format("%" + n + "s", Long.toBinaryString(num2).replace(' ', '0'));
            
            answer.add(getConverted(converted1, converted2));
        }
    
        return answer;
    }
    
    String getConverted(String converted1, String converted2) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < converted1.length(); i++) {
            if(converted1.charAt(i) == '1' || converted2.charAt(i) == '1') {
                sb.append('#');
                continue;
            }
            sb.append(' ');
        }
        return sb.toString();
    }
}
