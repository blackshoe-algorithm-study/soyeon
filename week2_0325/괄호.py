import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    arr = input().rstrip()
    stack = []
    
    for i in range(len(arr)):
        if arr[i] == "(": 
            stack.append(arr[i])
            
        if arr[i] == ")" and len(stack) > 0:
            stack.pop()
        elif arr[i] == ")" and len(stack) == 0:
            print("NO")
            break

        # 마지막에 괄호가 남은 경우
        if i == len(arr)-1 and len(stack) > 0:
            print("NO")
        # 마지막에 아무것도 없는 경우
        elif i == len(arr)-1 and len(stack) == 0:
            print("YES")
    