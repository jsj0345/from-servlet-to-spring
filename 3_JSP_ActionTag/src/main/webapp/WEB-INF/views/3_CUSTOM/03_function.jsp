<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>JSTL Functions</h1>
    
    <c:set var="str" value="Hello World"></c:set>
    
    str: ${str} <br>
    
    문자열의 길이 : ${str.length()} 글자 <br> <!-- 자바 방식 -->
    문자열의 길이 : ${fn:length(str)} 글자 <br> <!-- fn방식 -->
    <!-- null이여도 0 반환 -->
    
    모두 대문자 출력 : ${str.toUpperCase()} <br> <!-- 자바 방식 -->
    모두 소문자 출력 : ${str.toLowerCase()} <br> <!-- 자바 방식 -->
    
    모두 대문자 출력 : ${fn:toUpperCase(str)} <br>  <!-- fn방식 --> 
    모두 소문자 출력 : ${fn:toLowerCase(str) } <br>  <!-- fn방식 -->
    
    World의 시작 인덱스 : ${fn:indexOf(str,"World")} <br>
    World를 Java로 변경 : ${fn:replace(str,"World","java")} <br>
    
    원본 확인 : ${str}
    
    str에 Hello가 포함되어있나요? : ${fn:contains(str,"Hello")} 

</body>
</html>