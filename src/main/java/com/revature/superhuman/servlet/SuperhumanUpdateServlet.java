package com.revature.superhuman.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.superhuman.pojo.Superhuman;
import com.revature.superhuman.service.SuperhumanService;
import com.revature.superhuman.service.SuperhumanServiceImpl;

public class SuperhumanUpdateServlet extends HttpServlet {

	SuperhumanService superService = new SuperhumanServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Superhuman sh = new Superhuman();
		
		sh.setSuperName(req.getParameter("supname"));
		sh.setAlias(req.getParameter("alias"));
		sh.setHometown(req.getParameter("home"));
		sh.setMainPower(req.getParameter("power"));
		
		try {
			sh.setAlignment(Integer.parseInt(req.getParameter("align")));
		} catch (NumberFormatException e) {
			return;
		}
		
		superService.updateASuperhuman(req.getParameter("suptoupdate"), sh);
		
		resp.sendRedirect("SuperhumanMain.html");
	}
}
