class Solution {
    int numOfRemove;
    public int[] solution(String s) {
        numOfRemove = 0;
        int numOfBinary = 0;
        
        while(!s.equals("1")) {
            s = removeZero(s);
            s = convert(s);
            numOfBinary++;
            
        }
        
        return new int[] {numOfBinary, numOfRemove};
    }
    
    private String convert(String s) {
        int len = s.length();
        return Integer.toString(len, 2);
    }
    
    private String removeZero(String s) {
        for(int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if(target == '0') {
                numOfRemove++;
                continue;
            }
        }
        return s.replace("0", "");
    }
}
