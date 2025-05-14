# 백준 15903번 카드 합체 놀이


import heapq

n, m = map(int, input().split())
cards = list(map(int, input().split()))

heapq.heapify(cards)

for _ in range(m):
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)
    sum_ab = a+b
    heapq.heappush(sum_ab)
    heapq.heappush(sum_ab)


print(sum(heapq))