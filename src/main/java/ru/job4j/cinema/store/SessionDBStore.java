package ru.job4j.cinema.store;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Repository;
import ru.job4j.cinema.model.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SessionDBStore {

    private final BasicDataSource pool;

    public SessionDBStore(BasicDataSource pool) {
        this.pool = pool;
    }

    public List<Session> findAll() {
        List<Session> sessions = new ArrayList<>();
        try (Connection connection = pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM sessions",
                    PreparedStatement.RETURN_GENERATED_KEYS
            )) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    sessions.add(createSessionFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessions;
    }

    private Session createSessionFromResultSet(ResultSet resultSet) throws SQLException {
        Session session;
        session = new Session(resultSet.getString("name"));
        session.setId(resultSet.getInt("id"));
        return session;
    }

    public Session addSession(Session session) {
        try (Connection connection = pool.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO sessions(name) VALUES (?)",
                     PreparedStatement.RETURN_GENERATED_KEYS
             )) {
            ps.setString(1, session.getName());
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    session.setId(resultSet.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }
}
