#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Funcao para escrever no arquivo e imprimir de tras para frente os dados
void writeArq()
{
    FILE *file = fopen("Arquivo.txt", "w");
    if (file == NULL)
    {
        printf("Erro ao abrir o arquivo para escrita.\n");
        exit(1);
    }

    int n;
    scanf("%d", &n);

    for (int j = 0; j < n; j++)
    {
        double db;
        scanf("%lf", &db);
        double fracao = db - (int)db;

        if (fracao == 0)
        {
            int inteiro = (int)db;
            fprintf(file, "%d\n", inteiro);
        }
        else
        {
            char dbString[20];
            snprintf(dbString, sizeof(dbString), "%.3lf", db);
            int len = strlen(dbString);

            // Remover zeros extras apos a primeira casa decimal
            if (dbString[len - 1] == '0')
            {
                for (int i = len - 1; i >= 2; i--)
                {
                    if (dbString[i] == '.')
                    {
                        break;
                    }
                    if (dbString[i] == '0')
                    {
                        dbString[i] = '\0';
                    }
                    else
                    {
                        break;
                    }
                }
            }

            fprintf(file, "%s\n", dbString);
        }
    }

    fclose(file);

    // Abrir arquivo para leitura
    FILE *fileRead = fopen("Arquivo.txt", "r");
    if (fileRead == NULL)
    {
        printf("Erro ao abrir o arquivo para leitura.\n");
        exit(1);
    }

    // Obter o tamanho do arquivo
    fseek(fileRead, 0, SEEK_END);
    long fileSize = ftell(fileRead);

    long currentPosition = fileSize - 1;

    // Ler o arquivo de tras para frente, linha por linha
    while (currentPosition > 0)
    {
        // Retroceder o ponteiro para a posicao atual
        fseek(fileRead, currentPosition - 1, SEEK_SET);

        // Ler o caractere atual
        char currentChar = fgetc(fileRead);

        if (currentChar == '\n')
        {
            // Retroceder para o inicio da linha e ler a linha
            fseek(fileRead, currentPosition, SEEK_SET);
            char line[1000];
            fgets(line, sizeof(line), fileRead);

            // Verificar se a linha é vazia
            if (strlen(line) > 1)
            {
                printf("%s", line);
            }
        }

        currentPosition--;
    }
    // Ler a primeira linha, se houver
    if (fileSize > 0)
    {
        fseek(fileRead, 0, SEEK_SET);
        char firstLine[1000];
        fgets(firstLine, sizeof(firstLine), fileRead);
        printf("%s", firstLine);
    }

    fclose(fileRead);
}

int main()
{
    writeArq();
    return 0;
}
