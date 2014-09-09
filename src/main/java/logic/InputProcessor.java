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
        int length=0;
        //String dob = request.getParameter("dateofbirth");

        Calculator calc = new Calculator();
        String fullname=null;
		try {
			fullname = calc.calculateName(first, last);
	        length = calc.calculateNumberOfChars(fullname);
		} catch (InputIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int days=0;
        
        /*
		try {
			days = calc.calculateDaysAlive(dob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

        request.setAttribute("fullname", fullname);
        request.setAttribute("length", length); 
        //request.setAttribute("dob", dob);
        //request.setAttribute("daysalive", days);
        RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
        disp.forward(request, response);
    }

}

