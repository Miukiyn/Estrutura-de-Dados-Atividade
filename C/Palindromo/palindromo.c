#include <stdio.h>
#include <string.h>
#include <ctype.h>

int verificaPalindromo(char *string, int inicio, int fim);

int ehPalindromo(char *string) {
    // Remover caracteres nao letras e espacos
    char cleanedString[1000];
    int j = 0;
    for (int i = 0; i < strlen(string); i++) {
        char c = string[i];
        if (isalpha(c) || c == ' ') {
            cleanedString[j++] = c;
        }
    }
    cleanedString[j] = '\0';

    // Verificar se a string e vazia ou contem apenas caracteres alfabeticos
    if (strlen(cleanedString) == 0) {
        return 0; // Nao e palindromo
    }

    // Chame a funcao recursiva para verificar o palindromo
    return verificaPalindromo(cleanedString, 0, strlen(cleanedString) - 1);
}

int verificaPalindromo(char *string, int inicio, int fim) {
    // Caso base: quando o inicio e maior ou igual ao fim, a string e um palindromo
    if (inicio >= fim) {
        return 1; // e palindromo
    }

    // Verificar se os caracteres nas posicoes inicio e fim sao iguais
    if (string[inicio] != string[fim]) {
        return 0; // Nao e palindromo
    }

    // Chamada recursiva para verificar a substring interna
    return verificaPalindromo(string, inicio + 1, fim - 1);
}

int main() {
    char palavra[1000];

    while (1) {
        
        scanf(" %[^\n]", palavra);
        if (strcasecmp(palavra, "FIM") == 0) {
            break;
        }
        printf("%s\n", ehPalindromo(palavra) ? "SIM" : "NAO");
    }

    return 0;
}
