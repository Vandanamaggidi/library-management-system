package com.capgemini.librarymanagementsystem_jdbc.controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem_jdbc.dto.BookDetails;
import com.capgemini.librarymanagementsystem_jdbc.dto.BookIssue;
import com.capgemini.librarymanagementsystem_jdbc.dto.BooksBorrowed;
import com.capgemini.librarymanagementsystem_jdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_jdbc.dto.User;
import com.capgemini.librarymanagementsystem_jdbc.exception.LMSException;
import com.capgemini.librarymanagementsystem_jdbc.factory.LibraryFactory;
import com.capgemini.librarymanagementsystem_jdbc.service.UserService;
import com.capgemini.librarymanagementsystem_jdbc.validation.LibraryValidation;

public class LibraryController {

	public static void main(String[] args) {

		doReg();
	}
	
	public static void doReg() {
		
		

				boolean flag = false;

				int regId = 0; 
				String regFirstName = null; 
				String regLastName = null; 
				long regMobile = 0;
				String regEmail = null;
				String regPassword = null;

				boolean loginStatus = true;
			 LibraryValidation validation = new LibraryValidation();
				do {
					try(Scanner scanner = new Scanner(System.in);){
						System.out.println("Press 1 to Register");
						System.out.println("Press 2 to Login");
						System.out.println("Press 3 to EXIT");
						do {
							try {
								UserService service1= LibraryFactory.getUserService();
								int choice = scanner.nextInt();
								switch(choice) {
								case 1:
									do {
										try {
											System.out.println("Enter ID :");
											regId = scanner.nextInt();
											validation.validateId(regId);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Id should contains only digits");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);

									do {
										try {
											System.out.println("Enter First Name :");
											regFirstName = scanner.next();
											validation.validateName(regFirstName);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Name should contains only Alphabates");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);
									do {
										try {
											System.out.println("Enter Last Name :");
											regLastName = scanner.next();
											validation.validateName(regLastName);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Name should contains only Alphabates");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);

									do {
										try {
											System.out.println("Enter Email :");
											regEmail = scanner.next();
											validation.validateEmail(regEmail);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Email should be proper ");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);

									do {
										try {
											System.out.println("Enter Password :");
											regPassword = scanner.next();
											validation.validatePassword(regPassword);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Enter correct Password ");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);

									do {
										try {
											System.out.println("Enter Mobile :");
											regMobile = scanner.nextLong();
											validation.validateMobileNo(regMobile);
											flag = true;
										} catch (InputMismatchException e) {
											flag = false;
											System.err.println("Mobile Number  should contains only numbers");
										} catch (LMSException e) {
											flag = false;
											System.err.println(e.getMessage());
										}
									} while (!flag);
									System.out.println("Enter the role");
									String regRole = scanner.next();
									User ai = new User();
									ai.setId(regId);
									ai.setFirstName(regFirstName);
									ai.setLastName(regLastName);
									ai.setEmail(regEmail);
									ai.setPassword(regPassword);
									ai.setMobileNo(regMobile);
									ai.setRole(regRole);
									try {
										boolean check=service1.registerUser(ai);
										if(check) {
											System.out.println("Registered");
										}else {
											System.out.println("Already user is registered");
										}
									}catch (LMSException e) {
										System.err.println(e.getMessage());
									}
									break;
								case 2:
									System.out.println("enter email");
									String email=scanner.next();
									System.out.println("enter password");
									String password=scanner.next();
									try {
										User loginInfo=service1.authUser(email, password);
										if(loginInfo.getEmail().equals(email) && loginInfo.getPassword().equals(password)) {
											System.out.println("Logged In");
										}
										if(loginInfo.getRole().equals("admin")) {
											do {
												try {
													System.out.println("-----------------------------------------------");
													System.out.println("Press 1 to add book");
													System.out.println("Press 2 to remove book");
													System.out.println("Press 3 to issue book");
													System.out.println("Press 4 to Search the Book by Author");
													System.out.println("Press 5 to Search the Book by Title");
													System.out.println("Press 6 to Get the Book Information");
													System.out.println("Press 7 to Search the book category");
													System.out.println("Press 8 to update the book");
													System.out.println("Press 9 to check student book history");
													System.out.println("Press 10 to check requests");
													System.out.println("Press 11 to check issued books");
													System.out.println("Press 12 to view users");
													System.out.println("Press 13 to update Password");
													System.out.println("Press 14 to logout");

													int choice1 = scanner.nextInt();
													switch (choice1) {
													case 1:
														System.out.println("enter id");
														int addId=scanner.nextInt();
														System.out.println("enter bookname");
														String addName=scanner.next();
														System.out.println("enter authorname");
														String addAuth=scanner.next();
														System.out.println("enter category");
														String addCategory=scanner.next();
														System.out.println("enter publisher");
														String addPublisher=scanner.next();
														/*
														 * System.out.println("enter no of copies"); int addCopies = scanner.nextInt();
														 */
														BookDetails bi =new BookDetails();
														bi.setBookId(addId);
														bi.setBookName(addName);
														bi.setAuthorName(addAuth);
														bi.setBookCategory(addCategory);
														bi.setPublisherName(addPublisher);
														//bi.setCopies(addCopies);
														try {
															boolean check2=service1.addBook(bi);
															if(check2) {
																System.out.println("-----------------------------------------------");
																System.out.println("Added Book");
															}else {
																System.out.println("-----------------------------------------------");
																System.out.println("Book not added");
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}

														break;	
													case 2:
														System.out.println("enter id");
														int removeId=scanner.nextInt();
														try {
															boolean check3=service1.removeBook(removeId);
															if(check3) {
																System.out.println("-----------------------------------------------");
																System.out.println("Removed Book");
															}else {
																System.out.println("-----------------------------------------------");
																System.out.println("Book not removed");
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;

													case 3:
														System.out.println("enter Book Id");
														int issueId=scanner.nextInt();
														System.out.println("Enter User Id");
														int userId = scanner.nextInt();
														try {
															boolean check4=service1.bookIssue(issueId, userId);
															if(check4) {
																System.out.println("-----------------------------------------------");
																System.out.println("Book Issued");
															}else {
																System.out.println("-----------------------------------------------");
																System.out.println("Book not issued");
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 4:
														System.out.println("Search the book by the Author Name:");
														String author = scanner.next();
														try {
															List<BookDetails> bookauthor = service1.searchBookByAuthor(author);
															for (BookDetails bookBean : bookauthor) {

																if (bookBean != null) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book_Id is-->"+bookBean.getBookId());
																	System.out.println("Book_Name is-->"+bookBean.getBookName());
																	System.out.println("Book_Author is-->"+bookBean.getAuthorName());
																	System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
																	System.out.println("Book_Category is-->"+bookBean.getBookCategory());
																	//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("No books are available written by this author");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 5:
														System.out.println("  Search the book by the Book_Title :");
														String btitle = scanner.next();
														try {
															List<BookDetails> booktitle = service1.searchBookByTitle(btitle);
															for (BookDetails bookBean : booktitle) {	
																if (bookBean != null) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book_Id is-->"+bookBean.getBookId());
																	System.out.println("Book_Name is-->"+bookBean.getBookName());
																	System.out.println("Book_Author is-->"+bookBean.getAuthorName());
																	System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
																	System.out.println("Book_Category is-->"+bookBean.getBookCategory());
																	//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("No books are available with this title.");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;

													case 6:
														try {
															List<BookDetails> info = service1.getBooksInfo();
															for (BookDetails bookBean : info) {

																if (bookBean != null) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book_Id is-->"+bookBean.getBookId());
																	System.out.println("Book_Name is-->"+bookBean.getBookName());
																	System.out.println("Book_Author is-->"+bookBean.getAuthorName());
																	System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
																	System.out.println("Book_Category is-->"+bookBean.getBookCategory());
																	//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Books info is not present");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 7:
														System.out.println("  Search the book by the Book category :");
														String bcategory = scanner.next();

														try {
															BookDetails bean5 = new BookDetails();
															bean5.setBookName(bcategory);
															List<BookDetails> bookCategory1 = service1.searchBookByTitle(bcategory);
															for (BookDetails bookBean : bookCategory1) {	
																if (bookBean != null) {
																	System.out.println("Book Id is "+ bookBean.getBookId());
																	System.out.println("Book Name is " + bookBean.getBookName());
																	System.out.println("Book Author is " + bookBean.getAuthorName());
																	System.out.println("Book PublisherName is " + bookBean.getPublisherName());
																	System.out.println("Book Category is " + bookBean.getBookCategory());
																	//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
																} else {
																	System.out.println("No books are available with this title.");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 8:
														System.out.println("Enter the updated id :");
														int bid= scanner.nextInt();
														System.out.println("Enter bookName to be updtaed");
														String updatedBookName =scanner.next();
														BookDetails bean2 = new BookDetails();
														bean2.setBookId(bid);
														bean2.setBookName(updatedBookName);
														try {
															boolean updated = service1.updateBook(bean2);
															if (updated) {
																System.out.println("-----------------------------------------------");
																System.out.println("Book is updated");
															} else {
																System.out.println("-----------------------------------------------");
																System.out.println("Book is not updated");
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;

													case 9:
														System.out.println("Enter the User Id");
														int user_Id = scanner.nextInt();
														try {
															List<BookIssue> uid = service1.bookHistoryDetails(user_Id);
															for (BookIssue issueDetails : uid) {
																if(issueDetails != null) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("No of books Borrowed :"+issueDetails.getId());
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Respective user hasn't borrowed any books");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 10:
														System.out.println(" Requests received are:");
														try {
															List<RequestDetails> requests = service1.showRequests();
															for (RequestDetails requestBean : requests) {	
																if (requestBean != null) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("User_Id is-->"+requestBean.getId());
																	System.out.println("User_Name is-->"+requestBean.getFullName());
																	System.out.println("Book_Id is-->"+requestBean.getBookId());
																	System.out.println("BookName is-->"+requestBean.getBookName());
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("No Requests are received");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 11:
														System.out.println("Issued Books are:");
														try {
															List<BookIssue> issuedBooks = service1.showIssuedBooks();
															for (BookIssue issueBean : issuedBooks) {	
																if (issueBean != null) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book_Id is-->"+issueBean.getBookId());
																	System.out.println("User_Id is-->"+issueBean.getId());
																	System.out.println("Issue_Date is-->"+issueBean.getIssueDate());
																	System.out.println("Return_Date is-->"+issueBean.getReturnDate());
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("No book has been issued");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 12:
														System.out.println("Users are:");
														try {
															List<User> users = service1.showUsers();
															for (User Bean : users) {	
																if (Bean != null) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("User_Id is-->"+Bean.getId());
																	System.out.println("First_Name is-->"+Bean.getFirstName());
																	System.out.println("Last_Name is-->"+Bean.getLastName());
																	System.out.println("Email_Id is-->"+Bean.getEmail());
																	System.out.println("Password is-->"+Bean.getPassword());
																	System.out.println("Mobile_No is-->"+Bean.getMobileNo());
																	System.out.println("User's_Role is-->"+Bean.getRole());
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("No Users are present");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 13:
														System.out.println("Enter the email :");
														String email_Id= scanner.next();
														System.out.println("Enter the Old password");
														String old_Password =scanner.next();
														System.out.println("Enter the new password");
														String new_Password =scanner.next();
														String user_Role = loginInfo.getRole();
														try {
															boolean updated = service1.updatePassword(email_Id, old_Password, new_Password, user_Role);
															if (updated) {
																System.out.println("-----------------------------------------------");
																System.out.println("Password is updated");
															} else {
																System.out.println("-----------------------------------------------");
																System.out.println("Password is not updated");
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;


													case 14:
														doReg();

													default:
														System.out.println("-----------------------------------------------");
														System.out.println("Invalid Choice");
														break;
													}
												}catch (InputMismatchException ex) {
													System.out.println("Incorrect entry. Please input only a positive integer.");
													scanner.nextLine();
												}
											}while(true);
										}
										else if(loginInfo.getRole().equals("student")) {
											do {
												try {
													System.out.println("-----------------------------------------------");
													System.out.println("Press 1 to request book");
													System.out.println("Press 2 to view the books borrowed");
													System.out.println("Press 3 to search book by author");
													System.out.println("Press 4 to search book by title");
													System.out.println("Press 5 to search book by category");
													System.out.println("Press 6 to get books info");
													System.out.println("Press 7 to return book");
													System.out.println("Press 8 to update password");
													System.out.println("Press 9 to main");


													int choice2 = scanner.nextInt();
													switch (choice2) {
													case 1:
														System.out.println("Enter the Book Id:");
														int reqBookId= scanner.nextInt();
														System.out.println("Enter the user Id:");
														int reqUserId = scanner.nextInt();
														try {
															if(loginInfo.getId()==reqUserId) {
																boolean requested = service1.request(reqUserId,reqBookId);
																if (requested != false) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book is Requested");
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book is not Requested");
																}	
															}else {
																System.out.println("Enter the correct UserId");
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;

													case 2:
														System.out.println("Enter the user Id");
														int user_Id = scanner.nextInt();
														try {
															if(loginInfo.getId()==user_Id) {
																List<BooksBorrowed> borrowedBookList = service1.borrowedBook(user_Id);
																for (BooksBorrowed bookBean : borrowedBookList) {

																	if (bookBean != null) {
																		System.out.println("-----------------------------------------------");
																		System.out.println("User_Id is-->"+bookBean.getId());
																		System.out.println("Book_Id is-->"+bookBean.getBookId());
																		System.out.println("Email Id is-->"+bookBean.getEmail());
																	} else {
																		System.out.println("-----------------------------------------------");
																		System.out.println("No books are borrowed by the user");
																	}
																}
															}else {
																System.out.println("Incorrect user_Id");
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;

													case 3:
														System.out.println("Search the book by the Author Name :");
														String author = scanner.next();
														try {
															List<BookDetails> bookauthor = service1.searchBookByAuthor(author);
															for (BookDetails bookBean : bookauthor) {

																if (bookBean != null) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book_Id is-->"+bookBean.getBookId());
																	System.out.println("Book_Name is-->"+bookBean.getBookName());
																	System.out.println("Book_Author is-->"+bookBean.getAuthorName());
																	System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
																	System.out.println("Book_Category is-->"+bookBean.getBookCategory());
																	//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("No books are available written by this author");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 4:
														System.out.println("Search the book by the Book Title :");
														String btitle = scanner.next();

														try {
															List<BookDetails> booktitle = service1.searchBookByTitle(btitle);
															for (BookDetails bookBean : booktitle) {	
																if (bookBean != null) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book_Id is-->"+bookBean.getBookId());
																	System.out.println("Book_Name is-->"+bookBean.getBookName());
																	System.out.println("Book_Author is-->"+bookBean.getAuthorName());
																	System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
																	System.out.println("Book_Category is-->"+bookBean.getBookCategory());
																	//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("No books are available with this title.");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 5:
														System.out.println("  Search the book by the Book category :");
														String bcategory = scanner.next();

														try {
															BookDetails bean5 = new BookDetails();
															bean5.setBookName(bcategory);
															List<BookDetails> bookCategory1 = service1.searchBookByTitle(bcategory);
															for (BookDetails bookBean : bookCategory1) {	
																if (bookBean != null) {
																	System.out.println("Book Id is "+ bookBean.getBookId());
																	System.out.println("Book Name is " + bookBean.getBookName());
																	System.out.println("Book Author is " + bookBean.getAuthorName());
																	System.out.println("Book PublisherName is " + bookBean.getPublisherName());
																	System.out.println("Book Category is " + bookBean.getBookCategory());
																	//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
																} else {
																	System.out.println("No books are available with this title.");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 6:
														try {
															LinkedList<BookDetails> info = service1.getBooksInfo();
															for (BookDetails bookBean : info) {

																if (bookBean != null) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book_Id is-->"+bookBean.getBookId());
																	System.out.println("Book_Name is-->"+bookBean.getBookName());
																	System.out.println("Book_Author is-->"+bookBean.getAuthorName());
																	System.out.println("Book_PublisherName is-->"+bookBean.getPublisherName());
																	System.out.println("Book_Category is-->"+bookBean.getBookCategory());
																	//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Books info is not presernt");
																}
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;
													case 7:
														System.out.println("Enter the Book id to return :");
														int returnId= scanner.nextInt();
														System.out.println("Enter userId");
														int userId = scanner.nextInt();	
														System.out.println("Enter the status of the book");
														String status = scanner.next();
														try {
															if(loginInfo.getId()==userId) {
																boolean returned = service1.returnBook(returnId,userId,status);
																if (returned != false) {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book is Returned");
																} else {
																	System.out.println("-----------------------------------------------");
																	System.out.println("Book is not Returned");
																}	
															}else {
																System.out.println("Invalid userId");
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;

													case 8:
														System.out.println("Enter the email :");
														String email_Id= scanner.next();
														System.out.println("Enter the Old password");
														String old_Password =scanner.next();
														System.out.println("Enter the new password");
														String new_Password =scanner.next();
														String user_Role = loginInfo.getRole();
														try {
															boolean updated = service1.updatePassword(email_Id, old_Password, new_Password, user_Role);
															if (updated) {
																System.out.println("-----------------------------------------------");
																System.out.println("Password is updated");
															} else {
																System.out.println("-----------------------------------------------");
																System.out.println("Password is not updated");
															}
														}catch (LMSException e) {
															System.err.println(e.getMessage());
														}
														break;

													case 9:
														doReg();
													default:
														break;
													}
												}catch (InputMismatchException ex) {
													System.out.println("Incorrect entry. Please input only a positive integer.");
													scanner.nextLine();
												}
											}while(true);
										}
									}catch(Exception e) {
										System.out.println("Invalid Credentials");
										System.out.println("Try logging in again,Press 2 to login");
									}
									break;
									/*
									 * case 3: System.out.println("EXIT"); //loginStatus = false; break;
									 */
								default:
									break;
								}
							}catch(InputMismatchException ex) {
								System.out.println("Incorrect entry. Please input only a positive integer.");
								scanner.nextLine();
							}
						}while(true);
					}
				}while(loginStatus);
			}
		
	}
	
