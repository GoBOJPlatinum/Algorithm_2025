n = int(input())

data = []

for _ in range(n):
    data.append(list(map(int, input().split())))

# 회의가 끝나는 시간 순으로 오름차순 정렬, 2순위로 회의가 시작하는 순서로 정렬
data.sort(key = lambda x : (x[1], x[0]))

curEnd = data[0][1]
count = 1

# 만약 다음 회의 시작시간이 현재 회의 끝나는 시간과 같거나 더 늦는다면 
for i in range(1, len(data)):
    if data[i][0] >= curEnd:
        count += 1
        curEnd = data[i][1]

print(count)