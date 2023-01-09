#include <stdio.h>
int main(void){
    int ans = 0;
    int cnt = 0;
    int out, in;
    for(int i = 0; i < 10; i++){
        scanf("%d", &out);
        scanf("%d", &in);
        cnt += in - out;
        if(ans < cnt){
            ans = cnt;
        }
    }
    printf("%d", ans);
}