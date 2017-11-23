public class Test{

  public static void main(String[] args){
    SGBDConnection con = new SGBDConnection();

    con.getSGBDConnection();
    System.out.println(con.getStatus());

  }
}
