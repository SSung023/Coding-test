def solution(arr):
    answer = []
    before = -1
    
    for a in arr:
        if before == a:
            continue
        answer.append(a)
        before = a
            
    return answer
