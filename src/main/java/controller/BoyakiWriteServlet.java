package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoyakiDao;
import dao.DaoFactory;
import dao.UserDao;
import domain.Boyaki;

/**
 * Servlet implementation class BoyakiWriteServlet
 */
@WebServlet("/boyakiWrite")
public class BoyakiWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoyakiWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/writeBoyaki.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String buttonPush = request.getParameter("button");
		if (buttonPush.equals("write")) {
			Boyaki boyaki = new Boyaki();
			Boolean isError = false;
			// 値の取得・バリデーション処理
			try {
				String upper = request.getParameter("upper");
				String middle = request.getParameter("middle");
				String lower = request.getParameter("lower");
				// 再表示用
				request.setAttribute("upper", upper);
				request.setAttribute("middle", middle);
				request.setAttribute("lower", lower);

				if (upper.isBlank()) {
					request.setAttribute("upperErrorMessage", "上の句が未入力です");
					isError = true;
				} else if (upper.length() > 6) {
					request.setAttribute("upperErrorMessage", "上の句は6文字以内で入力してください。");
					isError = true;
				}

				if (middle.isBlank()) {
					request.setAttribute("middleErrorMessage", "中の句が未入力です");
					isError = true;
				} else if (middle.length() > 8) {
					request.setAttribute("middleErrorMessage", "中の句は8文字以内で入力してください。");
					isError = true;
				}

				if (lower.isBlank()) {
					request.setAttribute("lowerErrorMessage", "下の句が未入力です");
					isError = true;
				} else if (lower.length() > 6) {
					request.setAttribute("lowerErrorMessage", "下の句は6文字以内で入力してください。");
					isError = true;
				}

				String strIsSecret = request.getParameter("nameIsSecret");
				Boolean isSecret = false;
				if (strIsSecret.equals("true")) {
					isSecret = true;
				}
				boyaki.setIsSecret(isSecret);

				// error検出時、処理を中断しフォワード
				if (isError == true) {
					request.getRequestDispatcher("/WEB-INF/view/writeBoyaki.jsp").forward(request, response);
					return;
				}

				// 値が正常ならboyakiに格納
				boyaki.setUpper(upper);
				boyaki.setMiddle(middle);
				boyaki.setLower(lower);
				UserDao userDao = DaoFactory.CreateUserDao();
				// セッションからloginIdを取得し、それをもとにidを取得する
				Integer UserId = userDao.findId((String) request.getSession().getAttribute("loginId"));
				boyaki.setUserId(UserId);
				// BoyakiDao作成
				BoyakiDao boyakiDao = DaoFactory.CreateBoyakiDao();
				// ぼやきをDBに反映
				boyakiDao.insert(boyaki);

				// フォワード
				request.getRequestDispatcher("/WEB-INF/view/boyakiWriteDone.jsp").forward(request, response);

			} catch (

			Exception e) {
				throw new ServletException(e);
			}
		} else if (buttonPush.equals("random")) {
			try {
				BoyakiDao boyakiDao = DaoFactory.CreateBoyakiDao();
				// ぼやき総数を取得
				Integer count = boyakiDao.getCount();

				// １～countまでの乱数生成
				Integer randomUpperId = (int) ((Math.random() * count) + 1);
				Integer randomMiddleId = (int) ((Math.random() * count) + 1);
				Integer randomLowerId = (int) ((Math.random() * count) + 1);

				// 乱数に対応した上の句、中の句、下の句を取得
				String upper = boyakiDao.findById(randomUpperId).getUpper();
				String middle = boyakiDao.findById(randomMiddleId).getMiddle();
				String lower = boyakiDao.findById(randomLowerId).getLower();

				// セッションに格納
				request.setAttribute("upper", upper);
				request.setAttribute("middle", middle);
				request.setAttribute("lower", lower);

				// フォワード
				request.getRequestDispatcher("/WEB-INF/view/writeBoyaki.jsp").forward(request, response);

			} catch (Exception e) {
				throw new ServletException(e);

			}

		}

	}

}
