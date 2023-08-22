import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CharRandomAlt {

    public static void main(String[] args) {
        int countArray = 1;
        char[] randomChar = new char[2];

        // Metodos de Leitura Usuario
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String[] memoria = new String[1];

        Random gerador = new Random();
        gerador.setSeed(4);

        // Metodo de Entrada da Leitura Usuario
        try {
            String palavra = bufferedReader.readLine();
            int k = 0;
            
            // gerar uma semente para o geramento aleatorio de caracter
            
            

            while (!palavra.equals("FIM")) {

                char[] palavraCharArray = palavra.toCharArray();
                // gerar caracter aleatorio e colocar no array
                // System.out.println((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
                randomChar[0] = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
                // System.out.println((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
                randomChar[1] = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
                

                for (int i = 0; i < palavraCharArray.length; i++) {

                    if (palavraCharArray[i] == randomChar[0]) {
                        palavraCharArray[i] = randomChar[1];

                    }

                }
                
                String resultado = new String(palavraCharArray);
                
                /*
                System.out.println(resultado);
                System.out.println("[0] : " + randomChar[0]);
                System.out.println("[1] : " + randomChar[1]);
                System.out.println();
                */
                
                memoria[k] = resultado;

                int novoTamanho = memoria.length + 1;

                String[] novoArray = new String[novoTamanho];

                for (int i = 0; i < memoria.length; i++) {
                    novoArray[i] = memoria[i];
                }

                novoArray[novoTamanho - 1] = memoria[k];

                memoria = novoArray;
                countArray = countArray + 1;

                // count = count + 1;
                // System.out.println(count + " : " + palavra);

                k = k + 1;
                palavra = bufferedReader.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (memoria.length > 0) {
            String[] novoArrayCopy = new String[memoria.length - 1];
            System.arraycopy(memoria, 0, novoArrayCopy, 0, memoria.length - 1);
            memoria = novoArrayCopy;
        }

        for (String palavra : memoria) {
            System.out.println(palavra);
        }

    }
}
