T = int(input())
for _ in range(T):
    N = int(input())
    A_name, A_bot = input().split()
    for i in range(1, N):
        B_name, B_bot = input().split()
        if int(A_bot) < int(B_bot):
            A_name = B_name
            A_bot = B_bot
    print(A_name)