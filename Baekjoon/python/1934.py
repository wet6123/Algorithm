N = int(input())
for i in range(N):
    A, B = map(int, input().split())
    C = 1
    while (A % 2 == 0) and (B % 2 == 0):
        A = int(A / 2)
        B = int(B / 2)
        C = C * 2
    for j in range(3, A*B+3, 2):
        while (A % j == 0) and (B % j == 0):
            A = int(A / j)
            B = int(B / j)
            C = C * j
        if (A <= j) and (B <= j):
            C = C * A * B
            print(C)
            break