package logic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mpalotas on 18/03/14.
 */
public class MainProcessor extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String first = request.getParameter("firstname");
        String last = request.getParameter("lastname");
        int length=0;

        Calculator calc = new Calculator();
        String fullname=null;
		try {
			fullname = calc.calculateName(first, last);
	        length = calc.calculateNumberOfChars(fullname);
		} catch (InputIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        request.setAttribute("fullname", fullname);
        request.setAttribute("length", length); 
        RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
        disp.forward(request, response);
    }

}

