def prime_num(a):
    if a % 2 == 0:return False
    for p in range(3, int(a**(1/2))+2, 2):
        if a % p == 0:return False
    return True

while True:
    N = int(input())
    if N == 0: break
    for i in range(2, int(N/2)+2):
        if prime_num(i) and prime_num(N-i):
                print("%d = %d + %d" %(N, i, N-i))
                break
        if i == int(N/2) + 1:
            print("Goldbach's conjecture is wrong.")
            break