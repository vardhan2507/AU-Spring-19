import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConn {
	Connection con;
	PreparedStatement ps;
	Statement s;
	
	JDBCConn() throws SQLException, ClassNotFoundException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","vardhan","vardhan");
		ps=con.prepareStatement("insert into emp values(?,?,?,?)");
	}	
	
	void insert(int id, String name, int salary, int deptid) throws SQLException {
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, salary);
		ps.setInt(4, deptid);
		ps.executeUpdate();
		
	}
	
	ResultSet fetchData() throws SQLException {
		
		s=con.createStatement();
		String sql = "SELECT deptid,name FROM dept";
		ResultSet rs = s.executeQuery(sql);
		return rs;
	}

}
