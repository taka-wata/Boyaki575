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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/writeBoyaki.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boyaki boyaki = new Boyaki();
		// 値の取得
		try {
		boyaki.setUpper(request.getParameter("upper"));
		boyaki.setMiddle(request.getParameter("center"));
		boyaki.setLower(request.getParameter("lower"));
		
		// チェックボックスがOnならTrue,それ以外ならfalse
		String strIsSecret = request.getParameter("isSecret");
		if (strIsSecret == "on") {
			boyaki.setIsSecret(true);			
		} else {
			boyaki.setIsSecret(false);
		}
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
		
		} catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

}
