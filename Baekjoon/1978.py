def prime_num(a):
    if a == 1:
        return 0
    else:
        for j in range(2, a + 1):
            if a % j == 0 and a != j:
                return 0
        return 1

N = int(input())
L = list(map(int,input().split()))
Count = 0
for i in range(N):
    Count += prime_num(L[i])
print(Count)
