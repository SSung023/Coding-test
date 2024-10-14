# 뒤에 있는 기능이 먼저 개발될 수 있으나, 앞에 있는 기능과 같이 배포
# 각 배포마다 몇 개의 기능이 배포되는지 return
# progresses: 배포되어야 하는 순서대로 작업의 진도
# speeds:각 작업의 개발 속도
import math
from collections import deque

def solution(progresses, speeds):
    answer = []
    duration_queue = deque()
    publish_queue = deque()
    
    for idx, progress in enumerate(progresses):
        speed = speeds[idx]
        duration = math.ceil((100 - progress)/speed)
        duration_queue.append(duration)
    
    publish = 1
    current_date = duration_queue.popleft()
    
    while True :
        if not duration_queue:
            answer.append(publish)
            return answer 
        
        next_date = duration_queue.popleft()

        # 배포 개수 추가
        if current_date >= next_date:
            publish += 1
            print("배포 개수 추가")
        # 새로운 배포
        else:
            answer.append(publish)
            publish = 1
            current_date = next_date
            
    
    return answer
