package main.java.org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.java.org.example.model.GroupDto;
import main.java.org.example.model.StudentAttendanceDto;
import main.java.org.example.util.AttendanceNameUtil;
import main.java.org.example.util.DBService;

import java.io.*;
import java.util.List;

@WebServlet("/attendance")
public class StudentAttendanceServlet extends HttpServlet {

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
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        List<GroupDto> groupsList = DBService.getAllGroups();

        String filterGroupId = req.getParameter("filterGroupId");
        List<StudentAttendanceDto> list;

        if (filterGroupId != null && !filterGroupId.isEmpty()) {
            int groupId = Integer.parseInt(filterGroupId);
            list = DBService.getStudentsByGroupId(groupId);
        } else {
            list = DBService.getStudentsFromDB();
        }

        out.println("<html>");
        out.println("<head><title>Attendance</title></head>");
        out.println("<style>");
        out.println("table { width: 50%; border-collapse: collapse; margin: 20px 0; font-size: 18px; text-align: left; }");
        out.println("th, td { border: 1px solid black; padding: 8px; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("</style>");
        out.println("<body>");
        out.println("<h2>Посещение лекций</h2>");

        out.println("<form method='GET' action='/attendance'>");
        out.println("Фильтр по группе: ");
        out.println("<select name='filterGroupId'>");
        out.println("<option value=''>-- Все группы --</option>");
        for (GroupDto group : groupsList) {
            String selected = filterGroupId != null && filterGroupId.equals(String.valueOf(group.getId())) ? "selected" : "";
            out.println("<option value='" + group.getId() + "' " + selected + ">" + group.getName() + "</option>");
        }
        out.println("</select>");
        out.println("<input type='submit' value='Фильтровать'>");
        out.println("</form><br>");

        out.println("<form action='/attendance' method='POST'>");
        out.println("ФИО: <input type='text' name='name' required><br>");
        out.println("Группа: <input type='text' name='groupName' required><br>");
        out.println("Посетил: <select name='isAttended'><option value='true'>Yes</option><option value='false'>No</option></select><br>");
        out.println("<input type='submit' value='Добавить'>");
        out.println("</form><br>");

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ФИО</th>");
        out.println("<th>Группа</th>");
        out.println("<th>Посетил</th>");
        out.println("<th>Действие</th>");
        out.println("</tr>");

        if (list.isEmpty()) {
            out.println("<tr><td colspan='4'><strong>Нет данных</strong></td></tr>");
        } else {
            for (StudentAttendanceDto dto : list) {
                out.println("<tr>");
                out.println("<td>" + dto.getName() + "</td>");
                out.println("<td>" + dto.getGroupName() + "</td>");
                out.println("<td>" + AttendanceNameUtil.fromBooleanToString(dto.isAttended()) + "</td>");
                out.println("<td>");
                out.println("<form method='POST' action='/attendance/delete' style='display:inline;'>");
                out.println("<input type='hidden' name='id' value='" + dto.getId() + "'>");
                out.println("<input type='submit' value='Удалить'>");
                out.println("</form>");
                out.println("</td>");
                out.println("</tr>");
            }
        }

        out.println("</table>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StudentAttendanceDto newStudentAttendanceInfo = StudentAttendanceDto.builder()
                .name(req.getParameter("name"))
                .groupName(req.getParameter("groupName"))
                .isAttended(Boolean.parseBoolean(req.getParameter("isAttended")))
                .build();

        DBService.addStudentToDB(newStudentAttendanceInfo);
        resp.sendRedirect("/attendance");
    }
}
