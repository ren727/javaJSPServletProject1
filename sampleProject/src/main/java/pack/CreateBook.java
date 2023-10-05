package pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateBook
 */
@WebServlet("/CreateBook")
public class CreateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 受け取る文字設定
		request.setCharacterEncoding("utf-8");
		// 送る文字設定(html文字;文字コード)
		response.setContentType("text/html;charset=utf-8");

		// オブジェクト指定して表示
		String type = request.getParameter("type");
		String size = request.getParameter("size");
		String breed = request.getParameter("breed");
		String name = request.getParameter("name");
		String memo = request.getParameter("memo");
		
		
			BookDAO book = new BookDAO();
			book.connect();
			book.createFavoriteBook(type, size, breed, name, memo );
			response.sendRedirect("/sampleProject/ReadUsers");
		}
	}



