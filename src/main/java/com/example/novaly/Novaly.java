package com.example.novaly;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class Novaly {

  @Value("${spring.datasource.url}")
  private String dbUrl;

  @Autowired
  private static DataSource dataSource;

  public static void main(String[] args) {
    SpringApplication.run(Novaly.class, args);

    try (Connection connection = dataSource.getConnection()) {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate(String.join(
          "CREATE TABLE IF NOT EXISTS LAN ( ID serial PRIMARY KEY NOT NULL, name varchar(255), email varchar(255) NOT NULL, student_id varchar(20), created_at TIMESTAMPTZ DEFAULT NOW() );"));
    } catch (Exception e) {
      System.out.println("toString(): " + e.toString());
      System.out.println("getMessage(): " + e.getMessage());
      System.out.println("StackTrace: ");
      e.printStackTrace();
    }
  }

  @RequestMapping("/")
  @ResponseBody
  String home() {
    return "Hello World!";
  }

  @RequestMapping(value = "/lan/db", method = RequestMethod.GET)
  @ResponseBody
  String db() {
    try (Connection connection = dataSource.getConnection()) {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM LAN");

      while (rs.next()) {
        System.out.println("email: " + rs.getString("email"));
      }

      return "Successful Query!";
    } catch (Exception e) {
      System.out.println("toString(): " + e.toString());
      System.out.println("getMessage(): " + e.getMessage());
      System.out.println("StackTrace: ");
      e.printStackTrace();
      return "error";
    }
  }

  @Bean
  public DataSource dataSource() throws SQLException {
    if (dbUrl == null || dbUrl.isEmpty()) {
      return new HikariDataSource();
    } else {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl(dbUrl);
      return new HikariDataSource(config);
    }
  }

}
