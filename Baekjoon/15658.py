def cal(idx, res) :
    global max, min

    if idx == N:
        if max < res: max = res
        if min > res: min = res
        return

    for i in range(4):
        if OP[i] > 0:
            if i == 0:sum = res + L[idx]
            elif i == 1:sum = res - L[idx]
            elif i == 2:sum = res * L[idx]
            else:
                if res < 0:
                    sum = -res // L[idx]
                    sum = -sum
                else :
                    sum = res//L[idx]

            OP[i] -= 1
            cal(idx+1, sum)
            OP[i] += 1

#main
N = int(input())
L = list(map(int, input().split()))
OP = list(map(int, input().split()))

max = float("-inf")
min = float("inf")

cal(1, L[0])

print(max, min, sep="\n")