<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String name = (String)request.getAttribute("name");
	String phone = (String)request.getAttribute("phone");
	String address =(String)request.getAttribute("address");
	String message = (String)request.getAttribute("message");
	String pizza =	(String)request.getAttribute("pizza");
	String[] side = (String[])request.getAttribute("side");
	String payment =(String)request.getAttribute("payment");
	String[] topping = (String[])request.getAttribute("topping");
	int price = (Integer)request.getAttribute("price"); 

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <h1>피자 결제 페이지</h1>
  
  <h2>주문 내역</h2>
  
  <h3>주문자 정보</h3>
  
  
    <ul>
    	<li>성함: <%=name %>  </li>
    	<li>전화번호: <%=phone %></li>
    	<li>주소: <%=address %></li>
    	<li>요청사항: <%=message %></li>
  	</ul>
  	
  <h4>주문 정보</h4>
    <ul>
      <li>피자: <%=pizza %> </li>
      <li>토핑: <%if(topping!=null) {%>
                   <%=String.join(",",topping) %>
              <%} else { %>
                    선택안함
              <% } %>            <!-- String.join을 써보자. String,join(",",topping) -->
      </li>
      <li>
         사이드: <%=String.join(",", side)%>
      
      </li>
      <li>결제 방식: <%=payment %></li>
    </ul>	
    
    <b>위와 같이 주문하셨습니다.</b> <br> <br>
    
    <b>총 가격: <%=price %></b>
  
</body>
</html>


<%--
<%@ p<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   String name = (String)request.getAttribute("name");
   String phone = (String)request.getAttribute("phone");
   String address = (String)request.getAttribute("address");
   String message = (String)request.getAttribute("message");
   String pizza = (String)request.getAttribute("pizza");
   String[] side = (String[])request.getAttribute("side");
   String payment = (String)request.getAttribute("payment");
   String[] topping = (String[])request.getAttribute("topping");
   int price = (Integer)request.getAttribute("price");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>피자 결제 페이지</h1>
  
  <h2>주문 내역</h2>
  
  <h3>주문자 정보</h3>
  
  <ul>
     <li>성함 : <%=name%> </li>
     <li>전화번호 : <%=phone%> </li>
     <li>주소 : <%=address%> </li>
     <li>요청사항 : <%=message%> </li>
  </ul>
  
  <h4>주문 정보</h4>
    <ul>
      <li>피자: <%=pizza%> </li>
      <li>토핑: <%if(topping!=null) {%>
                 <%=String.join(",",topping)%>
               <% } else {%>
                    선택안함
               <% } %> 
      </li>
      <li>
         사이드 : <%=String.join(",",side)%>
      </li>
    </ul>
    
    <b>위와 같이 주문하셨습니다.</b> <br> <br>
    
    <b>총 가격 : <%=price%></b>
 </body>
 </html>                       
  
     


%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>피자 결제 페이지</h1>
  
  <h2>주문 내역</h2>
  
  <h3>주문자 정보</h3>
  
  <ul>
     <li>
  
  
  </ul>
  
  
    
    

--%>