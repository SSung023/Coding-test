from collections import deque

def set_edge(computers, n):
    network = [[] for _ in range(n)]
    for i in range(n):
        for k in range(i, n):
            if i == k :
                continue
            if computers[i][k] == 1:
                network[i].append(k)
                network[k].append(i)
    
    return network

def bfs(i, isVisited, network):
    dq = deque([i])
    
    while dq:
        cur = dq.popleft()
        for next_com in network[cur]:
            if not isVisited[next_com]:
                dq.append(next_com)
                isVisited[next_com] = True
    
    return isVisited
    

def solution(n, computers):
    answer = 0
    isVisited = [False for _ in range(n)]
    network = set_edge(computers, n)
    
    for i in range(n):
        if not isVisited[i]:
            isVisited = bfs(i, isVisited, network)
            answer += 1
    
    return answer
