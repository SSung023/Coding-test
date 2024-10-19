from collections import deque

def solution(numbers, target):
    answer = 0
    dq = deque([(numbers[0], 0), (-numbers[0], 0)])
    end = len(numbers) - 1

    while dq:
        cur, idx = dq.popleft()
        
        if idx == end:
            if cur == target:
                answer += 1
            continue
            
        next_idx = idx + 1
        dq.append((cur + numbers[next_idx], next_idx))
        dq.append((cur + -1 * numbers[next_idx], next_idx))
    
    
    return answer
