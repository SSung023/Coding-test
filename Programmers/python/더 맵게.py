# 모든 스코빌 지수를 K 이상으로 만들기 위해, 가장 낮은 두 개의 음식을 섞어 만듬
# new = lowest + (second * 2)
# 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복
# 최소로 섞어야하는 횟수 Return

import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    if scoville[0] >= K:
        return 0
    
    while len(scoville) >= 2:
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        new = first + (second * 2)
        
        heapq.heappush(scoville, new)
        answer += 1
        
        # heap 구조를 가지고 있으므로, 제일 앞의 값이 제일 작은 값
        if scoville[0] >= K:
            return answer
        
    if scoville[0] >= K:
            return answer
    return -1
