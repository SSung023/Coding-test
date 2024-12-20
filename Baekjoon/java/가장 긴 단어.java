import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
        String pattern = "[^a-zA-Z-]+";
        
        int max = 0;
        String answer = "";
        
        while(true) {
            str = str.toLowerCase();
            String splited[] = str.split(pattern);
            for(String s : splited) {
                if(s.length() > max) {
                    max = s.length();
                    answer = s;
                }
            }
            
            if(str.contains("e-n-d")) {
                break;
            }
            str = br.readLine();
        }
        
        System.out.println(answer);
    }
}
