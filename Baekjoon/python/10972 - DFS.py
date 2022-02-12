N = int(input())
L = [i for i in range(1,N+1)]
com = list(map(int, input().split()))


result = []
prev = []
Final = []

def DFS(L):
    global result, Final
    if len(L) == 0:
        if result == com:
            Final = prev[:]
        result.clear()
        result = prev[:]
    for e in L:
        next = L[:]
        next.remove(e)

        prev.append(e)
        DFS(next)
        prev.pop()
DFS(L)

A = [i for i in range(N,0,-1)]
if com == A:
    print(-1)
else:
    for i in Final:
        print(i, end=" ")