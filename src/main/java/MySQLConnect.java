import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "MySQLConnect")
public class MySQLConnect extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        System.out.format("Trying with username: %s\npassword: %s\n ", user,pass);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/room_booking", "root", "root");
            PreparedStatement pst = conn.prepareStatement("Select * from user where username=? and password=?");
            PreparedStatement pst2 = conn.prepareStatement("Select * from user");
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                //out.println("Correct login credentials");
                System.out.println("Success!");
                //
                request.getRequestDispatcher("example.html").include(request, response);
                HttpSession session = request.getSession();
                session.setAttribute("name", user);
                //out.print("Successfully logged in!");
            }
            else {
                System.out.println("Failure!");
                out.print("Sorry, username or password error!");
                //response.sendRedirect("/welcomepage.html");
                request.getRequestDispatcher("login.html").include(request, response);
                //out.println("Incorrect login credentials")
            }

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        out.close();

    }
}
