#include <stdio.h>
#include <string.h>

int main()
{
    char str1[300];
    char resultat[30][30];
    int i, j, ctr;

    printf(" Donner la phrase : ");
    fgets(str1, sizeof str1, stdin);

    j = 0;
    ctr = 0;
    for (i = 0; i <= (strlen(str1)); i++)
    {

        if (str1[i] == ' ' || str1[i] == '\0')
        {
            resultat[ctr][j] = '\0';
            ctr++;
            j = 0;
        }
        else
        {
            resultat[ctr][j] = str1[i];
            j++;
        }
    }
    printf("\n Les mots  de cette phrase sont les suivants :\n");
    for (i = 0; i < ctr; i++)
        printf(" %s\n", resultat[i]);

    return 0;
}
