#퇴사
N = int(input())
days = []
pay = []
dp=[]
for _ in range(N):
    a, b = map(int,input().split())
    days.append(a)
    pay.append(b)
    dp.append(b)
dp.append(0) #다음의 for문 최초 시도에서 인덱스초과 오류 방지
for i  in range(N-1, -1, -1):
    if days[i] + i > N: #퇴사 기한 초과
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i+1], pay[i] + dp[i + days[i]]) #그날 일을 하는게 좋은지 다음 일을 하는게 좋은지 판단
print(dp[0])
