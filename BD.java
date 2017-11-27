import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class BD {
	//SGBDConnection(server, database, username, password)
	private Evento e;
	private Organizador o;
	
	public boolean cadastraOrganizador(Organizador o) {
		Connection myCon = SGBDConnection.getConnection("localhost", "bdeventos", "root", "123");
		PreparedStatement stmt = null;
		String sql = "insert into Organizador (ORG_CPFCNPJ, ORG_NOME, ORG_EMAIL, ORG_TELEFONE) values (?, ?, ?, ?);";
		try {
			stmt = myCon.prepareStatement(sql);
			stmt.setInt(1, o.getCpf_cnpj());
			stmt.setString(2, o.getNome());
			stmt.setString(3, o.getEmail());
			stmt.setInt(4, o.getTelefone());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException z) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar !", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			SGBDConnection.closeConnection(myCon);
		}
		return true;

	}

	public boolean removeOrganizador(Organizador o) {
		Connection myCon = SGBDConnection.getConnection("localhost", "bdeventos", "root", "123");
		PreparedStatement stmt = null;
		String sql = "delete from Organizador where EVE_ID = (?);";
		try {
			stmt = myCon.prepareStatement(sql);
			stmt.setInt(1, o.getCpf_cnpj());

			stmt.executeUpdate();
			stmt.close();
		}catch(SQLException z) {
			JOptionPane.showMessageDialog(null, "Erro ao remover !", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			SGBDConnection.closeConnection(myCon);
		}

		return true;
	}

	public boolean alteraOrganizador(Organizador o) {
		Connection myCon = SGBDConnection.getConnection("localhost", "bdeventos", "root", "123");
		PreparedStatement stmt = null;
		String sql = "update Organizador set EVE_NOME=(?), EVE_DESCRICAO=(?), EVE_DATA=(?), EVE_LOCAL=(?), EVE_CPFCNPJ=(?) where EVE_ID=(?);";
		try {
			stmt = myCon.prepareStatement(sql);
			stmt.setInt(1, o.getCpf_cnpj());
			stmt.setString(2, o.getNome());
			stmt.setString(3, o.getEmail());
			stmt.setInt(4, o.getTelefone());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException z) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar !", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			SGBDConnection.closeConnection(myCon);
		}
		return true;

	}
	public void setOrganizador(Organizador organizador){
		this.o = organizador;
	}
	public Organizador getOrganizador(){
		return o;
	}
	
	public Organizador consultaOrganizador(int id) {
		Connection myCon = SGBDConnection.getConnection("localhost", "bdeventos", "root", "123");
		Organizador org = new Organizador();
		PreparedStatement stmt = null;
		String sql = "select * from Organizador where ORG_CPFCNPJ=(?);";
		ResultSet rs = null;
		try {
			stmt = myCon.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				org.setCpf_cnpj(rs.getInt("ORG_CPFCNPJ"));
				org.setNome(rs.getString("ORG_NOME"));
				org.setEmail(rs.getString("ORG_EMAIL"));
				org.setTelefone(rs.getInt("ORG_TELEFONE"));
			}	
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Organizador nao existe !", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		} finally {
			SGBDConnection.closeConnection(myCon);
		}
		//System.out.println(org.getCpf_cnpj()+"+"+org.getEmail()+"+"+org.getNome()+"+"+org.getTelefone());
		return org;
	}
	
	public Evento consultaEvento(int id) {
		Connection myCon = SGBDConnection.getConnection("localhost", "bdeventos", "root", "123");
		Organizador org = new Organizador();
		PreparedStatement stmt = null;
		String sql = "select * from Evento where EVE_ID=(?);";

		ResultSet rs = null;
		try {
			stmt = myCon.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				org = consultaOrganizador(rs.getInt("FK_ORG_CPFCNPJ"));
				e = new Evento(rs.getInt("EVE_ID"), rs.getString("EVE_NOME"), rs.getString("EVE_DESCRICAO"), rs.getString("EVE_DATA"), rs.getString("EVE_LOCAL"), org);
			}
			stmt.close();
		}catch(SQLException z) {
			JOptionPane.showMessageDialog(null, "Não foi possível encontrar o ID !", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		} finally {
			SGBDConnection.closeConnection(myCon);
		}
		
		return e;
	}
	public boolean cadastraEvento(Evento e) {
		Connection myCon = SGBDConnection.getConnection("localhost", "bdeventos", "root", "123");
		PreparedStatement stmt = null;
		String sql = "insert into Evento (EVE_ID, EVE_NOME, EVE_DESCRICAO, EVE_DATA, EVE_LOCAL, FK_ORG_CPFCNPJ) values (?, ?, ?, ?, ?, ?);";
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
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso !", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException z) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar !", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			SGBDConnection.closeConnection(myCon);
		}
		return true;
		
	}
	
	public boolean removeEvento(Evento e) {
		Connection myCon = SGBDConnection.getConnection("localhost", "bdeventos", "root", "123");
		PreparedStatement stmt = null;
		String sql = "delete from Evento where EVE_ID = (?);";
		try {
			stmt = myCon.prepareStatement(sql);
			stmt.setInt(1, e.getId());
			
			stmt.executeUpdate();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso !", "Remoção", JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException z) {
			JOptionPane.showMessageDialog(null, "Erro ao remover !", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			SGBDConnection.closeConnection(myCon);
		}

		return true;
	}
	
	public boolean alteraEvento(Evento e) {
		Connection myCon = SGBDConnection.getConnection("localhost", "bdeventos", "root", "123");
		PreparedStatement stmt = null;
		String sql = "update Evento set EVE_NOME=(?), EVE_DESCRICAO=(?), EVE_DATA=(?), EVE_LOCAL=(?), EVE_CPFCNPJ=(?) where EVE_ID=(?);";
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
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso !", "Alterar", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException z) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar !", "Erro", JOptionPane.ERROR_MESSAGE);
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
