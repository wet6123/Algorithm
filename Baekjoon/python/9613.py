def GCD(a, b):
    while b != 0:
        a, b = b, a % b
    return a

N = int(input())
L = [list(map(int, input().split())) for _ in range(N)]

for i in range(N):
    S = 0
    for j in range(1, len(L[i])):
        for k in range(j+1,len(L[i])):
            G = GCD(L[i][j], L[i][k])
            S += G
    print(S)