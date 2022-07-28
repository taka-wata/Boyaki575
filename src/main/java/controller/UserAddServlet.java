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
			// バリデーション処理
			Boolean isError = false;
			UserDao userDao = DaoFactory.CreateUserDao();
			// 入力情報の取得・バリデーション
			String loginId = request.getParameter("loginId");
			request.setAttribute("loginId", loginId);

			if (loginId.isBlank()) {
				request.setAttribute("loginIdErrorMessage", "ログインIDが未入力です");
				isError = true;
			}
			if (userDao.findId(loginId) != null ) {
				request.setAttribute("loginIdErrorMessage", "ログインIDが重複しています");
				isError = true;
			}
			
			String loginPass = request.getParameter("loginPass");
			if (loginPass.isBlank()) {
				request.setAttribute("loginPassErrorMessage", "ログインパスワードが未入力です");
				isError = true;
			}
			
			String name = request.getParameter("name");
			if (name.isBlank()) {
				request.setAttribute("nameErrorMessage", "名前が未入力です");
				isError = true;
			}
			
			// ログインID・パスワード・名前が未入力の場合は処理を中断
			if(isError == true) {
				request.getRequestDispatcher("/WEB-INF/view/userAdd.jsp").forward(request, response);
				return;
			}
			// 入力済の場合、処理を続行

			user.setLoginId(request.getParameter("loginId"));
			// PW暗号化
			String hashed = BCrypt.hashpw(request.getParameter("loginPass"), BCrypt.gensalt());
			user.setLoginPass(hashed);
			user.setName(request.getParameter("name"));
			// UserDao作成
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
