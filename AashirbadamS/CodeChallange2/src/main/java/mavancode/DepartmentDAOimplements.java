package mavancode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentDAOimplements implements DepartmentDA{

	public void DepartmentInformation() {
		
		int departid;;
		String name;
		List<String> client = new ArrayList<String>();
		PreparedStatement pstmt1 = null;
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.toString());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DEPARTMENT");
			while (rs.next()) {
				int numberName = rs.getInt("DEPARTMENT_ID");
				String departmentName = rs.getString("DEPARTMENT_NAME");	
				System.out.println(numberName +" "+ departmentName);
			}
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void DepartmentMembers() {
		// TODO Auto-generated method stub
		
	}

	public void Departmentsalary() {
		// TODO Auto-generated method stub
		
	}

	public void Departmentsalaryafterraise() {
		// TODO Auto-generated method stub
		
	}

}
