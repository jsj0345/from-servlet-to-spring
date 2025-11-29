package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 요청 경로를 받아 응답할 수 있도록 하는 어노테이션 : @WebServlet("요청경로")
 * 요청 경로 : url패턴
 * 요청할때 contextRoot 기준으로 뒤에 작성되어 요청되는 url경로(패턴)이고
 * 항상 / 로 시작하여 작성할것
 * 중복된 url 패턴이 있으면 오류 발생 - 각 서블릿에는 고유한 url패턴이 있어야한다.
 * 
 * Server로 넘어온 이후의 경로를 붙이는거임!! context root뒤에 / 로 시작하는것. 
 * 
 * 
 * 
 * 	결론부터: @WebServlet("/test") 는
 *	브라우저에서는 이렇게 호출된다
 *	http://localhost:8080/컨텍스트루트/test
 *
 *
 *	즉 → 컨텍스트 루트 뒤에 @WebServlet 안의 경로가 그대로 붙는다.
 */


@WebServlet("/test") // 요청할때 요청 매핑주소 (경로) 
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서블릿 추가할때 server 검색하고 라이브러리에 Apache Tomcat 추가. 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get방식 테스트");
		
		/**
		 * GET 방식으로 요청하면 doGet 메소드가 응답한다.
		 * 
		 * 첫번째 매개변수인 HttpServletRequest request에는 요청시 전달된 내용들이 담긴다.
		 * ex)사용자가 입력한 값, 요청 전송 방식, 요청한 사용자의 ip 등등
		 * 두번째 매개변수인 HttpServletResponse response에는 요청 처리 후 응답을 할 때 사용하는 객체가 담긴다.
		 * 
		 * 요청시에 전달된 값을 추출하는 방법
		 * request 객체의 parameter 영역 안에 존재하며 이는 key-value 세트로 담겨있다.
		 * 이때 key는 전달할때의 name 속성값이 담겨있고 value는 그 input 요소가 가지고 있던 value의 값이 담겨있음.
		 * 
		 * 해당 key값으로 value를 추출하는 메소드
		 * request.getParameter("키") : String(해당 key에 담긴 값 (value))
		 * -해당 메소드로 추출하면 문자열로 반환되기 때문에 다른 자료형이라면 파싱(형변환)처리를 해야한다.
		 * 
		 * request.getParameterValues("키") : String[] (해당 key 묶여담긴 value들)
		 * -하나의 key(name속성값)으로 여러개의 value를 받을 경우(체크박스) 문자열 배열 형태로 반환 받게 된다. 
		 */
		
		//전달받은 데이터 추출하여 자바 변수에 담아서 출력해보기 
		
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
		
		//service->dao-db
		//DB작업 등록을 수행하고 응답을 반환받았다고 가정하고 진행
		
		//헤더에서 시작해서 utf-8을 request에선 따로 설정할 필요가 없다. 
		
		//위 데이터를 응답화면으로 구성하여 보여주기
		
		//응답할 페이지의 형식과 인코딩을 설정
		response.setContentType("text/html; charset=UTF-8");
		
	    //응답하고자 하는 사용자와의 연결통로 준비 (스트림)
		//응답객체 response에서 응답 스트림 추출
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>"); 
		pw.println("<head>");
		pw.println("<title>Servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		pw.println("<h2>개인정보 응답 화면</h2>");
		pw.println("<span>"+name+"님은</span>");
		pw.println("<span>"+age+"살이고</span>");
		pw.println("<span>"+address+"에 사는 사람이며 </span>");		
		pw.println("<span>성별은 " + gender + "이고</span>");
		pw.println("<span>키는 " + height + "cm</span>");
		pw.println("<span>좋아하는 음식류는</span>");
		if(food==null) {
			pw.println("<span>없습니다.</span>");
		} else {
			pw.println("<ul>");
			
			for(int i = 0; i < food.length; i++) {
				pw.println("<li>" + food[i] + "</li>");
			}
			
			pw.println("</ul>");
		}
		
		pw.println("</body>");
		pw.println("</html>");
				
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

/*
package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

요청 경로를 받아 응답할 수 있도록 하는 어노테이션: @WebServlet("요청경로")
요청 경로 : url패턴
요청할때 contextRoot 기준으로 뒤에 작성되어 요청되는 url경로(패턴)이고
항상 / 로 시작하여 작성할것
중복된 url 패턴이 있으면 오류 발생 - 각 서블릿에는 고유한 url패턴이 있어야한다.
Server로 넘어온 이후의 경로를 붙이는거임!! context root 뒤에 /로 시작하는것. 

@WebServlet("/test") // 요청할때 요청 매핑주소 (경로)
public class RequestGetServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  
  public RequestGetServlet() {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("get방식 테스트");
    
    GET 방식으로 요청하면 doGet 메소드가 응답한다.
    
    첫번째 매개변수인 HttpServletRequest request 에는 요청시 전달된 내용들이 담긴다.
    ex)사용자가 입력한 값, 요청 전송 방식, 요청한 사용자의 ip등등
    두번째 매개변수인 HttpServletResponse response에는 요청 처리 후 응답을 할 때 사용하는 객체가 담긴다.
    
    요청시에 전달된 값을 추출하는 방법
    request 객체의 parameter 영역 안에 존재하며 이는 key-value 세트로 담겨있다.
    이때 key는 전달할때의 name 속성값이 담겨있고 value는 그 input 요소가 가지고 있던 value값이 담겨있음. 
    
    해당 key값으로 value를 추출하는 메소드
    request.getParameter("키") : String(해당 key에 담긴 값(value))
    -해당 메소드로 추출하면 문자열로 반환되기 때문에 다른 자료형이라면 파싱(형변환)처리를 해야한다.
    
    request.getParameterValues("키") : String[] (해당 key 묶여있는 value들)
    -하나의 key(name속성값)으로 여러개의 value를 받을 경우 (체크박스) 문자열 배열 형태로 받게 된다.
    
    //전달받은 데이터를 추출하여 자바 변수에 담아서 출력해보기 
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
    
    //응답할 페이지의 형식과 인코딩을 설정
    response.setContentType("text/html; charset=UTF-8");
    
    //응답하고자 하는 사용자와의 연결통로 준비 (스트림)
    //응답객체 response에서 응답 스트림 추출
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>"); 
		pw.println("<head>");
		pw.println("<title>Servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		pw.println("<h2>개인정보 응답 화면");
		pw.println("<span>"+name+"님은</span>");
		pw.println("<span>"+age+"살이고</span>");
		pw.println("<span>"+address+"에 사는 사람이며 </span>");		
		pw.println("<span>성별은 " + gender + "이고</span>");
		pw.println("<span>키는 " + height + "cm</span>");
		pw.println("<span>좋아하는 음식류는</span>");
		if(food==null) {
			pw.println("<span>없습니다.</span>");
		} else {
			pw.println("<ul>");
			
			for(int i = 0; i < food.length; i++) {
				pw.println("<li>" + food[i] + "</li>");
			}
			
			pw.println("</ul>");
		}
		
		pw.println("</body>");
		pw.println("<html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doGet(request,response); 
	} 	
}    
*/

  

