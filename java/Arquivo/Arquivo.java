import java.io.*;
import java.nio.charset.StandardCharsets;

public class Arquivo {

    // Metodo para saber se a entrada eh igual a FIM
    public static boolean fimBoolean(String palavra) {
        return palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I'
                && palavra.charAt(2) == 'M';
    }

    // Metodo de escrever no arquivo e imprimir de tras para frente os dados
    public static void writeArq() throws IOException {
        OutputStream file = new FileOutputStream("Arquivo.txt");
        Writer escrever = new OutputStreamWriter(file);
        BufferedWriter bw = new BufferedWriter(escrever);
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(reader);

        int n = Integer.parseInt(bufferedReader.readLine()); // Transforma a primeira entrada em um inteiro

        for (int j = 0; j < n; j++) {
            double db = Double.parseDouble(bufferedReader.readLine());
            double fracao = db - (int) db;

            if (fracao == 0) {
                int inteiro = (int) db; // Parte inteira do numero
                String intString = Integer.toString(inteiro);
                bw.write(intString);
            } else {
                String dbString = Double.toString(db);
                bw.write(dbString);
            }

            bw.newLine();
        }

        bw.close();

        // Abrir arquivo para leitura
        RandomAccessFile fileRead = new RandomAccessFile("Arquivo.txt", "r");

        // Obtem o tamanho do arquivo
        long fileSize = fileRead.length();

        long currentPosition = fileSize - 1;

        // Le o arquivo de tras para frente, linha por linha
        while (currentPosition > 0) {
            // Retrocede o ponteiro para a posicao atual
            fileRead.seek(currentPosition - 1);

            // Le o caractere atual
            char currentChar = (char) fileRead.readByte();

            if (currentChar == '\n') {
                // Retrocede para o inicio da linha e le a linha
                fileRead.seek(currentPosition);
                String line = fileRead.readLine();
                System.out.println(line);
            }

            currentPosition--;
        }

        // Le a primeira linha, se houver
        if (fileSize > 0) {
            fileRead.seek(0);
            String firstLine = fileRead.readLine();
            System.out.println(firstLine);
        }
    }

    public static void main(String[] args) throws IOException {

        writeArq();

    }
}
