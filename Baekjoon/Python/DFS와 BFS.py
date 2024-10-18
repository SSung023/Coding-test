from collections import deque


def bfs(graph, visited_bfs, start):
  dq = deque([start])
  visited_bfs[start] = True
  while dq:
    cur = dq.popleft()
    print(cur, end=' ')
    for next in graph[cur]:
      if not visited_bfs[next]:
        dq.append(next)
        visited_bfs[next] = True


def dfs(graph, visited_dfs, cur):
  visited_dfs[cur] = True
  print(cur, end=' ')
  for next in graph[cur]:
    if not visited_dfs[next]:
      dfs(graph, visited_dfs, next)


if __name__ == '__main__':
  n, m, v = map(int, input().split())
  graph = [[] for _ in range(n + 1)]
  visited_bfs = [False] * (n + 1)
  visited_dfs = [False] * (n + 1)

  for i in range(m):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)

  for i in range(n+1):
    graph[i].sort()

  dfs(graph, visited_dfs, v)
  print()
  bfs(graph, visited_bfs, v)
