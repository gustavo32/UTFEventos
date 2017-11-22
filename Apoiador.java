package Diagramas de Classes;

public class Apoiador extends Pessoa {

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

}
