import java.io.Serializable;


public class membro extends pessoa implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;




    public membro(String nome, String apelido, int idade, double mensal) {
        super(nome, apelido, idade);
        this.mensal = mensal;

    }

    public membro(String nome, String apelido, int idade, double mensal, String aula) {
        super(nome, apelido, idade);
        this.mensal = mensal;
        this.aula = aula;
    }

    public membro(String nome, String apelido, int idade) {
        super(nome, apelido, idade); // Invoke superclass no-arg constructor if necessary

    }

    private double mensal;
    private String aula;

    public double getMensal() {
        return mensal;
    }

    public void setMensal(double mensal) {
        this.mensal = mensal;
    }

    public String getAula(){
        return aula;
    }
    public void setAula(String aula){
        this.aula = aula;
    }





    public String toString() {
        boolean hasAulaParameter = (aula == null); // Check if 'aula' parameter exists
        if (hasAulaParameter){
            return super.toString() + " Mensalidade: " + this.getMensal();
        }else{
            return super.toString() + " Mensalidade: " + this.getMensal() +
                     ", Aula: " + this.aula; // Include 'aula' if it exists
        }

    }

}