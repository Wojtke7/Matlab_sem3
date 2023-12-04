#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

void signal_handler(int signum) {
    printf("Nowy1 Signal: %d\n", signum);
    exit(signum);
}
 
int main(){
    signal(SIGINT,signal_handler);
    signal(SIGTERM,signal_handler);

    printf("Process nowy1: Started \n");
    sleep(20);
    printf("Process nowy1: finished \n");

    return 0;
}