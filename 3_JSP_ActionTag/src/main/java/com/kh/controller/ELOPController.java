package com.kh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.vo.Student;

@WebServlet("/operation.do")
public class ELOPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ELOPController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("big", 10);
		request.setAttribute("small", 3);
		
		request.setAttribute("sOne", "안녕");
		request.setAttribute("sTwo", new String("안녕"));
		
		request.setAttribute("student", new Student("김학생",30,"남자"));
		request.setAttribute("student2", null);
		
		ArrayList<String> list = new ArrayList<>();
		request.setAttribute("list", list);
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("추가된 값");
		request.setAttribute("list2", list2);
		
		//페이지 이동(위임)
		request.getRequestDispatcher("/WEB-INF/views/1_EL/02_operation.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

/*
package com.kh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.vo.Student;

@WebServlet("/operation.do")

public class ELOPController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ELOPController() {
        super();
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
      request.setAttribute("big",10);
      request.setAttribute("small",3);
      
      request.setAttribute("sOne","안녕");
      request.setAttribute("sTwo",new String("안녕"));
      
      request.setAttribute("student", new Student("김학생",30,"남자"));
      request.setAttribute("student2", null);
      
      ArrayList<String> list = new ArrayList<>();
      request.setAttribute("list",list);
      
      ArrayList<String> list2 = new ArrayList<>();
      list2.add("추가된 값");
      request.setAttribute("list2",list2);
      
      //페이지 이동(위임)
      request.getRequestDispatcher("/WEB-INF/views/1_EL/02_operation.jsp").forward(request, response);   
      
    
    }
*/
