import sys
import heapq
from collections import defaultdict

# 백준 7662번 이중 우선순위 큐
imput = sys.stdin.readline

def dual_priority_queue():
    n = int(input())

    for _ in range(n):
        q = int(input())
        min_heap, max_heap = [], []
        count = defaultdict(int)

        for _ in range(q):
            cmd, num = input.split()
            num = int(num)

            if cmd == 'I':
                heapq.heappush(min_heap, num)
                heapq.heappush(max_heap, -num) # 음수로 넣어서 최대힙처럼 사용
                count[num] += 1

            elif cmd == 'D':
                if not count : 
                    continue

                target_heap = min_heap if num == -1 else max_heap # -1이면 최소 힙 사용, 아니면 최대 힙 사용

                while target_heap :
                    value = heapq.heappop(target_heap)
                    value = value if num==-1 else -value    # 최대힙 제거해야할 때 음수로 들어가있기에 양수로 나오기 위해선 -1 곱해줘야 함

                    # 중복 값 제거시
                    if count[value]>0:
                        count[value]-=1
                        if count[value] == 0:
                            del count[value]
                        break
        
        if not count:
            print("EMPTY")
        else:
            keys = count.keys()
            print(f"{max(keys)} {min(keys)}")


dual_priority_queue()