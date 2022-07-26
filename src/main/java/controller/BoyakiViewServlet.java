package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoyakiDao;
import dao.DaoFactory;
import dao.UserDao;
import domain.Boyaki;
import domain.User;

/**
 * Servlet implementation class BoyakiServlet
 */
@WebServlet("/boyaki")
public class BoyakiViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoyakiViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Boyaki> boyakiList = new ArrayList<>();
		Date goodTime = null;
		try {
			UserDao userDao = DaoFactory.CreateUserDao();

			// セッションからいいね！したユーザーを取得
			Integer UserId = userDao.findId((String) request.getSession().getAttribute("loginId"));
			User user = userDao.findById(UserId);

			// 現在の年月日といいね！した年月日を取得(時間は取得しない)
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			now = cal.getTime();

			// まだいいね！をしていない場合は、いいね！ボタンを有効化
			if (user.getGoodTime() == null) {
				request.setAttribute("goodIsPossible", "true");
			} else {
				// 最後にいいね！をした年月日を取得(時間は取得しない)
				cal.setTime(user.getGoodTime());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				cal.set(Calendar.MILLISECOND, 0);
				goodTime = cal.getTime();
				// いいね！後日付が変わっている場合は、いいね！ボタンを有効
				if (now.after(goodTime)) {
					request.setAttribute("goodIsPossible", "true");
				} else {
					request.setAttribute("goodIsPossible", "false");
				}
			}

			BoyakiDao boyakiDao = DaoFactory.CreateBoyakiDao();
			boyakiList = boyakiDao.findAll();
			request.setAttribute("boyakiList", boyakiList);
			request.getRequestDispatcher("/WEB-INF/view/boyaki.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boyaki boyaki = new Boyaki();
		try {
			// いいね！ボタンを押された時の処理
			String strId = request.getParameter("goodId");
			Integer id = Integer.parseInt(strId);

			// boyakiDao、UserDao作成
			BoyakiDao boyakiDao = DaoFactory.CreateBoyakiDao();
			UserDao userDao = DaoFactory.CreateUserDao();
			// idより該当のぼやきをDBから取得
			boyaki = boyakiDao.findById(id);

			// セッションからいいね！したユーザーを取得
			Integer UserId = userDao.findId((String) request.getSession().getAttribute("loginId"));
			// 現在時刻の取得
			Date date = new Date();

			// ユーザーのGoodTimeを更新し、Update
			userDao.updateGoodTime(UserId, date);

			// いいね！カウントを+1してDBに反映
			boyakiDao.addGoodsCount(id, boyaki.getGoodsCount());
			request.setAttribute("goodIsPossible", "false");
			// リダイレクト
			response.sendRedirect(request.getContextPath() + "/boyaki");

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
