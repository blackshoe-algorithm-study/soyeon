import sys

input = sys.stdin.readline

t = int(input())

def isConsistent(arr):
    for i in range(len(arr)):
        for j in range(i+1, len(arr)):
            if arr[j].find(arr[i]) >= 0:
                return "NO" # 일관성 없음
        if i == len(arr)-1 and j == len(arr)-1:
            return "YES" # 일관성 있음

for _ in range(t):
    n = int(input())
    arr = [input().rstrip() for _ in range(n)]

    arr.sort(key=len) # 문자열 길이를 기준으로 정렬

    print(isConsistent(arr))

