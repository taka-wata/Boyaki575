package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoyakiDao;
import dao.DaoFactory;
import domain.Boyaki;

/**
 * Servlet implementation class BoyakiWriteServlet
 */
@WebServlet("/boyakiWrite")
public class BoyakiWriteServlet extends HttpServlet {
	private static final String NAMELESS = "詠み人知らず";
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
		boyaki.setUpper(request.getParameter("upper"));
		boyaki.setMiddle(request.getParameter("middle"));
		boyaki.setLower(request.getParameter("lower"));
		boyaki.setIsSecret(Boolean.parseBoolean(request.getParameter("isSecret")));
		
		// BoyakiDao作成
		BoyakiDao boyakiDao = DaoFactory.CreateBoyakiDao();
		
		// ぼやきをDBに反映
	}

}
