N = int(input())
node = []
prev = []
P = []
L = [e for e in range(N)]
Min = float("inf")
for _ in range(N):
    node.append(list(map(int, input().split())))

def DFS(L):
    global Min
    Sum = 0
    if len(L) == 0:
        P = prev[:]
        P.append(prev[0])
        for i in range(N):
            if node[P[i]][P[i+1]] == 0:Sum=float("inf")
            Sum += node[P[i]][P[i+1]]
        if Sum < Min:
            Min = Sum
    for e in L:
        next = L[:]
        next.remove(e)

        prev.append(e)
        DFS(next)
        prev.pop()
DFS(L)
print(Min)