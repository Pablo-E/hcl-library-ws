package com.hcl.library;

import java.sql.SQLException;

import com.hcl.library.dao.ImplUserDao;
import com.hcl.library.model.User;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		
		User user = new ImplUserDao().findById(1);
		System.out.println(user);
	}
}
