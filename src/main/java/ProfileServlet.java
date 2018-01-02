import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();



        HttpSession session=request.getSession(false);
        System.out.println(session);

        if(session!=null) {
            request.getRequestDispatcher("links.html").include(request, response);
            String name = (String) session.getAttribute("name");

            out.print("Hello, " + name + " Welcome to Profile");
        }
        else{
            request.getRequestDispatcher("index.jsp").include(request, response);
            out.print("Please login first");
        }
        out.close();
    }
}
