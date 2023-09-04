import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

class Cesar {
    private int chave = 0;

    public Cesar(int chave) {
        this.chave = chave;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public String criptografar(String palavra) {
        int offset = this.chave;
        char[] charArray = palavra.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '\uFFFD') {
                int nextCrip = (int) charArray[i] + offset;
                char nextLetter = (char) nextCrip;
                charArray[i] = nextLetter;
            } else {
                charArray[i] = '\uFFFD';
            }
        }

        return new String(charArray);
    }
}

public class CesarCrip {
    public static void main(String[] args) {
        // Dados
        String[] criptografia = new String[1];
        Cesar chave = new Cesar(3);

        // Entrada de palavras
        Scanner scanner = new Scanner(System.in);
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(reader);

        // Leitura de palavras
        int indice = 0;
        while (true) {
            try {
                String palavra = bufferedReader.readLine();

                criptografia[indice] = palavra;

                if (!palavra.equals("FIM")) {
                    int novoTamanho = criptografia.length + 1;
                    String[] criptografiaArray = new String[novoTamanho];

                    for (int j = 0; j < criptografia.length; j++) {
                        criptografiaArray[j] = criptografia[j];
                    }

                    criptografiaArray[novoTamanho - 1] = criptografia[indice];

                    // Atualizar as referencias do array
                    criptografia = criptografiaArray;

                    String novaPalavra = chave.criptografar(criptografia[indice]);
                    criptografia[indice] = novaPalavra;
                } else {
                    break;
                }
                indice++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (String palavra : criptografia) {
            if (!palavra.equals("FIM")) {
                System.out.println(palavra);
            }
        }
    }
}
