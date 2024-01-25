/**
 * 
 * @author Joao , Matilde , Leonor , Carneiro
 * 
 * 
 * esta class é usada para criar pessoas usando nome e idade
 * 
 */

import java.io.Serializable;

public abstract class pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String apelido;
	private int idade;

    public pessoa(String nome, int idade) {
 
    }

    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	
	
	
	public pessoa (String nome, String apelido, int idade)
    {
        this.nome = nome;
        this.apelido = apelido;
        this.idade = idade;
    }
	
	@Override
	public String toString(){
		return "Name: " + this.getNome() + ", Last name: " + this.getApelido() +", Age: " + this.getIdade();
	}

	
}
