package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean isError = false;
		// 入力情報の取得・バリデーション
		String loginId = request.getParameter("login_id");
		request.setAttribute("loginId", loginId);

		if (loginId.isBlank()) {
			request.setAttribute("loginIdErrorMessage", "ログインIDが未入力です");
			isError = true;
		}
		String loginPass = request.getParameter("login_pass");
		if (loginPass.isBlank()) {
			request.setAttribute("loginPassErrorMessage", "ログインパスワードが未入力です");
			isError = true;
		}
		// ログインID・パスワードが未入力の場合は処理を中断
		if(isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			return;
		}
		// ログインID・パスワード入力済の場合、処理を続行

		UserDao userDao = DaoFactory.CreateUserDao();
		try {

			User user = userDao.findByLoginIdAndLoginPass(loginId, loginPass);
			// ユーザーIDとパスワード比較
			if (user != null) {
				// セッションにloginId,nameを保存
				request.getSession().setAttribute("loginId", user.getLoginId());
				request.getSession().setAttribute("name", user.getName());
				// boyakiにリダイレクト
				response.sendRedirect("boyaki");
			} else {
				request.setAttribute("errorMessage", "IDまたはパスワードが異なります。");
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);

		}

	}

}
