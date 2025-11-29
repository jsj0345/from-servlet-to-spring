<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 지시어</title>
</head>
<body>
  <h1>include 지시어</h1>
  
  <h2>01_ScriptingElement.jsp</h2>
  <!-- 현재 페이지에 01_ScriptingElement 페이지 포함시켜보기 (불러오기) -->
  
  <%@include file = "01_ScriptingElement.jsp" %>
  
  포함한 jsp상에 존재하는 변수를 사용할 수 있다. : <%=sum %>
  
  <!-- 
  		today.jsp 파일을 생성하여 해당 jsp에서 오늘 날짜를 출력할 수 있도록
  		2025-11-24 형태의 문자열을 변수처리하고
  		현재 페이지에 불러와 
  		오늘 날짜는 OOOOOO입니다. 를 h1 태그로 출력해보기 
  
   -->
   
   <%@include file = "today.jsp" %>
   
   <h1><%=result %></h1>
  

</body>
</html>

<%--

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 지시어</title>
</head>
<body>
  <h1>include 지시어</h1>
  
  <h2>01_ScriptingElement.jsp</h2>
  <!-- 현재 페이지에 01_ScriptingElement 페이지 포함시켜보기 (불러오기)-->
  
  <%@include file = "01_ScriptingElement.jsp" %>
  
  포함한 jsp상에 존재하는 변수를 사용할 수 있다. : <%=sum%>
  
  <!--
       today.jsp 파일을 생성하여 해당 jsp에서 오늘 날짜를 출력할 수 있도록
       2025-11-24 형태의 문자열을 변수처리하고
       현재 페이지에 불러와
       오늘 날짜는 OOOOOO입니다. 를 h1 태그로 출력해보기
  -->
  
  <%@include file = "today.jsp"%>
  
  <h1><%=result%></h1>  
  
      
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 지시어</title>
</head>
<body>
   <%
      Date today = new Date();
      
      SimpleDateFormat sdf = new SimpleDateformat("yyyy-MM-dd");
      
      String result = sdf.format(today); 
   
   
   %>

</body>
</html> 


--%>