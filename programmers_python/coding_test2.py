"""
프로그래머스 Lv.0 두 수의 연산값 비교하기

연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.

12 ⊕ 3 = 123
3 ⊕ 12 = 312
양의 정수 a와 b가 주어졌을 때, a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.

단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다
"""

def solution(a, b):
    answer = 0
    
    tmp1 = int(str(a)+str(b))
    tmp2 = 2*a*b
    
    if tmp1<tmp2:
        answer = tmp2
    elif tmp1>tmp2:
        answer = int(tmp1)
    else :
        answer = tmp2
    
    return answer

if __name__ == "__main__":
    # a, b 입력 받음
    result = solution(1, 2)
    print(result) 