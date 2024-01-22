#include <stdio.h>
#include <unistd.h>
#include "sem.h"

//count2.c

int main(){
    int i; 
    int j;
    int vs;
    int semid = Tworz(2);
    struct sembuf op_wait_down[2] = { 0,  0, 0,
				    0,  1, 0 };		/*czekaj az ktos podniesie semafor (otworzy) a potem opusc */ 
    struct sembuf	op_up[1] = { 1, -1, 0 };	
    // int value = semop(semid,&sops,1); 
    // printf("%d, \n",value);
    if ((vs=semctl(semid, 1, GETVAL, arg)) < 0)
        perror("semctl error:");

    switch(vs) { 
        case 1: { // opuszczony 
            if(semop(semid,op_up,1) < 0){
                perror("semop up error:");
            }
            else {
                printf("Podnioslem\n");
            }
            break;  
        }
        case 0: {
            exit(0);
        }
    }
                
    for(i=2;i<200;i=i+2){
        if(semop(semid,op_wait_down,2)<0){
            perror("semop down error");
        }
        else {
            for(j=0;j<i;j++){
                printf("%d ",i);
                fflush(stdout);
                sleep(1);
            }
            printf("\n");
            P(semid,0);
        }
    
    }
    return 0;
}