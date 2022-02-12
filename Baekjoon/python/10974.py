N = int(input())
L = [i for i in range(1,N+1)]

prev = []

def DFS(L):
    if len(L) == 0:
        print(*prev)
    for e in L:
        next = L[:]
        next.remove(e)

        prev.append(e)
        DFS(next)
        prev.pop()
DFS(L)
