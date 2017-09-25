package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {   
    String firstStr = request.getParameter("first");
    String secondStr = request.getParameter("second");
    String operation = request.getParameter("operation");
    
    int result=0;
    
    if (operation!=null)
    {
        if (firstStr!=null && secondStr!=null && !firstStr.equals("") && !secondStr.equals(""))
        {
            int first = Integer.parseInt(firstStr);
            int second = Integer.parseInt(secondStr);
            
            char operationType = operation.charAt(0);
            
            switch (operationType)
            {
                case '+': result = first + second;
                    break;
                case '-': result = first - second;
                    break;
                case '*': result = first * second;
                    break;
                case '%': result = first % second;
                    break;
            }
            
            request.setAttribute("calcPerformed", result);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
