package com.capgemini.librarymanagementsystem.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDao;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.BookDetails;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.factory.LibraryFactory;

public class AdminServiceImplements implements AdminService{
	
	private AdminDao dao = LibraryFactory.getAdminDao();

	@Override
	public boolean registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return dao.registerAdmin(admin);
	}

	@Override
	public Admin authAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return dao.authAdmin(email, password);
	}

	@Override
	public boolean addBook(BookDetails bookDetails) {
		// TODO Auto-generated method stub
		return dao.addBook(bookDetails);
	}

	@Override
	public boolean removeBook(int bookId) {
		// TODO Auto-generated method stub
		return dao.removeBook(bookId);
	}

	@Override
	public boolean updateBook(int bookId) {
		// TODO Auto-generated method stub
		return dao.updateBook(bookId);
	}

	@Override
	public List<BookDetails> searchBookBycategory(String bookCategory) {
		// TODO Auto-generated method stub
		return dao.searchBookBycategory(bookCategory);
	}

	@Override
	public LinkedList<BookDetails> searchBookByTitle(String bookName) {
		// TODO Auto-generated method stub
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public LinkedList<BookDetails> searchBookByAuthor(String bookAuthor) {
		// TODO Auto-generated method stub
		return dao.searchBookByAuthor(bookAuthor);
	}

	@Override
	public LinkedList<BookDetails> getBooksInfo() {
		// TODO Auto-generated method stub
		return dao.getBooksInfo();
	}

	@Override
	public List<User> showUsers() {
		// TODO Auto-generated method stub
		return dao.showUsers();
	}

	@Override
	public List<Request> showRequests() {
		// TODO Auto-generated method stub
		return dao.showRequests();
	}

	@Override
	public boolean bookIssue(User user, BookDetails bookDetails) {
		// TODO Auto-generated method stub
		return dao.bookIssue(user, bookDetails);
	}

	@Override
	public boolean isBookReceived(User user, BookDetails bookDetails) {
		// TODO Auto-generated method stub
		return dao.isBookReceived(user, bookDetails);
	}

	
	

}
