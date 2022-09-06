#include <stdio.h>
#include <stdlib.h>

void dimentionner(char sentence[], char **words)
{

    words = malloc(sizeof(char *) * sizeof(*sentence));

    int i = 0, j = 0, k = 0;
    do
    {
        if (sentence[i] != ' ')
        {
            words[j][k++] = sentence[i];
            printf("%c", words[j][k]);
        }
        else
        {
            words[j++][k] = '\0';
            k = 0;
        }
    } while (sentence[i++] != '\0');
}

void afficher(char **words)
{
}

// int print(char w[NW][NK])
// {
//     printf("\n");
//     for (int i = 0; i < NW; i++)
//     {
//         for (int j = 0; j < NK; j++)
//         {
//             printf("%d ", w[i][j]);
//         }
//         printf("\n");
//     }
// }

int main(void)
{
    //     char sentence[] = "a little step for the man";
    //     char words[6][10];
    //     int i = 0, j = 0, k = 0;
    //     do
    //     {
    //         if (sentence[i] != ' ')
    //             words[j][k++] = sentence[i];
    //         else
    //         {
    //             words[j++][k] = '\0';
    //             k = 0;
    //         }
    //     } while (sentence[i++] != '\0');

    //     for (i = 0; i < 6; i++)
    //         printf("%s\n", words[i]);

    char **res;
    dimentionner("otmane is here", res);
    return 0;
}