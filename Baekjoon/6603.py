def combination(arr, r):
    # 1.
    arr = sorted(arr)
    used = [0 for _ in range(len(arr))]

    # 2.
    def generate(chosen):
        if len(chosen) == r:
            print(*chosen)
            return

        # 3.
        start = arr.index(chosen[-1]) + 1 if chosen else 0
        print(start)
        for nxt in range(start, len(arr)):
            if used[nxt] == 0 and (nxt == 0 or arr[nxt-1] != arr[nxt] or used[nxt-1]):
                chosen.append(arr[nxt])
                used[nxt] = 1
                generate(chosen)
                chosen.pop()
                used[nxt] = 0
    generate([])

while True:
    A = list(map(int, input().split()))

    N = A[0]
    L = A[1:N+1]
    
    if N != 0:
        combination(L, 6)
        print("")
    else:
        exit()