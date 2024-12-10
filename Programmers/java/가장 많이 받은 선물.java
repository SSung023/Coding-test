import java.util.*;

class Solution {
    // friends: 이름
    // gifts: 주고 받은 선물 기록
    public int solution(String[] friends, String[] gifts) {
        // 이름에 따른 접근 인덱스 저장
        Map<String, Integer> index = new HashMap<>();
        int cnt = 0;
        for(String name : friends) {
            index.put(name, cnt++);
        }
        
        // 선물 지수를 저장하기 위한 일차원 배열
        int giftIdx[] = new int[friends.length];
        
        // 선물 개수를 저장하기 위한 일차원 배열
        int answer[] = new int[friends.length];
        
        // 선물을 주고 받은 현황을 저장하기 위한 이차원 배열
        int status[][] = new int[friends.length][friends.length];
        for(String gift : gifts) {
            String names[] = gift.split(" ");
            int giverIdx = index.get(names[0]);
            int takerIdx = index.get(names[1]);
            
            status[giverIdx][takerIdx]++;
            
            //선물 지수도 같이 계산
            giftIdx[giverIdx]++;
            giftIdx[takerIdx]--;
        }
        
        for(int i = 0; i < friends.length; i++) {
            for(int k = i; k < friends.length; k++) {
                if(i == k) continue;
                
                // 서로 준 선물의 개수 확인
                int cnt1 = status[i][k]; 
                int cnt2 = status[k][i];
            
                
                // i가 k에게 준 선물 개수가 더 많다면
                if(cnt1 > cnt2) {
                    answer[i]++;
                }
                else if(cnt1 < cnt2) {
                    answer[k]++;
                }
                
                // 0개거나 같으면 선물지수에 따라 지급
                if(cnt1 == cnt2) {
                    int per1 = giftIdx[i];
                    int per2 = giftIdx[k];
                    
                    if(per1 > per2) {
                        answer[i]++;
                    }
                    else if(per2 > per1) {
                        answer[k]++;
                    }
                    continue;
                }
            }
        }
    
        
        Arrays.sort(answer);
        return answer[answer.length-1];
    }
}
