# 백준 1213번 팰린드롬 만들기

s = input.strip()
count = [0]*26

for char in s:
    count[ord(char)-ord('A')] += 1

odd = 0
middle = ''

for i in range(26):
    if count[i] %2 == 1:
        odd +=1
        middle = chr(i+ord('A'))
    if odd > 1:
        print("I'm Sorry Hansoo")
        exit()

first_half=[]

for i in range(26):
    first_half.append(chr(i+ord('A')) * (count[i]//2))

first_half = ''.join(first_half)
print(first_half+middle+first_half[::-1])