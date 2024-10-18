from collections import deque

def bfs(maps, cur_x, cur_y):
    min_dist = 10000000
    dy = [0, -1, 0, 1]
    dx = [-1, 0, 1, 0]
    end_y = len(maps) - 1
    end_x = len(maps[0]) - 1
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    dq = deque([[(cur_y, cur_x), 1]])
    
    visited[cur_y][cur_x] = True
    while dq:
        (cur_y, cur_x), dist = dq.popleft()
        
        for i in range(4):
            # print(dq)
            next_y = cur_y + dy[i]
            next_x = cur_x + dx[i]
            
            if next_x < 0 or next_y < 0 or next_x > end_x or next_y > end_y:
                continue
            if maps[next_y][next_x] == 1 and not visited[next_y][next_x]:
                dq.append([(next_y, next_x), dist + 1])
                visited[next_y][next_x] = True
                if next_y == end_y and next_x == end_x:
                    min_dist = min(min_dist, dist + 1)
    return min_dist


def solution(maps):
    dist = 0
    dist = bfs(maps, 0, 0)
    
    if dist == 10000000:
        return -1
    
    return dist
