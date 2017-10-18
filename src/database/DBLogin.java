package database;
import java.sql.*;

public class DBLogin {
	
	public int isLogged(String username, String password, String tablename) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = new DBConnector().getConnection();
		
		try {
			password = Crypto.encrypt(password);
			ps = conn.prepareStatement("select * from "+tablename+" where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ps = conn.prepareStatement("select uid from "+tablename+" where username=? and password=?");
				ps.setString(1, username);
				ps.setString(2, password);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					int userid = rs.getInt(1);
					return userid;
				}
				else {
					return 0;
				}
			}
			else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
