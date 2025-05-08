# 백준 1449번 수리공 항승

import sys

input = sys.stdin.readline

def water():
    n, i = map(int, input().split())
    arr = list(map(int, input().split()))

    arr.sort()

    answer = 1
    tapeEnd = arr[0] - 0.5 + i

    for idx in range(1, n):
        if(arr[idx]+0.5) > tapeEnd :
            answer+=1
            tapeEnd = arr[idx] - 0.5 + i
    
    print(answer)

water()