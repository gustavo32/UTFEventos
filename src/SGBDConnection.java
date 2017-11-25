//Classes necessárias para uso de Banco de dados //


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;



//Início da classe de conexão//

public class SGBDConnection {

  public static String status = "Não conectou...";

  //Método Construtor da Classe//

  public SGBDConnection() {

  }

  //Método de Conexão//

  public static java.sql.Connection getSGBDConnection() {

    Connection connection = null;          //atributo do tipo Connection

    try {
      //setando o Driver jdbc
      Class.forName("com.mysql.jdbc.Driver");

      // Configurando a nossa conexão com um banco de dados//

      String serverName = "localhost:3306";    //caminho do servidor do BD

      String mydatabase = "DB_UTFEventos";        //nome do seu banco de dados

      String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

      String username = "root";        //nome de um usuário de seu BD

      String password = "";      //sua senha de acesso

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

  public static boolean fecharConexao() {

    try {

      SGBDConnection.getSGBDConnection().close();

      return true;

    } catch (SQLException e) {

      return false;

    }



  }


  //Método que reinicia sua conexão//

  public static java.sql.Connection reiniciarConexao() {


    fecharConexao();

    return SGBDConnection.getSGBDConnection();

  }

}
