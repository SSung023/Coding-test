# 1번 풀이
def solution(participant, completion):
    answer = ''
    participant_dict = {}
    
    for person in participant:
        if person not in participant_dict:
            participant_dict[person] = 1
        else:
            count = participant_dict[person]
            participant_dict.update({person: count + 1})
    
    for person in completion:
        count = participant_dict[person]
        if count == 1:
            del participant_dict[person]
        else:
            participant_dict.update({person: count - 1})
    
    lists = list(participant_dict.keys())
    
    return lists[0]


# 2번 풀이 - sort(), zip() 활용
def solution(participant, completion):   
    participant.sort()
    completion.sort()
    
    for p, c in zip(participant, completion):
        if p != c:
            return p
        
    return participant[-1]

  
# 3번 풀이 - Counter 객체 활용
from collections import Counter

def solution(participant, completion):   
    out = Counter(participant) - Counter(completion)
    return list(out)[-1]
