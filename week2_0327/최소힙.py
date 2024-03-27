import heapq
import sys

input = sys.stdin.readline

n = int(input())
q = []

for _ in range(n):
    num = int(input())

    if num == 0:
        if len(q) > 0:
            print(heapq.heappop(q))
        else:
            print(0)
    if num > 0:
        heapq.heappush(q, num)