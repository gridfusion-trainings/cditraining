package logic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mpalotas on 18/03/14.
 */
public class InputProcessor extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String first = request.getParameter("firstname");
        String last = request.getParameter("lastname");
        String dob = request.getParameter("dateofbirth");

        Calculator calc = new Calculator();
        String fullname = calc.calculateName(first, last);
        int length = calc.calculateNumberOfChars(fullname);
        int days = calc.calculateDaysAlive(dob);
        //String daysalive = days.toString();

        request.setAttribute("fullname", fullname);
        request.setAttribute("length", "99"); //TODO: remove hardcoding
        request.setAttribute("dob", dob);
        request.setAttribute("daysalive", "20"); //TODO: remove hardcoding
        RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
        disp.forward(request, response);
    }

}

