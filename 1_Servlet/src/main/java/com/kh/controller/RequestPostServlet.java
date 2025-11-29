package com.kh.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/postTest")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("포스트 요청완료");
		
		//get방식은 header에서 오는데 post방식은 body에서 오기 때문에 Encoding방식을 지정해줘야함. 
		
		//POST 요청 방식은 HTTP body에 전달되어 인코딩 설정이 ISO-8859-1로 되어있기 때문에
		//UTF-8 형태가 깨지게 된다. 때문에 POST 요청은 요청데이터를 추출하기 전
		//인코딩 설정부터 해야한다. 요정 객체인 request에 인코딩 설정.
		
		request.setCharacterEncoding("UTF-8");
		
		//전달받은 데이터 추출하여 콘솔창에 출력해보기
		String name = request.getParameter("userName");
		String gender = request.getParameter("gender");
		//숫자여도 문자열로 전달되기 때문에 형변환 필수
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		double height = Double.parseDouble(request.getParameter("height"));
		String[] food = request.getParameterValues("food");
		
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + address);
		System.out.println("키 : " + height);
		System.out.println("음식 종류 : " + Arrays.toString(food));
		
		/*
		 * 순수 Servlet : Java 코드에 HTML을 작성하는 형태
		 * JSP(java Server page) : HTML에 java 코드를 작성하는 형태
		 * 
		 * Servlet으로 응답페이지를 출력하는 작업을 jsp에게 전달하여 대신 처리할 수 있도록 한다.
		 * jsp페이지에서는 각 html 요소를 servlet 코드화 시켜서 컴파일 후 페이지를 띄워준다.
		 * 
		 * 이때 jsp페이지에 전달할 값이 있다면 해당 데이터들을 내장 객체에 담아서 전달해야한다.
		 * 사용할 영역 - request의 attribute영역 
		 * 사용 방법 - request.setAttribute("키","값")ㅣ 
		 * 
		 * 위와 같이 키-값 묶음으로 담아서 전달하게 된다.
		 * setAttribute(String,Object)
		 */
		
		//응답페이지로 데이터 전달하기
		request.setAttribute("name",name); 
		request.setAttribute("gender",gender);
		request.setAttribute("age", age);
		request.setAttribute("address", address);
		request.setAttribute("height",height);
		request.setAttribute("food", food);
		
		//키와 값의 이름은 달라도 상관없고 키의 이름은 자유롭게 작성해도 된다(통일성을 위해 같은 이름을 사용하는것뿐)
		//데이터를 담아주는 순서도 상관없다. key를 통해서 value를 추출하기 때문에
		//위와같이 담아준 데이터를 갖고있는 request 객체와 응답을 위한 객체인 response를
		//원하는 응답페이지에게 위임(포워딩)처리한다. 
		
		//응답하고자 하는 뷰(JSP)를 선택해서 요청 전달하기
		//이때 사용되는 객체 RequestDispatcher
		RequestDispatcher view = request.getRequestDispatcher("/views/responsePage.jsp");
		
		//응답 페이지로 이동시키기(위임 - 포워딩)
		view.forward(request, response); // request, response 객체 전달하며 요청 흐름 위임하기 
		
		
		//forward와 redirect 는 데이터를 어디까지 가져올것인지에 따라 달라짐. 
		
		/*
		 * 브라우저 주소창에는 "JSP 파일 경로"가 직접 안 보임
		 * 브라우저는 JSP파일 그 자체를 로딩하지 않음.
		 * 
		 * 대신 서블릿이 JSP를 forward해서 만들어낸 HTML 결과만 브라우저가 받음. 
		 * 
		 * 브라우저에 보이는 URL은 서블릿의 매핑 주소이고,
		 *	실제로 화면을 만드는 작업은 JSP가 한다
		 */
	}

}

/*
package com.kh.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/postTest")
public class RequestPostServlet extends HttpServlet {
  private static final long serivalVersionUID = 1L;
  
  public RequestPostServlet() {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at:").append(request.getContextPath());
  }  
  
  protected void doPost(HttpServletRequest request, HttpServletResponse) throws ServletException, IOException {
    System.out.println("포스트 요청완료");
    
    get방식은 header에서 오는데 post방식은 body에서 오기 때문에 Encoding방식을 지정해줘야함.
    
    POST 요청 방식은 HTTP body에 전달되어 인코딩 설정이 ISO-8859-1로 되어있기 때문에
    UTF-8 형태가 깨지게 된다. 때문에 POST 요청은 요청데이터를 추출하기 전 
    인코딩 설정부터 해야한다. 요청 객체인 request에 인코딩 설정.
    
    request.setCharacterEncoding("UTF-8");
    
    전달받은 데이터 추출하여 콘솔창에 출력해보기 
    String name = request.getParameter("userName");
    String gender = request.getParameter("gender");
    //숫자여도 문자열로 전달되기 때문에 형변환 필수
    int age = Integer.parseInt(request.getParameter("age"));
    String address = request.getParameter("address");
    double height = Double.parseDouble(request.getParameter("height"));
    String[] food = request.getParameterValues("food");
    
    System.out.println("이름 : " + name);
    System.out.println("성별 : " + gender);
    System.out.println("나이 : " + age);
    System.out.println("주소 : " + address);
    System.out.println("키 : " + height);
    System.out.println("음식 종류 : " + Arrays.toString(food)); 
    
    순수 Servlet : Java 코드에 HTML을 작성하는 형태
    JSP(java Server page) : HTML에 java 코드를 작성하는 형태
    
    Servlet으로 응답페이지를 출력하는 작업을 jsp에게 전달하여 대신 처리 할 수 있도록 한다.
    jsp페이지에서는 각 html 요소를 servlet 코드화 시켜서 컴파일 후 페이지를 띄워준다.
    
    이때 jsp페이지에 전달할 값이 있다면 해당 데이터들을 내장 객체에 담아서 전달해야한다.
    사용할 영역 - request의 attribute 영역
    사용 방법 - request.setAttribute("키","값")
    
    //응답 페이지로 데이터 전달하기
    request.setAttribute("name",name);
    request.setAttribute("gender",gender);
    request.setAttribute("age",age);
    request.setAttribute("address", address);
    request.setAttribute("height",height);
    request.setAttribute("food",food); 
    
    키와 값의 이름은 달라도 상관없고 키의 이름은 자유롭게 작성해도 된다(통일성을 위해 같은 이름을 사용하는것뿐)
    데이터를 담아주는 순서도 상관없다. key를 통해서 value를 추출하기 때문에
    위와같이 담아준 데이터를 갖고 있는 request 객체와 응답을 위한 객체인 response를 
    원하는 응답페이지에게 위임(포워딩)처리한다.
    
    응답하고자 하는 뷰(JSP)를 선택해서 요청 전달하기
    이때 사용되는 객체 RequestDispatcher
    RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
    
    //응답 페이지로 이동시키기(위임-포워딩)
    view.forward(request, response); // request, response 객체를 전달하며 요청 흐름 위임하기 
     
*/ 
 


