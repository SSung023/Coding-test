def get_finished(N, stages):
    finished = [0] * (N+2)
    for stage in stages:
        finished[stage] += 1
    return finished

def solution(N, stages):
    result = {}
    denominator = len(stages) # 참여자들의 수
    
    finished = get_finished(N, stages) # 도달한 사용자의 수를 담은 배열
    
    for stage in range(1, N+1):
        if denominator != 0: # divided by zero를 막기 위해
            count = finished[stage] # 간결하지만 list.count()의 시간복잡도가 O(n)
            result[stage] = count / denominator
            denominator -= count # 더 이상 가지 못하는 사용자 제외
        else:
            result[stage] = 0
    
    # 딕셔너리의 value를 기준으로 내림차순으로 정렬
    return sorted(result, key=lambda x : result[x], reverse=True)
