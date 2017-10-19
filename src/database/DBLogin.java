package database;
import java.sql.*;

public class DBLogin {
	
	public int isLogged(String username, String password, String tablename, String usertype) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = new DBConnector().getConnection();
		
		try {
			password = Crypto.encrypt(password);
			
			if(usertype.equals("student") || usertype.equals("instructor")) {
				ps = conn.prepareStatement("select * from "+tablename+" where username=? "
											+ "and ugid=(select ugid from user_group where group_name=?)");
				ps.setString(1, username);
				ps.setString(2, usertype);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					ps = conn.prepareStatement("select uid, is_active from "+tablename+" where username=? and password=? "
							+ "and ugid=(select ugid from user_group where group_name=?)");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, usertype);
					rs = ps.executeQuery();
					
					if(rs.next()) {
						if(rs.getBoolean(2)) {
							int userid = rs.getInt(1);
							return userid;
						}
						else {
							return -2;
						}
					}
					else {
						return 0;
					}
				}
				else {
					return -1;
				}
			}
			else if(usertype.equals("admin")) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
