import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class BD {
	//SGBDConnection(server, database, username, password)
	private Evento e;
	Connection myCon = SGBDConnection.getConnection("localhost", "bdeventos", "root", "123");
	
	public Organizador consultaOrganizador(int id) {
		Organizador org = new Organizador();
		PreparedStatement stmt = null;
		String sql = "select * from Organizador where ORG_CPFCNPJ=(?)";
		ResultSet rs = null;
		try {
			stmt = myCon.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			org.setCpf_cnpj(rs.getInt("ORG_CPFCNPJ"));
			org.setEmail(rs.getString("ORG_EMAIL"));
			org.setNome(rs.getString("ORG_NOME"));
			org.setTelefone(rs.getInt("ORG_TELEFONE"));
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro", "Organizador nao existe !", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return org;
	}
	
	public Evento consultaEvento(int id) {
		Organizador org = new Organizador();
		PreparedStatement stmt = null;
		String sql = "select * from Evento where EVE_ID=(?)";

		ResultSet rs = null;
		try {
			stmt = myCon.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			org = consultaOrganizador(rs.getInt("FK_ORG_CPFCNPJ"));
			
			e = new Evento(rs.getInt("EVE_INT"), rs.getString("EVE_NOME"), rs.getString("EVE_DESCRICAO"), rs.getString("EVE_DATA"), rs.getString("EVE_LOCAL"), org);
			
			stmt.close();
		}catch(SQLException z) {
			System.out.println("Nao foi possivel encontrar o ID");
			return null;
		}
		SGBDConnection.closeConnection(myCon);
		return e;
	}
	public boolean cadastraEvento(Evento e) {
		PreparedStatement stmt = null;
		String sql = "insert into Evento (EVE_ID, EVE_NOME, EVE_DESCRICAO, EVE_DATA, EVE_LOCAL, EVE_CPFCNPJ) values (?, ?, ?, ?, ?, ?)";
		try {
			stmt = myCon.prepareStatement(sql);
			stmt.setInt(1, e.getId());
			stmt.setString(2, e.getNome());
			stmt.setString(3, e.getDescricao());
			stmt.setString(4, e.getData());
			stmt.setString(5, e.getLocal());
			stmt.setInt(6, e.getOrganizador().getCpf_cnpj());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException z) {
			System.out.println("Erro na requisicao sql !");
			return false;
		} finally {
			SGBDConnection.closeConnection(myCon);
		}
		return true;
		
	}
	
	public boolean removeEvento(Evento e) {
		PreparedStatement stmt = null;
		String sql = "delete from Evento where EVE_ID = (?)";
		try {
			stmt = myCon.prepareStatement(sql);
			stmt.setInt(1, e.getId());
			
			stmt.executeUpdate();
			stmt.close();
		}catch(SQLException z) {
			System.out.println("Erro na requisicao sql !");
			return false;
		}
		SGBDConnection.closeConnection(myCon);
		return true;
	}
	
	public boolean alteraEvento(Evento e) {
		
		PreparedStatement stmt = null;
		String sql = "update Evento set EVE_NOME=(?), EVE_DESCRICAO=(?), EVE_DATA=(?), EVE_LOCAL=(?), EVE_CPFCNPJ=(?) where EVE_ID=(?)";
		try {
			stmt = myCon.prepareStatement(sql);
			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getDescricao());
			stmt.setString(3, e.getData());
			stmt.setString(4, e.getLocal());
			stmt.setInt(5, e.getOrganizador().getCpf_cnpj());
			stmt.setInt(6, e.getId());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException z) {
			System.out.println("Erro na requisicao sql !");
			return false;
		} finally {
			SGBDConnection.closeConnection(myCon);
		}
		return true;
		
	}
	public void setEvento(Evento evento){
		this.e = evento;
	}
	public Evento getEvento(){
		return e;
	}
}
