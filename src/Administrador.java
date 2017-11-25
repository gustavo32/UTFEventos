public class Administrador extends Pessoa {
	private int id;

	public boolean solicitarCadastro() {
		return false;
	}
	public boolean solicitarAlteracao() {
		return false;
	}
	public boolean solicitarRemocao() {
		return false;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
}
