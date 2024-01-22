#include <stdio.h>
#include <unistd.h>
#include "sem.h"
#include <sys/types.h>
#include <sys/shm.h>
#include <sys/ipc.h>

int main(){
    int i;
    int j;
    int vs;
    int semid = Tworz(2);
    struct sembuf op_wait_down[2] = { 0,  0, 0,
				    0,  1, 0 };		/*czekaj az ktos podniesie semafor (otworzy) a potem opusc */ 
    struct sembuf	op_up[1] = { 1, -1, 0 };	

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

    if(((long)dane_ptr)==-1){ 
		perror("Blad dolaczenia");
		return 2;
	}



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
                
    while(1){  
        if(semop(semid,op_wait_down,2)<0){
            perror("semop down error");
        }
        else {
                printf("dane: %s \n",dane_ptr->data);
                // printf("A tutaj podlaczony konsument halo! \n");
                P(semid,0);
        }
    }
    
    return 0;
}