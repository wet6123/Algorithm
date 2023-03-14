L, C = map(int, input().split())
A = list(input().split())

Pass = []
tmp = []
next = []

def DFS(tmp,A):
    if len(tmp) == L:
        a, b = 0, 0
        for char in tmp:
            if char in ('a','e','i','o','u'):a+=1
            else:b+=1
        if a >= 1 and b >= 2:
            tmps = sorted(tmp)
            str = "".join(tmps)
            Pass.append(str)
    next = A[:]
    for e in A:
        next.remove(e)
        
        tmp.append(e)
        DFS(tmp,next)
        tmp.pop()

DFS(tmp,A)

Pass.sort()
print(*Pass, sep='\n')