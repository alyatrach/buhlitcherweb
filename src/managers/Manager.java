package managers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilsAndData.JDBC;

/**
 * Servlet implementation class DBadmin
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JDBC matchDataJDBCTemplate = null;
    private Jedis jedis = null; ////

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager() {
        super();
    }

    public void init() throws ServletException {
        matchDataJDBCTemplate = new JDBC();
        jedis = new Jedis("localhost"); ////
        System.out.println("matchDataJDBCTemplate=" + matchDataJDBCTemplate);
        matchDataJDBCTemplate.createTables();
        System.out.println("table created or already exist");
        getServletContext().setAttribute("jedis", jedis); // //
        getServletContext().setAttribute("matchDataJDBCTemplate",
                matchDataJDBCTemplate); // //
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        System.out.println("IN doGet");
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        System.out.println("IN processRequest");
        response.setContentType("text/html;charset=UTF-8");
        getServletContext().getRequestDispatcher("/checkemailandpassword").forward(request,
                response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}