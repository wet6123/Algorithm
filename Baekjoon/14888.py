'''순열을 이용하여 연산자 리스트를 만들고 그 리스트를 바탕으로 연산을 진행'''
#from itertools import permutations

N = int(input())
L = list(map(int, input().split()))
OP = list(map(int, input().split()))

OP_L = []
OP_LL = []
prev = []
for i in range(4):
    for j in range(OP[i]):
        OP_L.append(i)

def DFS(L):
    if len(L) == 0:
        OP_LL.append(prev[:])
    for e in L:
        next = L[:]
        next.remove(e)

        prev.append(e)
        DFS(next)
        prev.pop()

DFS(OP_L)

Min = float("inf")
Max = float("-inf")
for k in range(len(OP_LL)):
    Sum = L[0]
    for l in range(N-1):
        if OP_LL[k][l] == 0:
            Sum = Sum + L[l+1]
        elif OP_LL[k][l] == 1:
            Sum = Sum - L[l+1]
        elif OP_LL[k][l] == 2:
            Sum = Sum * L[l+1]
        elif OP_LL[k][l] == 3:
            Sum = int(Sum / L[l+1])
    if Sum > Max:
        Max = Sum
    if Sum < Min:
        Min = Sum
print(Max, Min, sep = '\n')