package gmcc.bsmonitor.utils;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import com.mysql.jdbc.Connection;

/**
 * A util for operating db
 * @author zyx
 */
public class DBUtil {

	private static final String url = "jdbc:mysql://localhost:3306/db_bsmonitor";
	private static final String userName = "root";
	private static final String password = "zyx123";
	
	public static Connection getConnection() throws SQLException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		return (Connection) DriverManager.getConnection(url, userName, password);
	}
	
	public static void setParams(PreparedStatement pstmt, Object...params) throws SQLException{
		if(params == null || params.length == 0)
			return;
		for(int i = 1; i <= params.length; i++){
			Object param = params[i-1];
			if(param == null){
				pstmt.setNull(i, Types.NULL);
			} else if(param instanceof String){
				pstmt.setString(i, (String)param);
			} else if(param instanceof Integer){
				pstmt.setInt(i, (Integer)param);
			} else if(param instanceof Double){
				pstmt.setDouble(i, (Double)param);
			} else if(param instanceof Long){
				pstmt.setLong(i, (Long)param);
			} else if(param instanceof Boolean){
				pstmt.setBoolean(i, (Boolean)param);
			} else if(param instanceof Timestamp){
				pstmt.setTimestamp(i, (Timestamp)param);
			} else if(param instanceof Date){
				pstmt.setDate(i, (Date)param);
			}
		}
	}
	
	public static int excuteUpdate(String sql) throws SQLException{
		return excuteUpdate(sql, new Object[]{});
	}
	
	public static int excuteUpdate(String sql, Object...params) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		setParams(pstmt, params);
		return pstmt.executeUpdate();
	}
	
	public static ResultSet excuteQuery(String sql) throws SQLException{
		return excuteQuery(sql, new Object[]{});
	}
	
	public static ResultSet excuteQuery(String sql, Object...params) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		setParams(pstmt, params);
		return pstmt.executeQuery();
	}
}
