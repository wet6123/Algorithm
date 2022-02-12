E, S, M = map(int, input().split())
Y = 1
while E != 1 or S != 1 or M != 1:
    E -= 1
    S -= 1
    M -= 1
    Y += 1
    if E == 0:
        E = 15
    if S == 0:
        S = 28
    if M == 0:
        M = 19
print(Y)