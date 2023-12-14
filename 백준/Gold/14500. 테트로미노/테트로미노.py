N, M = map(int, input().split())
L = [list(map(int,input().split())) for _ in range(N)]
Best = 0

def cal(N,M):
    global Best
    #ㅡ
    for i in range(M-3):
        for j in range(N):
            S = 0
            S = L[j][i] + L[j][i+1] + L[j][i+2] + L[j][i+3]
            if Best <= S:
                Best = S
    #l
    for i in range(M):
        for j in range(N-3):
            S = 0
            S = L[j][i] + L[j+1][i] + L[j+2][i] + L[j+3][i]
            if Best <= S:
                Best = S
    #ㅁ
    for i in range(M-1):
        for j in range(N-1):
            S = 0
            S = L[j][i] + L[j][i+1] + L[j+1][i] + L[j+1][i+1]
            if Best <= S:
                Best = S
    #L
    for i in range(M-1):
        for j in range(N-2):
            S = 0
            S = L[j][i] + L[j+1][i] + L[j+2][i] + L[j+2][i+1]
            if Best <= S:
                Best = S
    #ㄱ
    for i in range(M-2):
        for j in range(N-1):
            S = 0
            S = L[j][i] + L[j][i+1] + L[j][i+2] + L[j+1][i+2]
            if Best <= S:
                Best = S
    #N
    for i in range(M-1):
        for j in range(N-2):
            S = 0
            S = L[j][i] + L[j+1][i] + L[j+1][i+1] + L[j+2][i+1]
            if Best <= S:
                Best = S
    #Z
    for i in range(M-2):
        for j in range(N-1):
            S = 0
            S = L[j][i] + L[j][i+1] + L[j+1][i+1] + L[j+1][i+2]
            if Best <= S:
                Best = S
    #ㅜ
    for i in range(M-2):
        for j in range(N-1):
            S = 0
            S = L[j][i] + L[j][i+1] + L[j][i+2] + L[j+1][i+1]
            if Best <= S:
                Best = S
    #ㅏ
    for i in range(M-1):
        for j in range(N-2):
            S = 0
            S = L[j][i] + L[j+1][i] + L[j+2][i] + L[j+1][i+1]
            if Best <= S:
                Best = S


def rotate90(L, N, M):
    result = [[0 for l in range(N)] for k in range(M)]

    for i in range(M):
        for j in range(N):
            result[i][j] = L[N-j-1][i]
    return result

cal(N,M)
L = rotate90(L,N,M)
cal(M,N)
L = rotate90(L,M,N)
cal(N,M)
L = rotate90(L,N,M)
cal(M,N)

print(Best)