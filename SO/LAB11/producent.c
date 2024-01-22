#include <sys/types.h>
#include <sys/shm.h>
#include "sem.h"
#include <sys/ipc.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <unistd.h>

int main(){
    int i;
    int j;
    int vs;
    int semid = Tworz(2);
    struct sembuf	op_wait_down[2] = { 0,  0, 0,
				    0,  1, 0 };		/*czekaj az ktos podniesie semafor (otworzy) a potem opusc */
    struct sembuf	op_wait_down_2[2] = { 1,  0, 0,
				    1,  1, 0 };


    int shmID;
				/* taka bedzie struktura danych segmentu */
	struct Dane { 
        int id;
		char data[100];
	} *dane_ptr;
	
	key_t klucz;
	klucz = ftok(".",'K');

    shmID=shmget(klucz,sizeof(struct Dane),IPC_CREAT | SHM_R  | SHM_W  | SHM_R >> 3);


	if(shmID == -1){
		perror("Blad utworzenia pamieci wspoldzielonej");
		return 1;
	}

    dane_ptr = (struct Dane *) shmat(shmID, 0, 0);


    bool second_program = false;    
    if (semop(semid, op_wait_down_2, 2) < 0)	{
        perror("semop down error");
    }
    else{
        while(1){
            if(second_program == false){ 
                printf("Podlaczeni producent! \n");
                second_program = true;
                P(semid,0);
            }
            else { 
                    if (semop(semid, op_wait_down, 2) < 0)		/*To jest realizacja funkcji P()*/
                        perror("semop down error");
                    else {
                            printf("podaj message: "); 
                            scanf("%s",dane_ptr->data);
                            P(semid,0);
                    }
            }    
        }
    }
    return 0;
}