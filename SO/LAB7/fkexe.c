#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
    pid_t pid1 = fork();

    if(pid1 == 0){
        execl("nowy1","nowy1");
    }

    pid_t pid2 = fork(); 

    if(pid2 == 0){
        execl("nowy2","nowy2");
    }

    int status1,status2;

    waitpid(pid1,&status1,0);
    printf("Process PID: %d Finished, Code Finished: %d, Numer sygnału: %d \n",pid1,WEXITSTATUS(status1),WTERMSIG(status1));
    
    waitpid(pid2,&status2,0);
    printf("Process PID: %d Finished, Code Finished: %d, Numer sygnału: %d \n",pid2,WEXITSTATUS(status2),WTERMSIG(status2));

    return 0;

}