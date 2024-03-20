import sys

input =sys.stdin.readline

t = int(input())
for _ in range(t):
    n, string = input().split()
    for i in string:
        print(i*int(n), end="")
    print()