from collections import deque

def solution(prices):
    dq = deque(prices)
    answer = []
    
    
    while dq:
        price = dq.popleft()
        time = 0
        for target in dq:
            time += 1
            if price > target:
                break
        answer.append(time)
    
    return answer
