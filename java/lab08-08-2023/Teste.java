class Pessoa{
    //Atributos
    public String nome;
    protected String email;
    private String telefone;

    //Constutor
    public Pessoa (String nome){
        this.nome = nome;
    }
    //getters and setters

    public void setnome(String nome){
        this.nome = nome;
    }

    public  String getnome(){
        return this.nome;
    }

    public void  setemail(String email){
        this.email = email;
    }

    public String getemail(){
        return this.email;
    }

}

class Aluno extends Pessoa {
    private String mat;

    public Aluno (String mat, String nome){
        super(nome);
        this.mat = mat;
    }
}


public class Teste{
    public static void main(String args[]){
        //Aluno a;
        Pessoa p;

       // a = new Aluno("1234", "Suzane");
        p = new Pessoa("joao");
        p.setemail("joao@gmail.com");
    }
}