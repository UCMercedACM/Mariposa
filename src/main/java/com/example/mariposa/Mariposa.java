package com.example.mariposa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class Mariposa {
	private static Dotenv dotenv = Dotenv.load();

	public static void main(String[] args) {
		SpringApplication.run(Mariposa.class, args);

		String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS TOURNAMENTS ( ID serial PRIMARY KEY NOT NULL, name varchar(255), winners integer[], participants integer[], prizes varchar[], sponsors varchar[], date date, time time, updated_at timestamp default now(), created_at timestamp default now() );";

		try (Connection conn = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s", dotenv.get("POSTGRES_HOST"), dotenv.get("POSTGRES_PORT"), dotenv.get("POSTGRES_DB")), dotenv.get("POSTGRES_USER"), dotenv.get("POSTGRES_PASSWORD"))) {

            if (conn != null) {
				System.out.println("Connected to the database!");
				 
				try (Statement stmt = conn.createStatement()) {
					stmt.executeUpdate(SQL_CREATE_TABLE);
      				System.out.println("Created table in given database...");
				} catch (SQLException e) {
					System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}
            } else {
                System.out.println("Failed to make connection!");
			}
			
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
