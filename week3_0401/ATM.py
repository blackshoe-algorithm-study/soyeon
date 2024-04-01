n = int(input())
numbers = list(map(int, input().split()))
result = 0

numbers.sort()

for i in range(n):
    result += sum(numbers[0:i+1])

print(result)