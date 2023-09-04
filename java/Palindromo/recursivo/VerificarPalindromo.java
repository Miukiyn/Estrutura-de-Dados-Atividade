import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerificarPalindromo {

    public static boolean ehPalindromo(String string) {
        // Remover caracteres nao letras e espacos
        StringBuilder cleanedString = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isLetter(c) || c == ' ') {
                cleanedString.append(c);
            }
        }

        // Verificar se a string e vazia ou contem apenas caracteres alfabeticos
        if (cleanedString.length() == 0) {
            return false;
        }

        // Chame a funcao recursiva para verificar o paindromo
        return verificaPalindromo(cleanedString.toString(), 0, cleanedString.length() - 1);
    }

    private static boolean verificaPalindromo(String string, int inicio, int fim) {
        // Caso base: quando o inicio e maior ou igual ao fim, a string e um paindromo
        if (inicio >= fim) {
            return true;
        }

        // Verificar se os caracteres nas posicoes inicio e fim sao iguais
        if (string.charAt(inicio) != string.charAt(fim)) {
            return false;
        }

        // Chamada recursiva para verificar a substring interna
        return verificaPalindromo(string, inicio + 1, fim - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> palavras = new ArrayList<>();

        while (true) {
            String palavra = scanner.nextLine().trim();
            if (palavra.equalsIgnoreCase("FIM")) {
                break;
            }
            palavras.add(palavra);
        }

        List<String> resultados = new ArrayList<>();
        for (String palavra : palavras) {
            resultados.add(ehPalindromo(palavra) ? "SIM" : "NAO");
        }

        for (String resultado : resultados) {
            System.out.println(resultado);
        }

        scanner.close();
    }
}
