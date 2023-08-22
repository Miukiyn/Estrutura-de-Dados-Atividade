#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

bool ehPalindromo(char string[]) {
    // Remover caracteres não letras e espaços
    char cleanedString[1000];
    int j = 0;
    for (int i = 0; i < strlen(string); i++) {
        char c = string[i];
        if (isalpha(c) || c == ' ') {
            cleanedString[j++] = c;
        }
    }
    cleanedString[j] = '\0';

    // Verificar se a string é vazia ou contém apenas caracteres alfabéticos
    if (strlen(cleanedString) == 0) {
        return false;
    }

    // Verificar se a string é igual à sua forma invertida
    char reversedString[1000];
    j = 0;
    for (int i = strlen(cleanedString) - 1; i >= 0; i--) {
        reversedString[j++] = cleanedString[i];
    }
    reversedString[j] = '\0';

    return strcmp(cleanedString, reversedString) == 0;
}

int main() {
    char palavra[1000];
    char palavras[1000][1000];
    int count = 0;

    //printf("Digite as palavras (digite FIM para encerrar):\n");
    while (1) {
        fgets(palavra, sizeof(palavra), stdin);
        palavra[strcspn(palavra, "\n")] = '\0'; // Remover a quebra de linha

        if (strcasecmp(palavra, "FIM") == 0) {
            break;
        }
        strcpy(palavras[count], palavra);
        count++;
    }

    char resultados[1000][4];
    for (int i = 0; i < count; i++) {
        strcpy(resultados[i], ehPalindromo(palavras[i]) ? "SIM" : "NAO");
    }

    //printf("Resultados:\n");
    for (int i = 0; i < count; i++) {
        printf("%s\n", resultados[i]);
    }

    return 0;
}
