package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookDao {
	
	private int bookNo;
	
	private String bookTitle;
	
	private String author;
	
	private String category;
	
	private int price; 
	
	public BookDao(int bookNo, String bookTitle, String author, String category, int price) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.author = author;
		this.category = category; 
		this.price = price; 
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	 
	
	
	
	/*
	public String insertBook(String title, String author, String category, int price) {
		String resultStr = null;  // 결과 변수 
	     
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	     
	    String sql = "INSERT INTO BOOK VALUES(SEQ_BNO.NEXTVAL,?,?,?,?)";
	         
	         
	    int result = 0; 
	         
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	         
	         try {
	        	 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
	        			                               ,"JDBC"
	        			                               ,"JDBC");
	        	 
	        	 conn.setAutoCommit(false); 
	        	 
	        	 pstmt = conn.prepareStatement(sql);
	        	 
	        	 pstmt.setString(1, title);
	        	 pstmt.setString(2, author);
	        	 pstmt.setString(3, category);
	        	 pstmt.setInt(4, price);
	        	 
	        	 result = pstmt.executeUpdate(); // 처리된 행 수 반환. 
	        	 
	        	 if(result>0) {
	        		 conn.commit();
	        		 resultStr = "등록 성공!";
	        	 } else {
	        		 conn.rollback();
	        		 resultStr = "등록 실패!";
	        	 }
	        	 
	         } catch (Exception e) {
	        	 e.printStackTrace(); 
	         } finally {
	        	 try {
	        		 pstmt.close();
	        		 conn.close();
	        	 } catch (Exception e) {
	        		 e.printStackTrace(); 
	        		 
	        	 }
	         }
	         
	   return resultStr;       
	}
	*/

}
