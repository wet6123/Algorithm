#include <stdio.h>
#include <math.h>

int main(void){
    int A, B, V;
    scanf("%d", &A);
    scanf("%d", &B);
    scanf("%d", &V);
    int ans = ceil((double)(V-B)/(A-B));
    printf("%d", ans);
}