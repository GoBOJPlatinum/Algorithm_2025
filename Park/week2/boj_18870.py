n = int(input())

num = list(map(int, input().split()))

num.sort()

sec = num[0]
score = num[0]

for i in range(1,len(num)):
    sec += num[i]
    score += sec

print(score)