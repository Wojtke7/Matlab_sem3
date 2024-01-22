#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[], char *envp[])
{
    int env_index = 0;
    int argv_index = 1;
    int env_size = 0;

    while (envp[env_size] != NULL) {
        env_size++;
    }

    if(argc < 2){ // jeśli nie została podana zadna zmienna środowiskowa, printuj wszystkie
        while(envp[env_index] != NULL){
            printf("%s\n", envp[env_index]);
            env_index++;
        }
    }
    

    else {
        while(envp[env_index] != NULL){ //printuj zmienne, dopoki sa zmienne 
            if (argv_index == argc || env_index == env_size){ //jeśli index argv bedzie rowny ilosci argumentow (zapobiega index out of range w argv[]) lub jesli index zmiennej srodowiskowej bedzie rowny env size to przerwij (bo wtedy null ostatni argument)
                break;
            }
            
            char *variable_name = argv[argv_index];
            char *variable_value = getenv(variable_name);

            if(variable_value != NULL){ //sprawdz czy jest taka zmienna
                char result[512];  // Dostosuj rozmiar bufora do potrzeb
                sprintf(result, "%s=%s", variable_name, variable_value);
                printf("%s\n", result);
                env_index = 0;
                argv_index++;
                continue;
            }

            else if(env_index == env_size - 1){ // sprawdza czy jest taka zmienna i czy nie koniec zmiennych srodowiskowych
                printf("Nie ma zmiennej środowiskowej o nazwie:  %s", argv[argv_index]);
                printf("\n");
                if (argv_index == argc - 1){
                    break;
                }
                
                else{
                    argv_index++;
                    env_index = 0;
                }
            }
            else { // przechodzi do kolejnej zmiennej env
                env_index++;
            }
        }
    }
    return 0;
}

  
