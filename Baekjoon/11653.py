N = int(input())

while N%2 == 0:
    N = int(N/2)
    print(2)

for k in range(3,N+1,2):
    while N%k == 0:
        N = int(N/k)
        print(k)