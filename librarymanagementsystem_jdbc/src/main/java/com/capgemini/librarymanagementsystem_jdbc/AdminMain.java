package com.capgemini.librarymanagementsystem_jdbc;

import java.util.Scanner;

import com.capgemini.librarymanagementsystem_jdbc.dao.AdminDaoImplements;
import com.capgemini.librarymanagementsystem_jdbc.dto.Admin;

public class AdminMain {

	public static void main(String[] args) {

		AdminDaoImplements dao = new AdminDaoImplements();
		//to register
		   Admin admin = new
		  Admin(); admin.setId(4); admin.setFirstName("Vandana");
		  admin.setLastName("Maggidi"); admin.setEmail("");
		  admin.setPassword("1234"); admin.setMobileNo(987654321); boolean res =
		  dao.registerAdmin(admin); if(res) {
		  System.out.println("Registered Successfully"); }else {
		  System.out.println("not registered"); }
		 
		//to login
		/*
		 * try { Admin admin = dao.authAdmin("vandana@gmail.com", "1234");
		  } catch(NullPointerException e) {
		 * System.out.println("Null Pointer exception"); }
		 */
		
		//to delete
		  //to addbook
		/*
		 * Scanner sc = new Scanner(System.in); System.out.println("Enter Book id"); int
		 * bookId = sc.nextInt(); System.out.println("Enter book name"); String bookName
		 * = sc.next(); System.out.println("Enter book category"); String bookCategory =
		 * sc.next(); System.out.println("Enter author name"); String authorName =
		 * sc.next(); System.out.println("enter publisher name"); String publisherName =
		 * sc.next(); BookDetails bookDetail = new BookDetails();
		 * bookDetail.setBookId(bookId); bookDetail.setBookName(bookName);
		 * bookDetail.setBookCategory(bookCategory);
		 * bookDetail.setAuthorName(authorName);
		 * bookDetail.setPublisherName(publisherName); boolean res
		 * =service.addBook(bookDetail); if(res) {
		 * System.out.println("Added successfully"); } else {
		 * System.out.println("Not added"); } break;
		 */
	}

}
