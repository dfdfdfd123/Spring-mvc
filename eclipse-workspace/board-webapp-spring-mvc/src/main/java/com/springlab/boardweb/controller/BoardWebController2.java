package com.springlab.boardweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springlab.biz.board.BoardDAO;
import com.springlab.biz.board.BoardVO;
import com.springlab.biz.board.impl.BoardDAOImpl;
import com.springlab.biz.user.UserDAO;
import com.springlab.biz.user.UserVO;
import com.springlab.biz.user.impl.UserDAOImpl;

/**
 * Servlet implementation class BoardWebController
 */
@WebServlet("/s/*")
public class BoardWebController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AbstractApplicationContext iocContainer = null;
	private MyViewResolver viewResolver = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWebController2() {
        super();

        iocContainer = new ClassPathXmlApplicationContext(
						"com/springlab/boardweb/controller/dispatcher-config.xml");
        
        viewResolver = iocContainer.getBean(MyViewResolver.class);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
				
		// step #2. data processing
		HttpSession session = request.getSession();
		
		String urlPath = request.getPathInfo();
//		System.out.println(">>> " + urlPath);
		String viewName = null;
		
		MyController controller = (MyController)iocContainer.getBean(urlPath);
		if (controller != null) {
			viewName = controller.handleRequest(request, response);
		}
				
		// step #3. output results
		if (viewName == null) {
			viewName = "login";
		}
		
		if (viewName.startsWith("redirect:")) {
			response.sendRedirect(viewName.substring(9));
		}
		else {
			viewName = viewResolver.resolve(viewName);
			
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
