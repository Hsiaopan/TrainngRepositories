package cn.hsiaopan.learnjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCUpdate {
    // 连接
    static final String jdbcUrl = "jdbc:mysql://localhost/learnjdbc?characterEncoding=utf8";
    static final String jdbcUsername = "learn";
    static final String jdbcPassword = "learnpassword";

    public static void main(String[] args) throws Exception {
        queryStudents().forEach(System.out::println);

        System.out.println("Insert new Student...");
        String insertSql = "INSERT INTO students (name, gender, grade, score) VALUES (?, ? ,?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, "大白");
                ps.setObject(2, 1);
                ps.setObject(3, 2);
                ps.setObject(4, 85);
                int n = ps.executeUpdate();
                System.out.println(n + " Inserted.");

            }
        }

        System.out.println("Insert new Student and return id...");
        String insertSqlNew = "INSERT INTO students (name, gender, grade, score) VALUES (?, ? ,?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement(insertSqlNew, Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, "大林");
                ps.setObject(2, 1);
                ps.setObject(3, 3);
                ps.setObject(4, 93);
                int n = ps.executeUpdate();
                long id = 0;
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                }
                System.out.println(n + "inserted. id = " + id);
            }
        }

        System.out.println("Update Student...");
        String updateSql = "UPDATE students SET score = ? WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                ps.setInt(1, 99);
                ps.setString(2, "小贝");
                int n = ps.executeUpdate();
                System.out.println(n + "updated.");
            }
        }

        System.out.println("Delete Student...");
        String deleteSql = "DELETE FROM students WHERE grade < ? and score = ?";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement(deleteSql)) {
                ps.setInt(1, 3);
                ps.setInt(2, 80);
                int n = ps.executeUpdate();
                System.out.println(n + "deleted.");
            }
        }

        queryStudents().forEach(System.out::println);
    }

    static List<Student> queryStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM students")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(extractRow(rs));
                    }
                }
            }
        }
        return students;
    }

    static Student extractRow(ResultSet rs) throws SQLException {
        Student std = new Student();
        std.setId(rs.getLong("id"));
        std.setName(rs.getString("name"));
        std.setGender(rs.getBoolean("gender"));
        std.setGrade(rs.getInt("grade"));
        std.setScore(rs.getInt("score"));
        return std;
    }


}
