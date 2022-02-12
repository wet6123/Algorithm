H, M = map(int, input().split())
T = int(input())
M += T
H += int(M/60)
M = M%60
H = H%24
print(H, M)