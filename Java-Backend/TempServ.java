import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/temps")

public class TempServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String one = req.getParameter("one");
        one = one == null ? "" : one.replaceAll("<", "&lt;").replaceAll(">", "&gt;"); //prevent XSS attacks
        resp.getWriter().write("<html>" +
            "<head></head>" +
            "<body>" +
            "one = " + one +
            "<form action = 'temps' method = 'post'>" +
            "<textarea name = 'one'></textarea>" +
            "<input type = 'submit' name = 'submit'/>" +
            "</form>" +
            "</body>" +
            "</html>");


       /* String one = req.getParameter("one");
        String two = req.getParameter("two");
        System.out.println(one);
        System.out.println(two);*/


  /*      String[] ones = req.getParameterValues("one");

        for(String s : ones){
            System.out.println(s);
        }*/


     /*   Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }

        Map<String, String[]> parameterMap = req.getParameterMap();*/

       // System.out.println(req.getQueryString()); //get parameters string (one=hello&abc=123)

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}