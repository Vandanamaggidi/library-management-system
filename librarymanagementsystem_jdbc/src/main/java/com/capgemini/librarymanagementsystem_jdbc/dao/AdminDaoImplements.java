package com.capgemini.librarymanagementsystem_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.capgemini.librarymanagementsystem_jdbc.dto.Admin;
import com.capgemini.librarymanagementsystem_jdbc.dto.BookDetails;

public class AdminDaoImplements implements AdminDao{

	@Override
	public boolean registerAdmin(Admin admin) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dburl="jdbc:mysql://localhost:3306/library_db";
			Connection conn = DriverManager.getConnection(dburl,"root","root");
			
			String query="insert into admin values(?,?,?,?,?,?)";
			 PreparedStatement pstmt=conn.prepareStatement(query);
			 pstmt.setInt(1, admin.getId());
			 pstmt.setString(2, admin.getFirstName());
			 pstmt.setString(3, admin.getLastName());
			 pstmt.setString(4, admin.getEmail());
			 pstmt.setString(5, admin.getPassword());
			 pstmt.setLong(6, admin.getMobileNo());
			 
			 int count = pstmt.executeUpdate();
			 if(admin.getEmail().equals("email") || admin.getEmail().isEmpty()) {
			 if(count == 0) {
				 return false;
			 }}else {
				//String email=  admin.getEmail();
	
				 return true;
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
		
	}

	@Override
	public Admin authAdmin(String email, String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dburl="jdbc:mysql://localhost:3306/library_db";
			Connection conn = DriverManager.getConnection(dburl,"root","root");
			
			String query="select * from admin where email=? and password=?";
			 PreparedStatement pstmt=conn.prepareStatement(query);

			 pstmt.setString(1, email);
			 pstmt.setString(2, password);
			
			 ResultSet rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 Admin admin = new Admin();
				 admin.setId(rs.getInt("id"));
				 admin.setFirstName(rs.getString("firstName"));
				 admin.setLastName(rs.getString("lastName"));
				 admin.setEmail(rs.getString("email"));
				 admin.setPassword(rs.getString("password"));
				 admin.setMobileNo(rs.getLong("mobileNo"));
				 if(admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
				 return admin;
			 }else {
					System.out.println("No record ");
					return null;
				}
			 
		} 
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
		return null;
	
	}

	@Override
	public boolean addBook(BookDetails bookDetail) {

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/library_db";
			Connection conn = DriverManager.getConnection(dburl,"root", "root");
			
			String query1 = "select * from bookDetails where id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(query1);
			pstmt.setInt(1, bookDetail.getBookId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("Book already exists");
			}else {
				
			
			String query = "insert into bookDetails values(?,?,?,?,?,?)";
			PreparedStatement pstmt1 = conn.prepareStatement(query);
			pstmt1.setInt(1, bookDetail.getBookId());
			pstmt1.setString(1, bookDetail.getBookName());
			pstmt1.setString(3, bookDetail.getAuthorName());
			pstmt.setInt(4, bookDetail.getCopies());
			pstmt1.setString(5, bookDetail.getPublisherName());
			int count= pstmt1.executeUpdate();
			
			if(count != 0) {
				return true;
			}else {
				return false;
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean removeBook(int bookId) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/library_db";
			Connection conn = DriverManager.getConnection(dburl,"root", "root");
			String query = "delete from admin where id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			int count= pstmt.executeUpdate();
			if(count != 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBook(int bookId) {

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/library_db";
			Connection conn = DriverManager.getConnection(dburl,"root", "root");
			String query = "update admin where id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			int count= pstmt.executeUpdate();
			if(count != 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public BookDetails searchBook(int bookId) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/library_db";
			Connection conn = DriverManager.getConnection(dburl,"root", "root");
			String query = "select * from bookDetails where id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			ResultSet rs = pstmt.executeQuery();
			BookDetails book = new BookDetails();
			if(bookId == book.getBookId()) {
				if(rs.next()) {
					
					
					
				}
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean bookIssue(int bookId) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/library_db";
			Connection conn = DriverManager.getConnection(dburl,"root", "root");
			String query = "select from admin where id=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			int count= pstmt.executeUpdate();
			if(count != 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
