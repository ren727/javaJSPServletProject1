package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		ArrayList<String> errMessage = new ArrayList<String>();
		if (name.isEmpty()) {
			errMessage.add("名前入力をしてください");
		}
		if (type.isEmpty()) {
			errMessage.add("お気に入り書籍を入力してください");
		}
		if (size.isEmpty()) {
			errMessage.add("詳細を入力してください");
		}

		if (type.isEmpty() || size.isEmpty() || breed.isEmpty()) {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>確認画面</title>");
			for (String errw : errMessage) {
				out.println(errw);
			}
			out.println("</body>");
			out.println("</html>");
		} else {
			BookDAO book = new BookDAO();
			book.connect();
			book.updateUser(request.getParameter("type"), request.getParameter("size"),
					request.getParameter("breed"),
					request.getParameter("name"),
					request.getParameter("memo"));
					
			response.sendRedirect("/sampleProject/ReadUsers");
		}
	}

}

