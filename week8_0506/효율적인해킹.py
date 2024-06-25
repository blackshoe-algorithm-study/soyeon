import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

graph = {i: [] for i in range(1, n+1)}

for i in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)

def bfs(start, visited):
    visited[start] = True
    count = 1
    dq = deque([start])

    while dq:
        x = dq.popleft()
        for i in graph[x]:
            if not visited[i]:
                visited[i] = True
                count += 1
                dq.append(i)

    return count

max = 0
result = []
for i in range(1, n+1):
    visited = [False] * (n+1)
    count = bfs(i, visited)
    if count > max:
        max = count
        result = [i]
    elif count == max:
        result.append(i)

print(*result)