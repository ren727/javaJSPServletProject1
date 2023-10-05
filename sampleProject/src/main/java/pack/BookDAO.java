package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO{
	private String URL = "jdbc:mysql://localhost/animal_1";
	private String USER = "root";
	private String PASS = "root12345";
	Connection con = null;

	/*
	 * DB接続
	 * */
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 新規投稿機能
	 * */
	public void createFavoriteBook(String type, String size, String breed, String name, String memo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
			pstmt = con.prepareStatement("insert into animalType(type, size, breed, name, memo) values(?, ?, ?, ?, ?)");

			pstmt.setString(1, type);
			pstmt.setString(2, size);
			pstmt.setString(3, breed);
			pstmt.setString(4, name);
			pstmt.setString(5, memo);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * DB情報(id, name)取得
	 * */
	public List<User> readUsers() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> bookList = new ArrayList<User>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
			pstmt = con.prepareStatement("select id, type, size, breed, name, memo from animalType");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setType(rs.getString("type"));
				user.setSize(rs.getString("size"));
				user.setBreed(rs.getString("breed"));
				user.setName(rs.getString("name"));
				user.setMemo(rs.getString("memo"));
				bookList.add(user);
			}
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bookList;
	}

	/*
	 * DB情報一件を指定して取得
	 * */
	public User showUser(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = con.prepareStatement("select * from animalType where id = ?");
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setType(rs.getString("type"));
				user.setType(rs.getString("size"));
				user.setBreed(rs.getString("breed"));
				user.setName(rs.getString("name"));
				user.setMemo(rs.getString("memo"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	/*
	 * 投稿情報の更新
	 * */
	public void updateUser(String type, String size, String breed, String name, String memo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("update animalType set type = ?, size = ?, breed = ?, name = ?, memo = ? where id = ?");

			pstmt.setString(1, type);
			pstmt.setString(2, size);
			pstmt.setString(3, breed);
			pstmt.setString(4, name);
			pstmt.setString(5, memo);
			

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 投稿情報削除
	 * */
	public void deleteUser(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("delete from animalType where id = ?");
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

