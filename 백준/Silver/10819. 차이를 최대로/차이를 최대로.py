Max = 0
Result = []
prev = []

N = int(input())
L = list(map(int,input().split()))

def DFS(L):
    if len(L) == 0:
        Result.append(prev[:])
    for i in L:
        Next = L[:]
        Next.remove(i)

        prev.append(i)
        DFS(Next)
        prev.pop()

DFS(L)
for i in range(0, len(Result)):
    S = 0
    for j in range(1, N):
        S += abs(Result[i][j-1] - Result[i][j])
    if Max < S:
        Max = S
print(Max)