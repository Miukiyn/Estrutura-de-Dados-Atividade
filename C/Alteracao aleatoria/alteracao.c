#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int main() {
    int countArray = 1;
    char randomChar[2];

    // Métodos de Leitura do Usuário
    char palavra[100];
    
    srand(4); // Definir a semente para o gerador aleatório

    // Método de Entrada da Leitura do Usuário
    while (1) {
        if (fgets(palavra, sizeof(palavra), stdin) == NULL || strcmp(palavra, "FIM\n") == 0) {
            break;
        }
        
        char resultado[100];

        // Gerar caracteres aleatórios e colocá-los no array
        randomChar[0] = 'a' + (rand() % 26);
        randomChar[1] = 'a' + (rand() % 26);

        int palavraLength = strlen(palavra);
        for (int i = 0; i < palavraLength; i++) {
            if (palavra[i] == randomChar[0]) {
                resultado[i] = randomChar[1];
            } else {
                resultado[i] = palavra[i];
            }
        }

        resultado[palavraLength] = '\0';

        // Imprimir o resultado
        printf("%s", resultado);
    }

    return 0;
}
