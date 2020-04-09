package com.capgemini.librarymanagementsystem_jdbc.dao;

import com.capgemini.librarymanagementsystem_jdbc.dto.Admin;
import com.capgemini.librarymanagementsystem_jdbc.dto.BookDetails;

public interface AdminDao {

	boolean registerAdmin(Admin admin);
	Admin authAdmin(String email, String password);
	boolean addBook(BookDetails bookDetail);
	boolean removeBook(int bookId);
	boolean updateBook(int bookId);
	BookDetails searchBook(int bookId);
	boolean bookIssue(int bookId);
}
