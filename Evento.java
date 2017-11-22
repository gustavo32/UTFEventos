public class Evento {
	private int id;
	private String nome;
	private String descricao;
	private String data;
	private String local;
	private Organizador organizador;

	public void setId(int id){
		this.id = id;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	public void setData(String data){
		this.data = data;
	}
	public void setLocal(String local){
		this.local = local;
	}
	public void setOrganizador(String organizador){
		this.organizador = organizador;
	}
	public int getId(){
		return id;
	}
	public String getNome(){
		return nome;
	}
	public String getDescricao(){
		return descricao;
	}
	public String getData(){
		return data;
	}
	public String getLocal(){
		return local;
	}
	public Organizador getOrganizador(){
		return nome;
	}
}
