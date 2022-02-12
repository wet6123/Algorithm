A, B = map(int, input().split())
C = 1

while A%2 == 0 and B%2 == 0:
        A = int(A/2)
        B = int(B/2)
        C = C*2

for i in range(3,A*B+3,2):
    while A%i == 0 and B%i == 0:
        A = int(A/i)
        B = int(B/i)
        C = C*i
    if A<i and B<i:
        print(C, C*B*A, sep='\n')
        break