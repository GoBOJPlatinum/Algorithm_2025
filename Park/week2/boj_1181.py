n = int(input())

data = []

for _ in range(n):
    insert = input()

    # [입력된 문자, 문자의 길이] 형식으로 삽입
    data.append((insert, len(insert)))


# 중복 제거
data = set(data)
data = list(data)

# 문자의 길이순으로 1차 정렬, 사전순으로 2차 정렬
data.sort(key = lambda x : (x[1],x[0] ))

# 정렬된 문자 출력
for i in range(len(data)):
    print(data[i][0])