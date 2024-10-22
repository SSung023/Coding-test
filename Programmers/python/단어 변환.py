from collections import deque

def is_valid(str1, str2):
    # 다른 문자 수를 셀 변수
    diff_count = 0
    
    # 두 문자열을 하나씩 비교
    for char1, char2 in zip(str1, str2):
        if char1 != char2:
            diff_count += 1
        # 다른 문자가 두 개 이상이면 False
        if diff_count > 1:
            return False
    
    # 다른 문자가 정확히 하나일 때만 True
    return diff_count == 1

def bfs(begin, target, words):
    answer = 0
    dq = deque([(begin, 0)])
    isVisited = [False for _ in range(len(words))]
    
    while dq:
        cur, step = dq.popleft()
        if cur == target:
            return step
        
        for idx, word in enumerate(words):
            if not isVisited[idx] and is_valid(cur, word):
                isVisited[idx] = True
                dq.append((word, step + 1))
    
    return answer


def solution(begin, target, words):
    if target not in words:
        return 0
    
    answer = bfs(begin, target, words)

    return answer
