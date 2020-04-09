package com.capgemini.librarymanagementsystem_jdbc.dto;

import java.io.Serializable;
import java.util.Date;

public class BooksInfo implements Serializable{

	private  Date issueDate;
	private Date retuenDate;
	private BookDetails booksinfo;
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getRetuenDate() {
		return retuenDate;
	}
	public void setRetuenDate(Date retuenDate) {
		this.retuenDate = retuenDate;
	}
	public BookDetails getBooksinfo() {
		return booksinfo;
	}
	public void setBooksinfo(BookDetails booksinfo) {
		this.booksinfo = booksinfo;
	}
	
	
}
