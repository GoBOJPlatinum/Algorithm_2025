import sys

# 입력 받기
n = int(sys.stdin.readline())
coords = list(map(int, sys.stdin.readline().split()))

# 중복 제거 후 정렬
sorted_unique = sorted(set(coords))  # 정렬된 유일한 값 리스트 생성

# 좌표 압축을 위한 딕셔너리 생성
index_map = {}
for i in range(len(sorted_unique)):
    index_map[sorted_unique[i]] = i  # 각 숫자의 압축된 인덱스를 저장


# 결과 출력
for num in coords:
    print(index_map[num], end=' ')