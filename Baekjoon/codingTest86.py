# 백준 11399번 ATM

import sys

input = sys.stdin.readline

def atm():
    n = int(input())
    arr = list(map(int, input().split()))

    arr.sort()

    sum_list = [0] * n
    sum_list[0] = arr[0]

    for i in range (1, n):
        sum_list[i] = arr[i] + sum_list[i-1]
    
    print(sum(sum_list))