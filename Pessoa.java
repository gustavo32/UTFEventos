public abstract class Pessoa {
	private String nome;
	private String email;
	private int telefone;

	public void setNome(String nome){
		this.nome = nome;
	}
	public void setId(String email){
		this.email = email;
	}
	public void setId(int telefone){
		this.telefone = telefone;
	}
	public String getNome(){
		return nome;
	}
	public String getEmail(){
		return email;
	}
	public int getTelefone(){
		return telefone;
	}
}
