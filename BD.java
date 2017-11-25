import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BD {
	private Evento evento;
	//SGBDConnection(server, database, username, password)
	
	Connection myCon = SGBDConnection.getConnection("localhost", "bdeventos", "root", "123");
	

	public Evento consultaEvento() {

		return null;
	}
	public boolean cadastraEvento(int id, String nome, String descricao, String data, String local, String cpf_cnpj) {
		PreparedStatement stmt = null;
		String sql = "insert into Evento (EVE_ID, EVE_NOME, EVE_DESCRICAO, EVE_DATA, EVE_LOCAL, EVE_CPFCNPJ) values (?, ?, ?, ?, ?, ?)";
		try {
			stmt = myCon.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, nome);
			stmt.setString(3, descricao);
			stmt.setString(4, data);
			stmt.setString(5, local);
			stmt.setString(6, cpf_cnpj);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro na requisicao sql !");
		} finally {
			SGBDConnection.closeConnection(myCon);
		}
		return true;
		
	}
	public boolean removeEvento() {
		return false;
	}
	public boolean alteraEvento() {
		return false;
	}
	public void setEvento(Evento evento){
		this.evento = evento;
	}
	public Evento getEvento(){
		return evento;
	}
}
