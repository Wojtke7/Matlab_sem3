#include <stdio.h>
#include <unistd.h>
#include "sem.h"
#include <stdbool.h>

// count1.c

int main(){
    int i;
    int j;
    int vs;
    int semid = Tworz(2); //utworzenie dwóch semaforów
    struct sembuf	op_wait_down[2] = { 0,  0, 0,
				    0,  1, 0 };		/*czekaj az ktos podniesie semafor (otworzy) a potem opusc */
    struct sembuf	op_wait_down_2[2] = { 1,  0, 0, // Operacja na semaforze o indeksie 1: Czekaj (wait/down) aż semafor będzie równy 0
				    1,  1, 0 }; // Operacja na semaforze o indeksie 1: Zwiększ (up) semafor o 1
    bool second_program = false;
    if (semop(semid, op_wait_down_2, 2) < 0)	{
        perror("semop down error");
    }
    else{
          for(i=1;i<200;i=i+2){
            if(second_program == false){ 
                for(j=0; j<i; j++){
                    printf("%d ",i);
                    fflush(stdout);
                    sleep(1);
                }
                printf("\n");
                second_program = true;
                P(semid,0);
            }
            else { 
                if (semop(semid, op_wait_down, 2) < 0)		/*To jest realizacja funkcji P()*/
		            perror("semop down error");
                else {
                    for(j=0; j<i; j++){
                        printf("%d ",i);
                        fflush(stdout);
                        sleep(1);
                    }
                    printf("\n");
                    P(semid,0);
                }
            }
        	
        }  
    }
    return 0;
}