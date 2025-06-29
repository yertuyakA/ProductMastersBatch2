package main.java.org.example.util;

import main.java.org.example.model.GroupDto;
import main.java.org.example.model.StudentAttendanceDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "said";
    private static final String DB_PASSWORD = "postgres";

    public static void addStudentToDB(StudentAttendanceDto student) {
        Integer groupId = getGroupIdByName(student.getGroupName());

        if (groupId == null) {
            System.out.println("Группа не найдена: " + student.getGroupName());
            return;
        }

        String sql = "INSERT INTO student(name, group_id, attended) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, groupId);
            ps.setBoolean(3, student.isAttended());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static List<StudentAttendanceDto> getStudentsFromDB() {
        String sql = "Select * from student";
        List<StudentAttendanceDto> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                StudentAttendanceDto dto = StudentAttendanceDto.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .groupName(rs.getString("group_id"))
                        .isAttended(rs.getBoolean("attended"))
                        .build();
                result.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void deleteStudentById(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<StudentAttendanceDto> getStudentsByGroupId(int groupId) {
        List<StudentAttendanceDto> list = new ArrayList<>();
        String sql = "SELECT s.id, s.name, g.name AS group_id, s.attended " +
                "FROM student s JOIN groups g ON s.group_id = g.id " +
                "WHERE g.id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, groupId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(StudentAttendanceDto.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .groupName(rs.getString("group_id"))
                        .isAttended(rs.getBoolean("attended"))
                        .build());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<GroupDto> getAllGroups() {
        List<GroupDto> list = new ArrayList<>();
        String sql = "SELECT id, name FROM groups";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(GroupDto.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Integer getGroupIdByName(String groupName) {
        String sql = "SELECT id FROM groups WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, groupName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
