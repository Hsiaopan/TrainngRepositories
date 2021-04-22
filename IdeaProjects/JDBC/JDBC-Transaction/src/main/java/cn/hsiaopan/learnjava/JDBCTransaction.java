package cn.hsiaopan.learnjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTransaction {
    static final String jdbcUrl = "jdbc:mysql://localhost/learnjdbc?characterEncoding=utf8";
    static final String jdbcUsername = "learn";
    static final String jdbcPassword = "learnpassword";

    public static void main(String[] args) throws Exception {
        insertStudents("大黄", true, 3, 100);
        insertStudents("大头", true, 3, 101);

        List<Student> students = queryStudents();
        students.forEach(System.out::println);


    }


    static void insertStudents(String name, Boolean gender, int grade, int score) throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            boolean isAutoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, name);
                ps.setBoolean(2, gender);
                ps.setInt(3, grade);
                ps.setInt(4, score);
                int n = ps.executeUpdate();
                System.out.println(n + " inserted.");
            }

            if (score > 100 || score < 0) {
                conn.rollback();
                System.out.println("Wrong Value of Score(" + score + ") ...Rollback...");
            } else {
                conn.commit();
                System.out.println("Commit.");
            }

            conn.setAutoCommit(isAutoCommit);

        }
    }

    static List<Student> queryStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
                ps.setInt(1, 3);
                ps.setInt(2, 90);
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
