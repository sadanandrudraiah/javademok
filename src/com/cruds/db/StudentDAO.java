package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.cruds.entity.Student;
import com.cruds.exception.SMSException;

public class StudentDAO {
	
	public boolean delete(int rollno)
	{
		String sql = "delete from student where rollno=?";
		int rows = 0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rollno);
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
	}
	
	
	
	
	
	public Vector<Vector<String>> getTableData()
	{
		String sql = "select rollno,name from student";
		Vector<Vector<String>> data = new Vector<>();
		Vector<String> row = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
				
			{
				row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public boolean Create(Student s) throws SMSException
	{
		String sql = "insert into student(rollno,name) values (?,?)";
		int rows = 0;
		
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getRollNo());
			ps.setString(2, s.getName());
			
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			
			if(e.getMessage().contains("Duplicate"))
			{
				throw new SMSException("Roll No already exixts! " + s.getRollNo());
			}
			else
			{
				throw new SMSException("Database error during create " + e.getMessage());
			}
		}
		
		return rows > 0;
	}

}
