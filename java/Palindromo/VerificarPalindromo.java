import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerificarPalindromo {

    public static boolean ehPalindromo(String string) {
        // Remover caracteres não letras e espaços
        StringBuilder cleanedString = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isLetter(c) || c == ' ') {
                cleanedString.append(c);
            }
        }

        // Verificar se a string é vazia ou contém apenas caracteres alfabéticos
        if (cleanedString.length() == 0) {
            return false;
        }

        // Verificar se a string é igual à sua forma invertida
        return cleanedString.toString().equals(cleanedString.reverse().toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> palavras = new ArrayList<>();

        //System.out.println("Digite as palavras (digite FIM para encerrar):");
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

        //System.out.println("Resultados:");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }

        scanner.close();
    }
}
