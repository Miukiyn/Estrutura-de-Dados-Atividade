#include <stdio.h>

void lerNumero() {
    int numero;

    //printf("Digite um numero: ");
    scanf("%d", &numero);

    if (numero % 2 == 0) {
        printf("par");
    } else {
        printf("impar");
    }
}

int main() {
    lerNumero(); // Chamando a função lerNumero() dentro do escopo do main

    return 0;
}
