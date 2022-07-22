package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/userAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		try {
			user.setLoginId(request.getParameter("loginId"));
			// PW暗号化
			String hashed = BCrypt.hashpw(request.getParameter("loginPass"), BCrypt.gensalt());
			user.setLoginPass(hashed);
			user.setName(request.getParameter("name"));
			// UserDao作成
			UserDao userDao = DaoFactory.CreateUserDao();
			userDao.insert(user);
			
			// ログイン処理
			request.getSession().setAttribute("loginId", user.getLoginId());
			request.getSession().setAttribute("name", user.getName());

			request.getRequestDispatcher("/WEB-INF/view/userAddDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
