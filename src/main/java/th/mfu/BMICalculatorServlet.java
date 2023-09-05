package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        
        //TODO: calculate bmi

        //TODO: determine the built from BMI
      
        //TODO: add bmi and built to the request's attribute

        //TODO: forward to jsp
        double weight = Double.parseDouble(req.getParameter("weight").trim());
        double height = Double.parseDouble(req.getParameter("height").trim());
        float bmi = Math.round(weight/Math.pow(height,2));
        String build;
        if (bmi < 18.5) {
            build = "underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            build = "normal";
        } else if (bmi >= 25 && bmi < 30) {
            build = "overweight";
        } else if (bmi >= 30 && bmi < 35) {
            build = "obese";
        } else {
            build = "extremely Obese";
        }
        req.setAttribute("bmi", bmi);
        req.setAttribute("build", build);
        req.getRequestDispatcher("bmi_result.jsp").forward(req, res);
    
           
    }
    
}
