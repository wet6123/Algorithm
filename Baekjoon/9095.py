def Factorial(a):
    if a<=1:return 1
    return a*Factorial(a-1)

Time = int(input())

for _ in range(Time):
    N = int(input())
    Sum = 0
    for i in range(N // 3 + 1):
        A = N - 3 * i
        for j in range(N // 2 + 1):
            B = A - 2 * j
            if B >= 0:
                Sum = Sum + Factorial(i+j+B)//(Factorial(i)*Factorial(j)*Factorial(B))
    print(Sum)