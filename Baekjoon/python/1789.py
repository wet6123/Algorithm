A = int(input())
i = 1
while A > 0:
    A -= i
    i += 1
if A == 0:
    print(i-1)
else :
    print(i-2)