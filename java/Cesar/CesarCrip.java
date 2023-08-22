import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

//class Cesar
class Cesar{
    //atributos
    private int chave = 0;

    //contrutor
    public Cesar(int chave){
        this.chave = chave;
    }

    //gets and sets
    public int getChave(){
        return chave;
    }
    
    public void setChave(int chave){
        this.chave = chave;
    }

    //cripitografagem
    public String criptografar(String palavra) {
        String world = palavra;
        int offset = this.chave;


        //tranformar a palvra em array de caracteres
        char[] charArray = world.toCharArray();

        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] != '\uFFFD'){
                int nextCrip = (int) charArray[i] + offset;
                char nextLetter = (char) nextCrip;
                charArray[i] = nextLetter;
            }else{
                charArray[i] = '\uFFFD';
            }
        }

        //String resultado = Arrays.toString(charArray);
        String resultado = new String(charArray);
        
        return resultado;
    }
}



//Class principal
public class CesarCrip{
    public static void main(String[] args){
        //Dados
        String[] criptografia = new String[1];
        //int espandir = 1;

        //criando uma chave para classe Chave
        Cesar chave = new Cesar (3);

        //Entrada da palvra
        Scanner scanner = new Scanner(System.in);
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(reader);

        //int chavecesar = chave.getChave();
        //System.out.println(chavecesar);

        //dados de leitura
        for(int i = 0; i < criptografia.length; i++){
            try{
                String palavra = bufferedReader.readLine();
            
                criptografia[i] = palavra;

                if(!palavra.equals("FIM")){
                    int novoTamanho = criptografia.length + 1;
                    String[] criptografiaArray = new String[novoTamanho];

                    for(int j = 0; j < criptografia.length; j++){
                        criptografiaArray[j] = criptografia[j];
                    }

                    criptografiaArray[novoTamanho - 1] = criptografia[i];

                    //Atualizar as referencias do arrays
                    criptografia = criptografiaArray;

                    String novaPalvra = chave.criptografar(criptografia[i]);

                    criptografia[i] = novaPalvra;
                    
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            


        }

        /*
        int j = 0;
        
        do{
            
            //criptografar
            String novaPalvra = chave.criptografar(criptografia[j]);

            //Adicionar a palavra criptografada no array
            if(!novaPalvra.equals("FIM")){
                int novoTamanho = criptografia.length + 1;
                String[] criptografiaArray = new String[novoTamanho];

                for(int i = 0; i < criptografia.length; i++){
                    criptografiaArray[i] = criptografia[i];
                }

                criptografiaArray[novoTamanho - 1] = criptografia[j];

                //Atualizar as referencias do arrays
                criptografia = criptografiaArray;
                j = j + 1;
            }
            

            

        }while(!criptografia[j].equals("FIM"));
        
        */

        for(String palavra : criptografia){
            if(!palavra.equals("FIM")){
                System.out.println(palavra);
            }
        }
        


    }
}