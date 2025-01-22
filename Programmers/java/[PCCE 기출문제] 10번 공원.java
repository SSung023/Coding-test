import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int lenY = park.length;
        int lenX = park[0].length;
        
        Arrays.sort(mats);
        
        for(int y = 0; y < lenY; y++) {
            for(int x = 0; x < lenX; x++) {
                //비어있는 자리가 아니라면 검사 대상에서 제외
                if(!park[y][x].equals("-1"))  continue;
                
                //비어있는 자리라면 테스트
                for(int i = 0; i < mats.length; i++) {
                    int len = mats[i];
                    if(!isValid(park, y, x, len))   break;
                    
                    answer = Math.max(answer, len);
                }
            }
        }
        return answer;
    }
    
    private boolean isValid(String[][] park, int y, int x, int len) {
        int lenY = park.length;
        int lenX = park[0].length;
        
        for(int nextY = y; nextY < y + len; nextY++) {
            for(int nextX = x; nextX < x + len; nextX++) {
                if(nextY < 0 || nextY >= lenY || nextX < 0 || nextX >= lenX) {
                    return false;
                }
                
                String cur = park[nextY][nextX];
                
                if(!cur.equals("-1")) return false;
            }
        }
        return true;
    }
}
