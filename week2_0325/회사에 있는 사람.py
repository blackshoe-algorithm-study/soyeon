import sys

input = sys.stdin.readline
n = int(input())
arr = []

for _ in range(n):
    name, eol = input().rstrip().split()
    if eol == 'enter':
        arr.append(name)
    if eol == 'leave':
        arr.remove(name)

arr.sort(reverse=True)
print(*arr, sep="\n")
