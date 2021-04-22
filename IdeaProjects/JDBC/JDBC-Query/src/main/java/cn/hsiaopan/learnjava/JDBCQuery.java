package cn.hsiaopan.learnjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCQuery {
    // JDBC 连接的URL，不同数据库有不同的格式
    static final String jdbcUrl = "jdbc:mysql://localhost/learnjdbc?characterEncoding=utf8";
    static final String jdbcUsername = "learn";
    static final String jdbcPassword = "learnpassword";

    public static void main(String[] args) throws Exception {
        List<Student> students = queryStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    static List<Student> queryStudents() throws SQLException {
        List<Student> students = new ArrayList<>();

        // 通过 Connection 提供的createStatement() 方法创建一个 Statement 对象，用于执行一个查询语句
        // 使用 DriverManager 提供的静态方法 getConnection(). DriverManager 会自动扫描 classpath，找到所有的JDBC驱动
        // 使用 try(resource) 来自动释放JDBC连接
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            // 使用 PreparedStatement 避免SQL注入
            // PreparedStatement 始终使用 ？作为占位符，并且把数据库连同SQl本身传给数据库
            // 可以保证每次传给数据库的SQL语句是相同的，还能利用数据库本身对查询的缓存。
            // 使用Java对数据库进行操作时，必须使用PreparedStatement
            String querySql = "SELECT * FROM students WHERE GRADE = ? AND score >= ?";
            try (PreparedStatement ps = conn
                    .prepareStatement(querySql)) {
                ps.setInt(1, 3); // 索引从1开始
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
