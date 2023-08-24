import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Is {

    public static boolean isVogal(String palavra) {
        for (int i = 0; i < palavra.length(); i++) {
            char c = Character.toLowerCase(palavra.charAt(i));
            if (c < 'a' || c > 'z' || "aeiou".indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isConsoante(String palavra) {
        for (int i = 0; i < palavra.length(); i++) {
            char c = Character.toLowerCase(palavra.charAt(i));
            if (c < 'a' || c > 'z' || "aeiou".indexOf(c) != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInt(String palavra) {
        try {
            Integer.parseInt(palavra);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isReal(String palavra) {
        try {
            Double.parseDouble(palavra);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
