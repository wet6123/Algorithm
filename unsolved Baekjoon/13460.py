#input map & locate things
N, M = map(int, input().split())
Map = []
for i in range(N):
    Map.append([c for c in input()])
    for j in range(M):
        if Map[i][j] == "B":
            Bx = i
            By = j
            Map[i][j] = "."
        if Map[i][j] == "R": 
            Rx = i
            Ry = j
            Map[i][j] = "."
        if Map[i][j] == "O": 
            Ex = i
            Ey = j
            Map[i][j] = "."

#초기화
visited = [[False for _ in range(M)] for _ in range(N)]
Trace = 0

#Trace <= 10 and 

#find way
def find_way(Rx, Ry, Bx, By, Trace):
    visited[Rx][Ry] = True
    if (Rx, Ry) == (Ex, Ey): 
        print (Trace)
        return True
    if Map[Rx][Ry+1] == '.' and visited[Rx][Ry+1] != True and (Bx, By+1) != (Ex, Ey) and (Rx, Ry+1) != (Bx, By+1):
        if find_way(Rx, Ry+1, Bx, By+1, Trace):
            Map[Rx][Ry+1] = "_"
            return True
    if Map[Rx+1][Ry] == '.' and visited[Rx+1][Ry] != True and (Bx+1, By) != (Ex, Ey) and (Rx+1, Ry) != (Bx+1, By):
        if find_way(Rx+1, Ry, Bx+1, By, Trace):
            Map[Rx+1][Ry] = "_"
            return True
    if Map[Rx][Ry-1] == '.' and visited[Rx][Ry-1] != True and (Bx, By-1) != (Ex, Ey) and (Rx, Ry-1) != (Bx, By-1):
        if find_way(Rx, Ry-1, Bx, By-1, Trace):
            Map[Rx][Ry-1] = "_"
            return True
    if Map[Rx-1][Ry] == '.' and visited[Rx-1][Ry] != True and (Bx-1, By) != (Ex, Ey) and (Rx-1, Ry) != (Bx-1, By):
        if find_way(Rx-1, Ry, Bx-1, By, Trace):
            Map[Rx-1][Ry] = "_"
            return True
    return False


success = find_way(Rx, Ry, Bx, By, Trace)

if success:
    for k in Map:
        for l in k:
            if l == '#': 
                print('#', end="")
            elif l == '.':
                print(' ', end="")
            else:
                print(l, end="")
        print()
    print()
else:
    print(-1)