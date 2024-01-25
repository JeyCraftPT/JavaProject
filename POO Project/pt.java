import java.io.Serializable;
import java.util.ArrayList; 

public class pt extends pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String especialidade;
	private ArrayList<String> pts;
	
	public pt(String nome, String apelido, int idade, String especialidade){
		super(nome, apelido, idade);
        this.especialidade = especialidade;
        
    }
	
	public String getEspecialidade() {
        return especialidade;
    }
    
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public ArrayList<String> getPts() {
        return pts;
    }

    public void setPts(ArrayList<String> pts) {
        this.pts = pts;
    }

    public void changeEspecialidade(String newEspecialidade) {
        this.especialidade = newEspecialidade;
    }
    
    
    
    @Override
    public String toString() {
    	return "O nome do pt é " + getNome() + " o apelido dele é "+ getApelido() +" ele tem " + getIdade() + " anos e a sua especialidade é " + especialidade;
    }
}
