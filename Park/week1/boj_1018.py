# 백으로 시작하는 경우의 체스판과 흑으로 시작하는 경우의 체스판 미리 정의
whiteStart = ['WBWBWBWB', 'BWBWBWBW'] * 4
blackStart = ['BWBWBWBW', 'WBWBWBWB'] * 4

# 데이터 입력받음
n,m = map(int, input().split())

# 입력 받을 체스판
data = []
for i in range(n):
    data.append(input())

# 정답 출력용 변수
answer = float("inf")

# 8x8으로 자를 체스판의 시작 좌표
for z in range(0,n - 7):
    for x in range(0, m - 7):
        
        # 8x8로 체스판 자르기
        tmpChess = []

        for a in range(z, z + 8):
            tmpChess.append(data[a][x:x+8])

        # 백으로 시작하는 체스판과 비교할 때 교체해야할 체스판의 수
        whiteStartCnt = 0

        # 흑으로 시작하는 체스판과 비교할 때 교체해야할 체스판의 수
        blackStartCnt = 0

        # 자른 체스판과 미리 정의해둔 체스판과 비교
        for cy in range(8):
            for cx in range(8):
                if tmpChess[cy][cx] != whiteStart[cy][cx]:
                    whiteStartCnt += 1
                
                if tmpChess[cy][cx] != blackStart[cy][cx]:
                    blackStartCnt += 1
        
        # 최소값 비교 후 업데이트
        answer = min(whiteStartCnt,blackStartCnt, answer)

print(answer)
                

