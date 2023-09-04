import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Is {

    public static boolean isVogal(String palavra) {
        if (palavra.isEmpty()) {
            return true; // Base case: string vazia eh considerada vogal
        }

        char c = Character.toLowerCase(palavra.charAt(0));
        if (c < 'a' || c > 'z' || "aeiou".indexOf(c) == -1) {
            return false;
        }

        // Chamada recursiva para o restante da string
        return isVogal(palavra.substring(1));
    }

    public static boolean isConsoante(String palavra) {
        if (palavra.isEmpty()) {
            return true; // Base case: string vazia eh considerada consoante
        }

        char c = Character.toLowerCase(palavra.charAt(0));
        if (c < 'a' || c > 'z' || "aeiou".indexOf(c) != -1) {
            return false;
        }

        // Chamada recursiva para o restante da string
        return isConsoante(palavra.substring(1));
    }

    public static boolean isInt(String palavra) {
        if (palavra.isEmpty()) {
            return true; // Base case: string vazia eh considerada um numero inteiro
        }

        char c = palavra.charAt(0);
        if (c < '0' || c > '9') {
            return false;
        }

        // Chamada recursiva para o restante da string
        return isInt(palavra.substring(1));
    }

    public static boolean isReal(String palavra) {
        if (palavra.isEmpty()) {
            return true; // Base case: string vazia eh considerada um numero real
        }

        char c = palavra.charAt(0);
        if ((c < '0' || c > '9') && c != '.') {
            return false;
        }

        // Chamada recursiva para o restante da string
        return isReal(palavra.substring(1));
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String linha;
            while ((linha = reader.readLine()) != null && !linha.equals("FIM")) {
                boolean vogal = isVogal(linha);
                boolean consoante = isConsoante(linha);
                boolean inteiro = isInt(linha);
                boolean real = isReal(linha);

                System.out.println((vogal ? "SIM" : "NAO") + " "
                                 + (consoante ? "SIM" : "NAO") + " "
                                 + (inteiro ? "SIM" : "NAO") + " "
                                 + (real ? "SIM" : "NAO"));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
