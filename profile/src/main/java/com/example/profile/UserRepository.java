package com.example.profile;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void register(String username, String password) {
        jdbc.update(
            "INSERT INTO users(username, password) VALUES (?, ?)",
            username, password
        );
    }

    public boolean login(String username, String password) {
        Integer count = jdbc.queryForObject(
            "SELECT COUNT(*) FROM users WHERE username=? AND password=?",
            Integer.class, username, password
        );
        return count != null && count > 0;
    }
}
