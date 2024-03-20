import sys

input = sys.stdin.readline
n = int(input())
arr = [input().rstrip() for _ in range(n)]
counter = {}

for str in arr:
    counter[str] = 0

for str in arr:
    counter[str] += 1

# 첫번째인자를 기준으로 내림차, 두번째인자를 기준으로 오름차 정렬
print(sorted(counter.items(), key= lambda item:(-item[1], item[0]))[0][0])
# counter.items()는 [('icecream', 2), ('peanuts', 2), ('chocolate', 2), ('candy', 1), ('apple', 1)] 형태