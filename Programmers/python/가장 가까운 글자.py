def set_first_pos(s):
    dict = {}
    for i in range(len(s)):
        target = s[i]
        if target in dict:
            continue
        dict[target] = i
    return dict
    
def solution(s):
    answer = []
    dict = {}
    
    for i in range(len(s)):
        target = s[i]
        if target in dict:
            ahead = i - dict[target]
            answer.append(ahead)
        else:
            answer.append(-1)
            
        dict[target] = i
    
    return answer
