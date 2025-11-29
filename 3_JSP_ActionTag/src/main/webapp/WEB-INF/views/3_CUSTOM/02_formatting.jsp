<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Formatting</h1>
    
    
    
    <h3>1.formatNumber</h3>
    <p>
       숫자 데이터의 포맷(형식)지정 <br>
       -표현하고자 하는 숫자 데이터의 형식을 통화기호, %등 원하는 쓰임에 맞게 지정하는 태그<br><br>
       
       &lt;fmt:formatNumber value="출력할값" groupingUsed="true/false"
                                   type="percent/currency" currencySymbol="$"/&gt; <br>
                                   
       -groupingUsed,type,currencySymbol 속성들은 생략가능                             
    </p>
    
    <c:set var="num1" value="123456789" ></c:set>
    <c:set var="num2" value="0.55"></c:set>
    <c:set var="num3" value="50000"></c:set>
    
    <br>
    
    출력 : ${num1} <br>
    세자리마다 구분하여 출력 : <fmt:formatNumber value="${num1}"></fmt:formatNumber> <br>
    숫자 그대로 출력 : <fmt:formatNumber value="${num1}" groupingUsed="false"></fmt:formatNumber> <br>
    <!-- groupingUsed 기본값은 true(설정시 숫자를 ,로 3자리마다 구분지어준다 -->
    
    <!-- type="percent" : 소수점을 백분율로 변경하여 보여준다 -->
    percent : <fmt:formatNumber value="${num2}" type="percent"/> <br>
    
    <!-- type="currency" : 통화(돈)단위로 보여진다. 현재 로컬 정보에 맞는 단위 사용 -->
    currency: <fmt:formatNumber value="${num3}" type="currency"></fmt:formatNumber> <br>
    
    <!-- currencySymbol 통화 기호 변경 -->
    currency $로 변경 : <fmt:formatNumber value="${num3}" type="currency" currencySymbol="$"></fmt:formatNumber>
    
    <h3>2.formatDate</h3>
    <p>
       날짜 및 시간 데이터 포맷(형식) 지정 <br>
       단 java.util.Date 객체를 이용해야한다. 
    </p>
    
    <c:set var="current" value="<%=new java.util.Date() %>"></c:set>
    
    <br>
    
    그냥 출력 : ${current}
    
    <ul>
      <li>
         <!-- 년월일 형식 (type 생략시 기본) -->
         현재 날짜 : <fmt:formatDate value="${current}"/>
      </li>
      
      <li>
          현재 시간: <fmt:formatDate value="${current}" type="time"></fmt:formatDate>
       </li>
       
       <li>
          현재 날짜 및 시간: <fmt:formatDate value="${current}" type="both"></fmt:formatDate>
       </li>
       
       <li>
          <!-- medium: 기본 길이 -->
          medium: <fmt:formatDate value="${current}" type="both" dateStyle="medium" timeStyle="medium"></fmt:formatDate>
       </li>
       
       <li>
          long: <fmt:formatDate value="${current}" type="both" dateStyle="long" timeStyle="long"></fmt:formatDate>   
       </li> 
       
       <li>
          full: <fmt:formatDate value="${current}" type="both" dateStyle="full" timeStyle="full"></fmt:formatDate>   
       </li>  
       
       <li>
           short: <fmt:formatDate value="${current}" type="both" dateStyle="short" timeStyle="short"></fmt:formatDate>
       </li>   
          
       <li>
           customizing: <fmt:formatDate value="${current}" type="both" dateStyle="short" pattern="yyyy-MM-dd(E) a HH:mm:ss"></fmt:formatDate>
       </li>
      
      <li> <!-- 형식을 좀 다르게해도됨(dateStyle, timeStyle -->
         long : <fmt:formatDate value="${current}" type="both" dateStyle="short" timeStyle="full"/>
      </li>
      
    </ul>
    
    <!-- 
       yyyy : 년도 / MM : 월 / dd : 일 / E : 요일 / a : 오전오후
       HH: 24시 기준 / hh : 12시 기준 / mm : 분 / ss : 초
     -->
    

</body>
</html>

<%--
<<<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <h1>formatting</h1>
   
   <h3>1.formatNumber</h3>
   
   <p>
      숫자 데이터의 포맷(형식)지정 <br>
      -표현하고자 하는 숫자 데이터의 형식을 통화기호, %등 원하는 쓰임에 맞게 지정하는 태그
      
      &lt;fmt:formatNumber value="출력할값" groupingUsed="true/false"
                  type="percent/currency" currentSymbol="$"/&gt;
      
      -groupingUsed,type,currencySymbol은 생략 가능
   </p>
   
   <c:set var="num1" value="123456789"></c:set>
   <c:set var="num2" value="0.55"></c:set>
   <c:set var="num3" value="50000"></c:set>
   
   <br>
   
   출력: ${num1} <br>
   세자리마다 구분하여 출력: <fmt:formatNumber value="${num1}"></fmt:formatNumber>
   숫자 그대로 출력 : <fmt:formatNumber value="${num1}" groupingUsed="false"></fmt:formatNumber>
   <!-- groupingUsed기본값은 true(설정시 숫자를 ,로 3자리마다 구분) --!>
   
   <!--type="percent" : 소수점을 백분율로 변경하여 보여준다 -->
   percent : <fmt:formatNumber value="${num2}" type="percent"></fmt:tormatNumber>
   
   <!--type="currency" : 통화(돈)단위로 보여진다. 현재 로컬 정보에 맞는 단위 사용-->
   currency : <fmt:formatNumber value="${num3}" type="currency"></fmt:formatNumber>
   
   <!--currencySymbol 통화 기호 변경-->
   currency $로 변경 : <fmt:formatNumber value ="${num3}" type="currency" currencySymbol="$"></fmt:formatNumber>
   
   <h3>2.formatDate</h3>
   <p>
     날짜 및 시간 데이터 포맷(형식)지정 <br>
     단, java.util.Date 객체를 이용한다.
   </p>
   
   <c:set var="current" value="<%=new java.util.Date()%>"></c:set>
   
   <br>
   
   그냥 출력 : ${current}     
                  
   <ul>
       <li>
         <!--년,월,일 형식 (type 생략시 기본)-->
         현재 날짜 :<fmt:formatDate value="${current}"></fmt:formatDate>
       </li>
       
       <li>
          현재 시간: <fmt:formatDate value="${current}" type="time"></fmt:formatDate>
       </li>
       
       <li>
          현재 날짜 및 시간: <fmt:formatDate value="${current}" type="both"></fmt:formatDate>
       </li>
       
       <li>
          <!-- medium: 기본 길이 -->
          medium: <fmt:formatDate value="${current}" type="both" dateStyle="medium" timeStyle="medium"></fmt:formatDate>
       </li>
       
       <li>
          long: <fmt:formatDate value="${current}" type="both" dateStyle="long" timeStyle="long"></fmt:formatDate>   
       </li> 
       
       <li>
          full: <fmt:formatDate value="${current}" type="both" dateStyle="full" timeStyle="full"></fmt:formatDate>   
       </li>  
       
       <li>
           short: <fmt:formatDate value="${current}" type="both" dateStyle="short" timeStyle="short"></fmt:formatDate>
       </li>   
          
       <li>
           customizing: <fmt:formatDate value="${current}" type="both" dateStyle="short" pattern="yyyy-MM-dd(E) a HH:mm:ss></fmt:formatDate>
       </li>

--%>