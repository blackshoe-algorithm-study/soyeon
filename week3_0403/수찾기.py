import sys

input = sys.stdin.readline

def binary_search(array, target, start, end):
  while start <= end:
    mid = (start + end) // 2
    if array[mid] == target:
      return mid
    elif array[mid] > target:
      end = mid - 1
    else:
      start = mid + 1
  return None

n = int(input())
n_list = list(map(int, input().split()))
n_list.sort()  # 사전에 리스트 정렬

m = int(input())
m_list = list(map(int, input().split()))

for target in m_list:
  idx = binary_search(n_list, target, 0, n-1)
  if idx == None:
    print(0)
  else:
    print(1)