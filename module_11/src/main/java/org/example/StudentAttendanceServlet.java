package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.StudentAttendanceDto;
import org.example.util.AttendanceNameUtil;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@WebServlet("/attendance")
public class StudentAttendanceServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<StudentAttendanceDto> list = getStudentsFromDB();

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<style>  table {\n" +
                "            width: 50%;\n" +
                "            border-collapse: collapse;\n" +
                "            margin: 20px 0;\n" +
                "            font-size: 18px;\n" +
                "            text-align: left;\n" +
                "        }\n" +
                "        th, td {\n" +
                "            border: 1px solid black;\n" +
                "            padding: 8px;\n" +
                "        }\n" +
                "        th {\n" +
                "            background-color: #f2f2f2;\n" +
                "        }");
        out.println("</style>");
        out.println("<body>");
        out.println("<h2>Посещение лекций</h2>");

        out.println("<form action='/ServletPractice/attendance' method='POST'>");
        out.println("ФИО: <input type='text' name='name' required><br>");
        out.println("Группа: <input type='text' name='groupName' required><br>");
        out.println("Посетил: <select name='isAttended'><option value='true'>Да</option><option value='false'>Нет</option></select><br>");
        out.println("<input type='submit' value='Добавить'>");
        out.println("</form>");

        out.println("<table>");
        out.println("    <tr>\n" +
                "            <th>ФИО</th>\n" +
                "            <th>Группа</th>\n" +
                "            <th>Посетил</th>\n" +
                "        </tr>");
        if (list.isEmpty()) {
            out.println("</table>");
            out.println("<h1>Нет данных в таблице<h1>");
        }
        for (StudentAttendanceDto studentAttendanceDto : list) {
            out.println("   <tr>\n" +
                    "            <td>" + studentAttendanceDto.getName() + "</td>\n" +
                    "            <td>" + studentAttendanceDto.getGroupName() + "</td>\n" +
                    "            <td>" + AttendanceNameUtil.fromBooleanToString(studentAttendanceDto.isAttended()) + "</td>\n" +
                    "        </tr>");
        }
        out.println("</table>");
    }

    private List<StudentAttendanceDto> getStudentsFromDB() {
        String sql = "Select * from students";
        List<StudentAttendanceDto> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                StudentAttendanceDto dto = StudentAttendanceDto.builder()
                        .name(rs.getString("name"))
                        .groupName(rs.getString("group_name"))
                        .isAttended(rs.getBoolean("is_attended"))
                        .build();
                result.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        StudentAttendanceDto newStudentAttendanceInfo  = StudentAttendanceDto.builder()
//                .name(req.getParameter("name"))
//                .groupName(req.getParameter("groupName"))
//                .isAttended(Boolean.parseBoolean(req.getParameter("isAttended")))
//                .build();
//        list.add(newStudentAttendanceInfo);
//        saveToFile(newStudentAttendanceInfo);
//
//        resp.sendRedirect("/ServletPractice/attendance");
    }
}
