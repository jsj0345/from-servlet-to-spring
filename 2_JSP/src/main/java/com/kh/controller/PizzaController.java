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
 * Servlet implementation class PizzaController
 */
@WebServlet("/order.pz")
public class PizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PizzaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 요청은 인코딩 처리 
		//setAttribute -> 서버에서 JSP로 값 넘기기 위한 단순한 상태 저장소. 
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");
		String pizza = request.getParameter("pizza");
		String[] topping = request.getParameterValues("topping");
		String[] side = request.getParameterValues("side");
		String payment = request.getParameter("payment"); 
		
		// 선택에 따라서 메뉴 결제 가격 처리하기
		
		int price = 0;
		
		//피자 메뉴에 따른 가격 처리 
		switch(pizza) {
			case "콤비네이션 피자": price += 15000; break;
			case "불고기 피자" : price += 13000; break;
			case "하와이안 피자" : price += 13000; break;
			case "치즈 피자" : price += 12000; break; 
			
		}
		
		//토핑 가격 추가 (null값 처리)
		if(topping!=null) { //선택했다면
			
			//여러개 선택 가능하니 반복문으로 처리하기
			for(String top : topping) {
				switch(top) {
				    case "치즈크러스트" : price+=3000; break;
				    case "치즈바이트" : price+=3500; break;
				    case "파인애플토핑" : price+=2500; break;
				    case "불고기토핑" : price+=2000; break;
				    case "크림치즈바이트" : price+=4000; break; 
				}
			}
			
		}
		
		//사이드 가격 추가 (null값 처리)
		if(side!=null) { //선택했다면
			//여러개 선택 가능하니 반복문으로 처리하기
			for(String s : side) {
				switch(s) {
				   case "콜라" : 
				   case "사이다" : price+=3000; break;
				   case "갈릭소스" :
				   case "핫소스" :
				   case "피클" : price += 500; break; 
				}
			}
			
		}
		
		
		
		
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("주소 : " + address);
		System.out.println("요청사항 : " + message);
		System.out.println("피자 : " + pizza);
		System.out.println("토핑 : " + Arrays.toString(topping));
		System.out.println("사이드 : "+ Arrays.toString(side));
		System.out.println("결제방식 : " + payment);
		
		request.setAttribute("name",name);
		request.setAttribute("phone",phone);
		request.setAttribute("address",address);
		request.setAttribute("message", message);
		request.setAttribute("pizza", pizza);
		request.setAttribute("side", side);
		request.setAttribute("payment", payment);
		request.setAttribute("topping", topping);
		request.setAttribute("price", price);
		
		
		//데이터를 담아주었으니 응답페이지 경로를 지정하며 RequestDispatcher 객체 생성. 
		RequestDispatcher view = request.getRequestDispatcher("/views/pizzaPayment.jsp");
		//JSP파일은 웹 브라우저에서 경로는 안보이지만 실제로 잘 돌아감. 
		
		
		view.forward(request, response);
		
		
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

 
@WebServlet("/order.pz")
public class PizzaController extends HttpServlet {
  
   private static finla long serialVersionUID = 1L;
   
   public PizzaController(){
     super();
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
     
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
     //post 요청은 인코딩 처리 (왜냐? 헤더부에서 시작이 아닌 바디부 시작)
     request.setCharacterEncoding("UTF-8");  
       
     String name = request.getParameter("userName");
     String phone = request.getParameter("phone");
     String address = request.getParameter("address");
     String message = request.getParameter("message");
     
     String pizza = request.getParameter("pizza");
     String[] topping = request.getParameter("topping");
     String[] side = request.getParameter("side");
     String payment = request.getParameter("payment"); 
     
     //선택에 따라서 메뉴 결제 가격 처리하기
     
     int price = 0;
     
     //피자 메뉴에 따른 가격 처리
     switch(pizza) {
       case "콤비네이션 피자" : price += 15000; break;
       case "불고기 피자": price+= 13000; break;
       case "하와이안 피자": price+=13000; break;
       case "치즈 피자": price+=12000; break;
     
     }
     
     //토핑 가격 추가 (null값 처리)
     if(topping!=null) { //토핑을 선택했다면
     
        //여러개 선택 가능하니 반복문으로 처리하기
        for(String top : topping) {
           switch(top) {
              case "치즈크러스트" : price+=3000; break;
              case "치즈바이트" : price+=3500; break;
              case "파인애플토핑" : price+=2500; break;
              case "불고기토핑" : price+=2000; break;
              case "크림치즈바이트" : price+=4000; break; 
           }
        }
     
     }
     
     //사이드 가격 추가(null값 처리)
     if(side!=null) { // 선택했다면
        //여러개 선택 가능하니 반복문으로 처리하기
        for(String s : side) {
           switch(s) {
             case "콜라":
             case "사이다": price+=3000; break;
             case "갈릭소스":
             case "핫소스":
             case "피클": price+=500; break;
           }
        
        
        }
     }
     
     System.out.println("이름 : " + name);
     System.out.println("전화번호 : " + phone);
     System.out.println("주소 : " + address);
     System.out.println("요청사항 : " + message);
     System.out.println("피자 : " + pizza);
     System.out.println("토핑 : " + Arrays.toString(topping));
     System.out.println("사이드 : " + Arrays.toString(side));
     System.out.println("결제방식 : " + payment);
     
     request.setAttribute("name",name);
     request.setAttribute("phone",phone);
     request.setAttribute("address",address);
     request.setAttribute("message",message);
     request.setAttribute("pizza",pizza);
     request.setAttribute("payment",payment);
     request.setAttribute("topping", topping);
     request.setAttribute("price",price); 
     
     //데이터를 담아주었으니 응답페이지 경로를 지정하며 RequestDispatcher 객체 생성.
     RequestDispatcher view = request.getRequestDispatcher("/views/pizzaPayment.jsp");
     //JSP 파일은 웹 브라우저에서 경로는 안보이지만 실제로 잘 돌아감.
     
     view.forward(request,response); 
     
     //위임. 
     
     
   
   
   
*/ 
