import sys

input = sys.stdin.readline
n = int(input())
d = {}

for _ in range(n):
    name, eol = input().rstrip().split()
    if eol == 'enter':
        d[name] = 1
    if eol == 'leave':
        d[name] = 0

for key, value in sorted(d.items(), reverse=True):
    if value == 1:
        print(key)
