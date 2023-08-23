import java.util.Scanner;

class Booleana {
    // Metodos de Substituicao (A, B, C e espaco)
    public static String substituirA(String s, String valor) {
        s = s.replace("A", valor);
        return s;
    }

    public static String substituirB(String s, String valor) {
        s = s.replace("B", valor);
        return s;
    }

    public static String substituirC(String s, String valor) {
        s = s.replace("C", valor);
        return s;
    }

    public static String removerEspacos(String s) {
        s = s.replace(" ", "");
        return s;
    }

    public static String aplicarNegacao(String s) {
        s = s.replace("not(0)", "1");
        s = s.replace("not(1)", "0");
        return s;
    }

    // Metodo para aplicar a operacao AND em uma string
    public static String andOP(String s) {
        int indiceAnd = s.lastIndexOf("and");
        int parentese = s.indexOf(")", indiceAnd);
        String and = s.substring(indiceAnd, parentese + 1);
    
        int resultado = and.contains("0") ? 0 : 1;
    
        return s.replace(and, String.valueOf(resultado));
    }

    // Metodo para aplicar a operacao OR em uma string
    public static String orOP(String s) {
        int indiceOr = s.lastIndexOf("or");
        int parentese = s.indexOf(")", indiceOr);
        String or = s.substring(indiceOr, parentese + 1);
    
        int resultado = or.contains("1") ? 1 : 0;
    
        return s.replace(or, String.valueOf(resultado));
    }
    

    // Metodo para encontrar a ultima operacao em uma string
    public static String ultimoValorOP(String s) {
        int indiceAnd = s.lastIndexOf("and");
        int indiceOr = s.lastIndexOf("or");
        int indiceNot = s.lastIndexOf("not");
    
        int maiorIndice = Math.max(indiceAnd, Math.max(indiceOr, indiceNot));
    
        return maiorIndice == indiceAnd ? "and" : (maiorIndice == indiceOr ? "or" : "not");
    }
    

    // Metodo pala manipular e subistituir
    public static String subVar(String s, char variavel, String valor) {
        String variavelStr = String.valueOf(variavel);
        s = s.replace(variavelStr, valor);
        return s;
    }

}

public class BooleanaAlg {
    public static void main(String[] args) {
        //Dados
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String resp = " ";
        String result = " ";
        Booleana manipulador = new Booleana();

        num = scanner.nextInt();
        while (true) {
            if (num == 0) {
                break;
            }

            int valores[] = new int[num];

            for (int j = 0; j < num; j++) {
                valores[j] = scanner.nextInt();
            }

            result = scanner.nextLine();
            result = manipulador.removerEspacos(result);

            for (int i = 0; i < num; i++) {
                String valorString = String.valueOf(valores[i]);
                char variavel = (char) ('A' + i);
                result = manipulador.subVar(result, variavel, valorString);
            }

            result = manipulador.aplicarNegacao(result);

            while (result.length() > 1) {
                String ultimaOperacao = manipulador.ultimoValorOP(result);

                switch (ultimaOperacao) {
                    case "not":
                        result = manipulador.aplicarNegacao(result);
                        break;
                    case "and":
                        result = manipulador.andOP(result);
                        break;
                    case "or":
                        result = manipulador.orOP(result);
                        break;
                    default:
                        // Lidar com operacao desconhecida, se necessario
                        break;
                }
            }

            resp = result;
            System.out.println(resp);
            num = scanner.nextInt();
        }
        scanner.close();
    }
}
