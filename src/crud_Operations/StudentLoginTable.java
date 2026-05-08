package crud_Operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentLoginTable {
	public static void main(String[] args) {
		Connection con=JdbcConnection.getConnection();
		try {
			Statement st=con.createStatement();
			//creating student login Table
			String sql="create table if not exists studentlogin"
					+ "(uid int primary key auto_increment,username varchar(45),password varchar(45))";
			st.execute(sql);
			System.out.println("StudentLogin table created successfully.....");
			//inserting username and password
			 String insertQuery = "insert into studentlogin(username,password) " +
			            "values('syed','syed123')";

			        st.executeUpdate(insertQuery);

			        System.out.println("Username and Password inserted...");
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
