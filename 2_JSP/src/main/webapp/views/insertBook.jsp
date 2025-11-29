<%@page import="com.kh.controller.BookDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
     request.setCharacterEncoding("UTF-8");
   
     String resultStr = null;
     
     /* Dao만 따로 구현해서 호출하는 방식 
     if("POST".equals(request.getMethod())) {
  		 String title = request.getParameter("bookTitle");
         String author = request.getParameter("author");
         String category = request.getParameter("category");
         int price = Integer.parseInt(request.getParameter("price"));
         
     	 resultStr = new BookDao().insertBook(title,author,category,price);  // 결과 변수 
     }
     */
     
     // JSP 자체에서도 처리하는 방법
     if("POST".equals(request.getMethod())) {
    	 String title = request.getParameter("bookTitle");
         String author = request.getParameter("author");
         String category = request.getParameter("category");
         int price = Integer.parseInt(request.getParameter("price"));
         
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
         
        
         System.out.println("title : " + title); 
         
         System.out.println(request.getMethod());    	 
     }
     
     
     
   
   %>
  
  <h1>책 정보 등록 페이지</h1>
  <!-- 
     BOOK_NO
     BOOK_TITLE
     AUTHOR
     CATEGORY
     PRICE
  
   -->
  
  <form action="" method="post">
       책 제목 : <input type = "text" name="bookTitle"> <br>
       저자 : <input type = "text" name="author"> <br>
       카테고리 : 
       <Select name="category">
          <option>코믹</option>
          <option>멜로</option>
          <option>판타지</option>
       </Select>
       가격 : <input type="number" name = "price" value='0'>
       
       <input type="submit" value="등록">
        
  </form>
  
  <%if(resultStr!=null) {%>
    <h1>결과 : <%=resultStr %></h1>
  <%} %>
  

</body>
</html>