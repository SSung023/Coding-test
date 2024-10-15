from collections import deque

def update_location(location, dq):
    if location == 0:
        return len(dq) - 1
    return location - 1

def solution(priorities, location):
    dq = deque(priorities)
    order = 0

    while dq:
        # 가장 높은 우선순위 찾기
        highest = max(dq)
        target = dq.popleft()
        
        # 더 큰 프로세스가 있는 경우 
        if target < highest:
            dq.append(target)
        else:
            # append를 안했다는 것은 프로세스가 실행되었다는 것
            order += 1
            if location == 0:
                return order
            
        location = update_location(location, dq)
