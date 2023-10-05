import java.sql.*;

import bean.*;

public class animalDao {
  private final String URL = "jdbc:mysql://localhost/animal_1";
  private final String USER = "root";
  private final String PASS = "root12345";
  private Connection con = null;

  /* 機　能：DBへの接続を試みる
   * 戻り値：なし
   * 引　数：なし
  */
  public void connect(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(URL, USER, PASS);
    } catch(Exception e){
      e.printStackTrace();
    }
  }

  /* 機　能：生徒の出席番号をもとに名前を検索するSQLをデータベースへ発行する
   * 戻り値：StudentDto
   
  */
  public animalDto select(String type, String animalNo) {
    //Statement stmt = null;

    //ResultSet rs = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    //String result = "no_name";
    animalDto adto = new animalDto();
    String sql = "SELECT * FROM animalType WHERE type=? AND size=?";

    try{
      // DBへ接続するconnectメソッド呼び出し
      connect();
      //ステートメントを生成
      //stmt = con.createStatement();
      ps = con.prepareStatement(sql);
      ps.setString(1, type);
      ps.setString(2, animalNo);
      //SQLを実行
      rs = ps.executeQuery(); //from DB, obtain all the entires on the table.
      //検索結果の処理
      while (rs.next()) {
        animalBean ab = new animalBean();
        ab.setNo(rs.getInt("id"));
        ab.setType(rs.getString("type"));
        ab.setSize(rs.getString("size"));
        ab.setBreed(rs.getString("breed"));
        ab.setName(rs.getString("name"));
        ab.setMemo(rs.getString("memo"));
        adto.add(ab);
      }
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      try{
        if(rs != null) rs.close();
        if(ps != null) ps.close();
      } catch(Exception e){
        e.printStackTrace();
      }
    }
    // DBの接続を切断するdisconnectメソッド呼び出し
    disconnect();
    return adto;
  }

  /* 機　能：DBへの接続を切る
   * 戻り値：なし
   * 引　数：なし
  */
  public void disconnect(){
    try{
      if(con != null) con.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }
}

