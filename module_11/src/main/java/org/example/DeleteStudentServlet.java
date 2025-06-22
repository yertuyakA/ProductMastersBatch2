package main.java.org.example;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import main.java.org.example.util.DBService;

import java.io.IOException;

@WebServlet("/attendance/delete")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                DBService.deleteStudentById(id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        resp.sendRedirect("/attendance");
    }
}
