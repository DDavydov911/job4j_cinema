package ru.job4j.cinema.store;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Repository;
import ru.job4j.cinema.model.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketsDBStore {

    private final BasicDataSource pool;

    public TicketsDBStore(BasicDataSource pool) {
        this.pool = pool;
    }

    public Ticket addTicket(Ticket ticket) {
        try (Connection connection = pool.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO tickets(session_id, row, cell, user_id) "
                             + "VALUES (?, ?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS
             )) {
            setTicketAttributes(ticket, ps);
            ps.execute();
            try (ResultSet resultSet = ps.getGeneratedKeys()) {
                if (resultSet.next()) {
                    ticket.setId(resultSet.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    private void setTicketAttributes(Ticket ticket, PreparedStatement ps)
            throws SQLException {
        ps.setInt(1, ticket.getSessionId());
        ps.setInt(2, ticket.getRow());
        ps.setInt(3, ticket.getCell());
        ps.setInt(4, ticket.getUserId());
    }

    public List<Ticket> findAll() {
        List<Ticket> tickets = new ArrayList<>();
        try (Connection connection = pool.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT * FROM tickets ORDER BY id"
             )) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    tickets.add(createTicketFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public List<Ticket> findTicketsBySessionId(int id) {
        List<Ticket> tickets = new ArrayList<>();
        try (Connection connection = pool.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT * FROM tickets WHERE id = ? ORDER BY id"
             )) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    tickets.add(createTicketFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    private Ticket createTicketFromResultSet(ResultSet resultSet)
            throws SQLException {
        Ticket ticket;
        ticket = new Ticket(
                resultSet.getInt("session_id"),
                resultSet.getInt("row"),
                resultSet.getInt("cell"),
                resultSet.getInt("userId")
        );
        ticket.setId(resultSet.getInt("id"));
        return ticket;
    }
}
