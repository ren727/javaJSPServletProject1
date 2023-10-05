import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import bean.animalDto;

@WebServlet("/showAnimal")
public class Controller extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res)
   throws IOException, ServletException {

    String type = req.getParameter("type");
    String animalNo = req.getParameter("animalNo");
    // DAOを生成
    animalDao adao = new animalDao();

    // 全件検索した結果をDTOオブジェクトとして取得
    animalDto adto = adao.select(type, animalNo);

    // 検索結果をリクエストスコープに格納
    req.setAttribute("adto", adto);

    //JSPに転送
    RequestDispatcher rd = req.getRequestDispatcher("/result.jsp");
    rd.forward(req, res);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res)
   throws IOException, ServletException {
    doPost(req, res);
  }
}
