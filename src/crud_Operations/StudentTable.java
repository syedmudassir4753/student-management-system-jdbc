package crud_Operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
// 	CREATING TABLE IN crudoperations DATABASE
public class StudentTable {
	public static void main(String[] args) {
		Connection con=JdbcConnection.getConnection();
		try {
			Statement st=con.createStatement();
			String sql="create table if not exists student"
					+ "(srollno int primary key auto_increment,sname varchar(45),"
					+ "sclass int,smarks double,sfee double)";
			st.execute(sql);
			System.out.println("Student table created successfully.....");
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
