L = [int(input()) for _ in range(9)]
sumation = sum(L)
breaker = False

for i in range(8):
    for j in range(i+1,9):
        if sumation == 100 + L[i] + L[j]:
            L[i], L[j] = 101, 101
            breaker = True
            break
    if breaker == True:
        break
    
L.sort()
for k in range(7):
    print(L[k])