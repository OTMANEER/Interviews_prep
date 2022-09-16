#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include <sys/stat.h>

FILE *create_file(const char *fileName)
{
    time_t t;

    srand(time(NULL));
    int randMotDePasse = rand() % 1000000;
    FILE *monFichier = NULL;
    monFichier = fopen(fileName, "wt");
    if (monFichier)
    {
        fprintf(monFichier, "%s\n\t%s%s%s\n\t%s%s%s\n\t%s%s%s\n\t%s%d%s\n%s", "<usager>", "<jour>", "16/09/2022", "</jour>", "<nom>", "ZIACH", "</nom>", "<uid>", "381923", "</uid>", "<mot-passe>", randMotDePasse, "</mot-passe>", "</usager>");
        chmod(fileName, S_IRUSR);
        return monFichier;
    }

    return NULL;
}

main(void)
{
    FILE *p_txt = create_file("myFile.xml");
    if (p_txt == NULL)
    {
        printf("error with file");
        getchar();
        exit(1); // quit
    }

    return 0;
}