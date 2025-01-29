import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minY = 100;
        int minX = 100;
        int maxY = -1;
        int maxX = -1;
        
        for(int y = 0; y < wallpaper.length; y++) {
            for(int x = 0; x < wallpaper[y].length(); x++) {
                char target = wallpaper[y].charAt(x);
                if(target == '#') {
                    minY = Math.min(minY, y);
                    minX = Math.min(minX, x);
                    maxY = Math.max(maxY, y);
                    maxX = Math.max(maxX, x);
                }
            }
        }
        
        
        return new int[] {minY, minX, maxY + 1, maxX + 1};
    }
}
