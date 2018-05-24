package com.revature.util;
import com.revature.java.dao.*;

public class RequestHelper {

	static EmpDao e = new EmpDaoImpl();
	static MgrDao m = new MgrDaoImpl();
	
	public static String userLogin(int userID, String password) {
		if(checkEmployee(userID, password)) {
			return "employee";
		} else if (checkManager(userID, password)) {
			return "manager";
		} else {
			return "homepage";
		}
	}
		
	public static boolean checkEmployee(int userID, String password) {
		if(e.empLogin(userID, password)) {
			return true;
		}		
		else {
			return false;
		}		
	}
		
	public static boolean checkManager(int mgrID, String password) {
		if(m.mgrLogin(mgrID, password)) {
			return true;
		}			
		else {
			return false;
		}			
	}		
}
