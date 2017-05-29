package com.botfactory.springdbexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.botfactory.springdbexample.domain.User;
import com.botfactory.springdbexample.utility.DBUtility;

public class UserService {

	private Connection connection;
	public UserService(){
		connection = DBUtility.getconnection();
	}
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<User>();
		try{
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM TBLUSER LIMIT 15");
		while(rs.next()){
			User user = new User();
			user.setUserid(rs.getInt("userid"));
			user.setFirstName(rs.getString("firstname"));
			user.setLastName(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			users.add(user);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return users;
	}
	
	public com.botfactory.springdbexample.domain.User getUserById(int userId){
		User user = new User();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TBLUSER WHERE USERID=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				user.setUserid(userId);
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
}
