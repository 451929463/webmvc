package cn.tri.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tri.web.pojo.User;
import cn.tri.web.service.UserService;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-------------doGet--------------");
		UserService us = new UserService();
		request.setAttribute("list", us.find());
		request.getRequestDispatcher("/user.jsp").forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("-------------doPost--------------");
		req.setCharacterEncoding("utf-8");
		String func = req.getParameter("function");
		System.out.println(func);
		switch (func) {
		case "register":
			String name = req.getParameter("uname");
			String pwd = req.getParameter("pwd1");
			File file = new File("D:\\a.txt");
			User user = new User(name, pwd);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(user);
			oos.close();
			
			System.out.println("----------register end---------");
			break;
		
		case "login":
			String lname = req.getParameter("uname1");
			String lpwd = req.getParameter("pwd");
			FileInputStream fis = new FileInputStream(new File("D:\\a.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				User u = (User) ois.readObject();
				System.out.println(u);
				if(u.getName().equals(lname) && u.getPassword().equals(lpwd)){
					System.out.println("success");
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				}else{
					System.out.println("fail");
					req.setAttribute("error", "<script>alert('’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°£°£°');</script>");
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("----------login end---------");
			break;
		default:
			break;
		}
	}

}
