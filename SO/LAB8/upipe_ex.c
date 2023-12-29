#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    int pipefd[2];
    pipe(pipefd); // Utworzenie potoku

    pid_t cat_pid = fork();

    if (cat_pid == 0) {  // Proces potomny dla "cat /etc/passwd"
        close(pipefd[0]); 

        // Podłączanie końca zapisu potoku do stdout
        dup2(pipefd[1], 1);

        execlp("cat", "cat", "/etc/passwd", NULL);

    } else {  // Proces rodzicielski
        pid_t sort_pid = fork();
        
        if (sort_pid == 0) {  // Proces potomny dla "sort"
            close(pipefd[1]);
            
            // Podłączanie końca odczytu potoku do stdin
            dup2(pipefd[0], 0);

            // Uruchomienie polecenia "sort"
            execlp("sort", "sort", NULL);

        } else {  // Proces rodzicielski
            close(pipefd[0]);
            close(pipefd[1]);

            waitpid(cat_pid, NULL, 0);
            waitpid(sort_pid, NULL, 0);
        }
    }

    return 0;
}
