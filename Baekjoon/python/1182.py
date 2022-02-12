N, S = map(int, input().split())
L = list(map(int, input().split()))

sum = 0
counter = 0

def findsum(lst):
    global counter, sum
    if sum == S:
        counter += 1
    A = lst[:]
    for e in lst:
        A.remove(e)

        sum += e
        findsum(A)
        sum -= e

findsum(L)
if S == 0: counter -= 1
print(counter)