//Classes necessárias para uso de Banco de dados //



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;



//Início da classe de conexão//

public class SGBDConnection {
	
  private static String status = "Não conectou...";

  
  //Método Construtor da Classe//

  public SGBDConnection(){
	
  }

  //Método de Conexão//

  
  public static java.sql.Connection getConnection(String _serverName, String _database, String _username, String _password) {
	  
	String serverName = _serverName;
	String database = _database;
	String username = _username;
	String password = _password;
	  
  	Connection connection = null;          //atributo do tipo Connection

    try {
      //setando o Driver jdbc
      Class.forName("com.mysql.jdbc.Driver");

      // Configurando a nossa conexão com um banco de dados//

      String url = "jdbc:mysql://" + serverName + "/" + database;

      connection = DriverManager.getConnection(url, username, password);

      //Testa sua conexão//

      if (connection != null){

        status = ("STATUS--->Conectado com sucesso!");

      }else{

        status = ("STATUS--->Não foi possivel realizar conexão");
      }

      return connection;


    }

    catch (ClassNotFoundException e) {  //Driver não encontrado

      System.out.println("O driver expecificado nao foi encontrado.");

      return null;

    }

    catch (SQLException e) {

      //Não conseguindo se conectar ao banco

      System.out.println("Nao foi possivel conectar ao Banco de Dados.");

      return null;

    }



  }



  //Método que retorna o status da sua conexão//

  public static String getStatus() {

    return status;

  }



  //Método que fecha sua conexão//

  public static boolean closeConnection(Connection myCon) {

    try {
    	if(myCon!=null)
    		myCon.close();

      return true;

    } catch (SQLException e) {

      return false;

    }


  }
}
