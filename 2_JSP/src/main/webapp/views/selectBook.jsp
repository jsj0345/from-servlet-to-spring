<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.controller.BookDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>책 정보 조회</h1>
    
    <!-- 조회 버튼을 클릭하면 input 상자에 입력한 키워드로 조회한 책 목록을 받아
         폼태그 하단에 각 책 정보를 테이블의 한 행씩 담아 출력해보기
         
         ex)
         책번호 책제목 저자 카테고리 가격
         1    이런책 김이런 코믹  15000
    
     -->
     
     <!-- JSP에서 view, Controller 로직 한번에 다처리한다? mvc 1 패턴이다.-->
     <%
     
     	 ArrayList<BookDao> bookList = new ArrayList<>(); // 데이터 담아오는 변수
     
    	 request.setCharacterEncoding("UTF-8");
         
         String keyword = request.getParameter("keyword"); //keyword value값을 꺼내오기 
         
        
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rset = null; 
         
         BookDao book = null; 
         
         String sql = "SELECT * FROM BOOK WHERE BOOK_TITLE LIKE ?"; 
         
         
         
   
         try {
        	 
        	Class.forName("oracle.jdbc.OracleDriver");
         	
         	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
                     ,"JDBC"
                     ,"JDBC");
         	
         	pstmt = conn.prepareStatement(sql);
         	
         	pstmt.setString(1, "%"+keyword+"%"); //문자열 주의 
         	
         	rset = pstmt.executeQuery();
         	
         	
         	while(rset.next()) {
         		
         		book = new BookDao(rset.getInt("BOOK_NO")
         				,rset.getString("BOOK_TITLE")
         				,rset.getString("AUTHOR")
         				,rset.getString("CATEGORY")
         				,rset.getInt("PRICE"));
         		
         		bookList.add(book); 
         		
         		
         	}
         	
         } catch (Exception e) {
         	e.printStackTrace(); 
         } finally {
         	
         	try {
         		rset.close();
             	pstmt.close();
             	conn.close();
         		
         	} catch (Exception e) {
         		e.printStackTrace(); 
         	}
         		
         }
         
    	 System.out.println(bookList);
     
        
        
        
     
     %>
    <form action="" method="post">
       <input type="text" name="keyword">
      
       <input type="submit" value="조회">
       
       <table border="1">
        	<tr>
	            <th>책번호</th>
	            <th>책제목</th>
	            <th>저자</th>
	            <th>카테고리</th>
	            <th>가격</th>
        	</tr>
        
	        	<% for(BookDao b : bookList) { %> <!-- 키워드로 제목을 조회하면 여러개가 나올수있음 그래서 for문을 먼저 작성하고 tr,td를 넣는게 맞음!  --> 
	        		<tr>
			            <td><%= b.getBookNo() %></td>
			            <td><%= b.getBookTitle() %></td>
			            <td><%= b.getAuthor() %></td>
			            <td><%= b.getCategory() %></td>
			            <td><%= b.getPrice() %></td>
	        		</tr>
        		<% } %>
       </table>
    
    </form>
    

</body>
</html>