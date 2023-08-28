import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

// Classe para facilitar operaçoes de leitura e escrita com diferentes tipos de dados
class UTF {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String charset = "ISO-8859-1";

    public static void setCharset(String newCharset) {
        charset = newCharset;
    }

    // Métodos para leitura de diferentes tipos de dados
    public static String readLine() {
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {
        }
        return s;
    }

    public static String readLine(String text) {
        System.out.print(text);
        return readLine();
    }

    public static int readInt() {
        int i = Integer.parseInt(readLine());
        return i;
    }

    public static double readDouble() {
        double d = Double.parseDouble(readLine());
        return d;
    }

    public static float readFloat() {
        float f = Float.parseFloat(readLine());
        return f;
    }

    public static char readChar() {
        char c = ' ';
        try {
            c = (char) br.read();
        } catch (IOException e) {
        }
        return c;
    }

    public static char readChar(String text) {
        System.out.print(text);
        return readChar();
    }

    public static boolean readBoolean() {
        boolean b = Boolean.parseBoolean(readLine());
        return b;
    }

    // Métodos para impressão de diferentes tipos de dados
    public static void print() {
    }

    public static void print(int i) {
        System.out.print(i);
    }

    public static void print(double d) {
        System.out.print(d);
    }

    public static void print(float f) {
        System.out.print(f);
    }

    public static void print(char c) {
        System.out.print(c);
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void print(boolean b) {
        System.out.print(b);
    }

    public static void println() {
    }

    public static void println(int i) {
        System.out.println(i);
    }

    public static void println(double d) {
        System.out.println(d);
    }

    public static void println(float f) {
        System.out.println(f);
    }

    public static void println(char c) {
        System.out.println(c);
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void println(boolean b) {
        System.out.println(b);
    }
}

public class LerHTML {

    // Funçao para verificar se uma string e igual a "FIM"
    public static boolean isFim(String s) {
        return s.equals("FIM");
    }

    // Funçao para obter o conteudo HTML de um endereço web
    public static String getHtml(String endereco) {
        try {
            URL url = new URL(endereco);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            StringBuilder resp = new StringBuilder();
            String linha;

            while ((linha = br.readLine()) != null) {
                resp.append(linha).append("\n");
            }

            br.close();
            return resp.toString();
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));

        String nome, endereco, html;

        try {
            nome = leitor.readLine();
            endereco = leitor.readLine();
            int[] qtd = new int[2];
            qtd[0] = 0;
            qtd[1] = 1;
            int qtdIndex = 0;

            while (!isFim(nome)) {
                html = getHtml(endereco);

                int[] contagemCaracteres = new int[256];
                // unicode dos caracteres para nao da problema na hora da impressao
                String vogais = "\u0061\u0065\u0069\u006F\u0075\u00E1\u00E9\u00ED\u00F3\u00FA\u00E0\u00E8\u00EC\u00F2\u00F9\u00E3\u00F5\u00E2\u00EA\u00EE\u00F4\u00FB";

                int qtdConsoantes = 0, qtdBR = 0, qtdTABLE = 0;

                for (int i = 0; i < html.length(); i++) {
                    char c = html.charAt(i);
                    
                    if (vogais.indexOf(c) != -1) {
                        contagemCaracteres[c]++;
                    } else if (c >= 'b' && c <= 'z' && c != 'q') {
                        qtdConsoantes++;
                    } else if (c == '<') {
                        int endIndex = i + 7; 
                        if (endIndex <= html.length()) {
                            String tag = html.substring(i + 1, endIndex);
                            if (tag.equalsIgnoreCase("table>")) {
                                qtdTABLE += qtd[qtdIndex];
                                i = endIndex - 1; 
                            }
                        }
                    }
                }

                // Impressao dos resultados
                UTF.print("\u0061(" + contagemCaracteres['\u0061'] + ") ");
                UTF.print("\u0065(" + contagemCaracteres['\u0065'] + ") ");
                UTF.print("\u0069(" + contagemCaracteres['\u0069'] + ") ");
                UTF.print("\u006F(" + contagemCaracteres['\u006F'] + ") ");
                UTF.print("\u0075(" + contagemCaracteres['\u0075'] + ") ");
                UTF.print("\u00E1(" + contagemCaracteres['\u00E1'] + ") ");
                UTF.print("\u00E9(" + contagemCaracteres['\u00E9'] + ") ");
                UTF.print("\u00ED(" + contagemCaracteres['\u00ED'] + ") ");
                UTF.print("\u00F3(" + contagemCaracteres['\u00F3'] + ") ");
                UTF.print("\u00FA(" + contagemCaracteres['\u00FA'] + ") ");
                UTF.print("\u00E0(" + contagemCaracteres['\u00E0'] + ") ");
                UTF.print("\u00E8(" + contagemCaracteres['\u00E8'] + ") ");
                UTF.print("\u00EC(" + contagemCaracteres['\u00EC'] + ") ");
                UTF.print("\u00F2(" + contagemCaracteres['\u00F2'] + ") ");
                UTF.print("\u00F9(" + contagemCaracteres['\u00F9'] + ") ");
                UTF.print("\u00E3(" + contagemCaracteres['\u00E3'] + ") ");
                UTF.print("\u00F5(" + contagemCaracteres['\u00F5'] + ") ");
                UTF.print("\u00E2(" + contagemCaracteres['\u00E2'] + ") ");
                UTF.print("\u00EA(" + contagemCaracteres['\u00EA'] + ") ");
                UTF.print("\u00EE(" + contagemCaracteres['\u00EE'] + ") ");
                UTF.print("\u00F4(" + contagemCaracteres['\u00F4'] + ") ");
                UTF.print("\u00FB(" + contagemCaracteres['\u00FB'] + ") ");

                UTF.print("consoante(" + qtdConsoantes + ") ");
                UTF.print("<br>(" + qtdBR + ") ");
                UTF.print("<table>(" + qtdTABLE + ") ");
                UTF.println(nome);

                qtdIndex = 1 - qtdIndex;
                nome = leitor.readLine();
                endereco = leitor.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}