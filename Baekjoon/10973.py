N =  int(input())
L = list(map(int, input().split()))
x = 0
for i in range(N-1, 0, -1):
    if L[i-1] > L[i]:
        x = i - 1
        break
for j in range(N-1, 0, -1):
    if L[x] > L[j]:
        L[x], L[j] = L[j], L[x]
        L = L[:x+1] + sorted(L[x+1:], reverse=True)
        print(*L)
        exit()
print(-1)