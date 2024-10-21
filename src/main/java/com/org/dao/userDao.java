package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.user;

public class userDao {

	public void saveUser( user user) {

		String name=user.getName();
		int age =user.getAge();
		String email=user.getEmail();
		long mobile=user.getMobile();
		String password=user.getPassword();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
			PreparedStatement pst =con.prepareStatement("insert into regd (name,age,email,mobile,password) values (?,?,?,?,?)");
			
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setString(3, email);
			pst.setLong(4, mobile);
			pst.setString(5, password);

			pst.executeUpdate();
			
			System.out.println("Done");
			con.close();
			
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public user fetchUserById( int id) {
		user user = new user();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
			PreparedStatement pst = con.prepareStatement("select * from regd where id=?");
			pst.setInt(1, id);
			ResultSet rst =pst.executeQuery();
			
			while(rst.next()) {
				user.setName(rst.getString("name"));
				user.setAge(rst.getInt("age"));
				user.setEmail(rst.getString("email"));
				user.setMobile(rst.getLong("mobile"));
				user.setPassword(rst.getString("password"));

				return user;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public List<user> fetchAllUsers() {
		List<user> userlist =new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
			PreparedStatement pst =con.prepareStatement("select * from regd");
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
            	user user =new user();
            	user.setId(rst.getInt("id"));
            	user.setName(rst.getString("name"));
            	user.setAge(rst.getInt("age"));
            	user.setEmail(rst.getString("email"));
            	user.setMobile(rst.getLong("mobile"));
            	user.setPassword(rst.getString("password"));

            	userlist.add(user);
            	
        		

            }

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return userlist;
	}
	public void updateUserById( int id ,user user) {
     user user1 = fetchUserById(id);
     if(user1!=null) {
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
			PreparedStatement pst =con.prepareStatement("update regd set name=?,age=?,email=?,mobile=? where id=?");
			pst.setString(1, user.getName());
			pst.setInt(2, user.getAge());
			pst.setString(3, user.getEmail());
			pst.setLong(4, user.getMobile());
			pst.setInt(5,id);
			
			pst.executeUpdate();
			
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
		
	}
	public void deleteUserById(int id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
			PreparedStatement pst = con.prepareStatement("delete from regd where id =?");
			pst.setInt(1, id);
			
			pst.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public user fetchUserByUserAndPassword(String email ,String password) {

		user user =new user();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
			PreparedStatement pst =con.prepareStatement("select * from regd where email=? and password =?");		
            pst.setString(1, email);
            pst.setString(2, password);
			ResultSet rst =pst.executeQuery();
			if(rst.next()) {
				int id = rst.getInt("id");
				String name=rst.getString("name");
				int age =rst.getInt("age");
				String email1=rst.getString("email");
				long mobile= rst.getLong("mobile");
				String password1=rst.getString("password");

				user.setId(id);
				user.setName(name);
				user.setAge(age);
				user.setEmail(email1);
				user.setMobile(mobile);
				user.setPassword(password1);

				return user;

			}
			
		
            con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

