package com.llm.a02mvc.a02mvcapp;
//一个Servlet对应多个请求
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llm.a02mvc.dao.A02CriteriaCustomer;
import com.llm.a02mvc.dao.A02CustomerDAO;
import com.llm.a02mvc.domain.Customer;


public class CustomerServlet extends HttpServlet {

	private A02CustomerDAO customerDAO = 
			CustomerDAOFactory.getInstance().getCustomerDAO();
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
/* 一个Servlet对应多个请求，实现方案一：
	
	下面这种实现方法的局限：
	1、要多一个方法或删一个方法，还得加case，后面也还得再加一个对应的方法；
	2、在请求里，url会把方法名暴露出来,不私密，有安全隐患,如：？method=add
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String method = request.getParameter("method");
		
		switch(method){
			case "add":    add(request, response); break;
			case "query":  query(request, response); break;
			case "delete": delete(request, response); break;
			case "update": update(request, response); break;
		}
	}
*/
	
//	一个Servlet对应多个请求，实现方案二：利用反射：
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1. 获取 ServletPath: /edit.do 或 /addCustomer.do
		String servletPath = req.getServletPath();

		//2. 去除 / 和 .do, 得到类似于 edit 或 addCustomer 这样的字符串
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);
		
		try {
			//3. 利用反射获取 methodName 对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, 
					HttpServletResponse.class);
			//4. 利用反射调用对应的方法
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			//可以有一些响应（如：客户要调用的方法不存在时的相应页面）.
			resp.sendRedirect("a02mvc_a02_error2.jsp");
		}
	}

	private void edit(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		
		String forwardPath = "/a02mvc_a02_error.jsp";
		
		//1. 获取请求参数 id
		String idStr = request.getParameter("id");
		
		//2. 调用 CustomerDAO 的 customerDAO.get(id) 获取和 id 对应的 Customer 对象 customer
		try {
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			if(customer != null){
				forwardPath = "/a02mvc_a02_updatecustomer.jsp";
				//3. 将 customer 放入 request 中
				request.setAttribute("customer", customer);
			}
		} catch (NumberFormatException e) {} 
		
		
		//4. 响应 updatecustomer.jsp 页面: 转发.
		request.getRequestDispatcher(forwardPath).forward(request, response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//1. 获取表单参数: id, name, address, phone, oldName
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String oldName = request.getParameter("oldName");
		
		//2. 检验 name 是否已经被占用:
		
		//2.1 比较 name 和 oldName 是否相同, 若相同说明 name 可用. 
		//2.1 若不相同, 则调用 CustomerDAO 的 getCountWithName(String name) 获取 name 在数据库中是否存在
		if(!oldName.equalsIgnoreCase(name)){
			long count = customerDAO.getCountWithName(name);
			//2.2 若返回值大于 0, 则响应 updatecustomer.jsp 页面: 通过转发的方式来响应 newcustomer.jsp
			if(count > 0){
				//2.2.1 在 updatecustomer.jsp 页面显示一个错误消息: 用户名 name 已经被占用, 请重新选择!
				//在 request 中放入一个属性 message: 用户名 name 已经被占用, 请重新选择!, 
				//在页面上通过 request.getAttribute("message") 的方式来显示
				request.setAttribute("message", "用户名" + name + "已经被占用, 请重新选择!");
				
				//2.2.2 newcustomer.jsp 的表单值可以回显. 
				//address, phone 显示提交表单的新的值, 而 name 显示 oldName, 而不是新提交的 name
				
				//2.2.3 结束方法: return 
				request.getRequestDispatcher("/a02mvc_a02_updatecustomer.jsp").forward(request, response);
				return;
			}
		}
		
		//3. 若验证通过, 则把表单参数封装为一个 Customer 对象 customer
		Customer customer = new Customer(name, address, phone);
		customer.setId(Integer.parseInt(id)); 
		
		//4. 调用 CustomerDAO 的  update(Customer customer) 执行更新操作
		customerDAO.update(customer);
		
		//5. 重定向到 query.do
		response.sendRedirect("query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取模糊查询的请求参数
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		//把请求参数封装为一个 CriteriaCustomer 对象
		A02CriteriaCustomer cc = new A02CriteriaCustomer(name, address, phone);
		
		//1. 调用 CustomerDAO 的 getForListWithCriteriaCustomer() 得到 Customer 的集合
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		
		//2. 把 Customer 的集合放入 request 中
		request.setAttribute("customers", customers);
		
		//3. 转发页面到 a02mvc_a02_index3_1.jsp(不能使用重定向)
		request.getRequestDispatcher("/a02mvc_a02_index3_1.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idStr = request.getParameter("id");
		int id = 0;
		
		//try ... catch 的作用: 防止 idStr 不能转为 int 类型
		//若不能转则 id = 0, 无法进行任何的删除操作. 
		try {
			id = Integer.parseInt(idStr);
			System.out.println(id); 
			customerDAO.delete(id);
		} catch (Exception e) {}
		
		response.sendRedirect("query.do");
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1. 获取表单参数: name, address, phone
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		//2. 检验 name 是否已经被占用:
		
		//2.1 调用 CustomerDAO 的 getCountWithName(String name) 获取 name 在数据库中是否存在
		long count = customerDAO.getCountWithName(name);
		
		//2.2 若返回值大于 0, 则响应 newcustomer.jsp 页面: 
		//通过转发的方式来响应 newcustomer.jsp
		if(count > 0){
			//2.2.1 要求再 newcustomer.jsp 页面显示一个错误消息: 用户名 name 已经被占用, 请重新选择!
			//在 request 中放入一个属性 message: 用户名 name 已经被占用, 请重新选择!, 
			//在页面上通过 request.getAttribute("message") 的方式来显示
			request.setAttribute("message", "用户名" + name + "已经被占用, 请重新选择!");
			
			//2.2.2 newcustomer.jsp 的表单值可以回显. 
			//通过 value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") %>"
			//来进行回显
			//2.2.3 结束方法: return 
			request.getRequestDispatcher("/a02mvc_a02_newcustomer.jsp").forward(request, response);
			return;
		}
		
		//3. 若验证通过, 则把表单参数封装为一个 Customer 对象 customer
		Customer customer = new Customer(name, address, phone);
		
		//4. 调用 CustomerDAO 的  save(Customer customer) 执行保存操作
		customerDAO.save(customer);
		
		//5. 重定向到 success.jsp 页面: 使用重定向可以避免出现表单的重复提交问题.  
		response.sendRedirect("a02mvc_a02_success.jsp");
		//request.getRequestDispatcher("/success.jsp").forward(request, response);
	}
}
