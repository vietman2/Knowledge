// C++로 프로세스 다루기

#include <stdio.h>
#include <unistd.h>

int main() {
    printf("Hello, os!\n");
    printf("My pid is %d\n", getpid());


    // 자식 프로세스 생성해보기
    // fork()는 현재 프로세스를 복제하여 자식 프로세스를 생성한다.
    // fork()의 리턴값이 0이면 자식 프로세스이고, 0이 아니면 부모 프로세스이다.
    printf("parent pid is %d\n", getpid());
    
    if(fork() == 0) {
        printf("child pid is %d\n", getpid());
    }

    return 0;
}