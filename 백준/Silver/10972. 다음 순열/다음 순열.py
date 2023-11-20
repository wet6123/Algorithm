N = int(input())
L = list(map(int, input().split()))

Final = []
S = []
brkp = 0

for i in range(N-1,1,-1):
    if L[i]>L[i-1]:
        brkp = i
        S.append(L[i])
        break
    else:
        S.append(L[i])

if N == 2 and L[0] == 1:
    print("2 1")
elif brkp == 0:
    print(-1)
else:
    S.sort()
    for j in range(len(S)):
        if S[j] > L[brkp-1]:
            L[brkp-1], S[j] =  S[j], L[brkp-1]
            break
    for k in range(brkp):
        if k < brkp:
            Final.append(L[k])
    Final.extend(S)
    for f in Final:
        print(f, end=" ")