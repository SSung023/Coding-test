from collections import deque

def solution(s):
    answer = True
    dq = deque()
    
    for bracket in s:
        if bracket  == "(":
            dq.append(bracket)
        else :
            try: 
                dq.pop()
            except IndexError:
                return False
    
    if dq:
        return False

    return True
