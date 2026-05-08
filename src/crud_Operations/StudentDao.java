package crud_Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	//Adding Students in Table
	public void addStudent(String name ,int sclass,double marks,double fee) {
		Connection con=JdbcConnection.getConnection();
		String sql="insert into student (sname , sclass , smarks , sfee ) values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, sclass);
			ps.setDouble(3, marks);
			ps.setDouble(4, fee);
			int insert=ps.executeUpdate();
			System.out.println(insert+"=Record Added...");
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Fetching Student data
	public void viewStudent() {
		Connection con=JdbcConnection.getConnection();
		String sql="select * from student";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				int srollno=rs.getInt("srollno");
				String sname=rs.getString("sname");
				int sclass=rs.getInt("sclass");
				double smarks=rs.getDouble("smarks");
				double sfee=rs.getDouble("sfee");
				System.out.println("Student Roll.No="+srollno+"\nStudent Name="+sname+"\nStudent Class="+sclass+"\nStudent Marks="+smarks+"\nStudent Fee="+sfee);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Updating Student name as per  class
	public void updateStudent(String name,int srollno) {
		Connection con=JdbcConnection.getConnection();
		String sql="update student set sname=? where srollno=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, srollno);
			int row=ps.executeUpdate();
			System.out.println(row+"=Student updated successfully...");
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Delete the record as per condition
	public void deleteStudent(int srollno) {
		Connection con=JdbcConnection.getConnection();
		String sql="delete from student where srollno=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, srollno);
			int row=ps.executeUpdate();
			System.out.println(row+"=Student Deleted...");
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
