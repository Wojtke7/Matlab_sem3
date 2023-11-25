#include <fcntl.h>
#include <stdio.h>
#include <errno.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <strings.h>
#define BUFFSIZE 10

int errno;

int main(int argc,char *argv[])
{
int descr;
char buff[BUFFSIZE];

	if(argc!=2){
		fprintf(stderr,"Nieprawidlowa liczba argumentow. Poprawna skladnia: %s nazwa_pliku\n",argv[0]);
		return 2;
	}

	descr=open(argv[1],O_RDWR);
	if(descr<0)
	{
		mode_t file_mode = S_IRUSR | S_IWUSR | S_IWGRP | S_IXGRP | S_IWOTH | S_IXOTH;
		descr = open(argv[1], O_CREAT | O_RDWR, file_mode);
	}
	fprintf(stderr,"Plik %s otwarto pomyslnie\n",argv[1]);
	fprintf(stderr,"Oto jego zawartosc.\n----------\n");
	while(read(descr, buff, BUFFSIZE)>0){
	
		printf("%s",buff);
		bzero(buff,BUFFSIZE);
	}
	fprintf(stderr,"----------\n");
	close(descr);
	return 0;
}

