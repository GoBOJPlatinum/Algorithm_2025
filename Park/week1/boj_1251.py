# 입력받을 문자열
data = input()

# 3개의 문자열로 나눈 후 각각 뒤집어서 다시 합친 리스트
result = []

for i in range(1, len(data) - 1):
    for j in range(i+1, len(data)):
        # 문자열을 3개로 나누기
        set1 = data[:i]
        set2 = data[i:j]
        set3 = data[j:]


        # 문자열을 뒤집기
        set1 = set1[::-1]
        set2 = set2[::-1]
        set3 = set3[::-1]

        # 뒤집은 문자열 합치기
        tmp = set1+set2+set3

        # 합친 문자열 리스트에 추가
        result.append(tmp)

# 리스트를 정렬 후 출력 변수에 정답 저장
result.sort()
answer = result[0]

print(answer)
        
        
        