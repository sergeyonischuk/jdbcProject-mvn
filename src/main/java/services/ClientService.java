package services;

import entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    public String getById(long id) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM client WHERE client_id = ?")) {
            if (validateInputId(id)) {
                ps.setLong(1, id);
                ResultSet rs = ps.executeQuery();
                Client client = new Client();
                while (rs.next()) {
                    client.setId(id);
                    client.setName(rs.getString("name"));
                }
                    return client.getName();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public void setName(long id, String name) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE client SET name = ? WHERE client_id = ?")) {
            if (validateInputId(id) && validateInputName(name)) {
                ps.setLong(2, id);
                ps.setString(1, name);
                ps.executeUpdate();
            } else
                throw new IllegalArgumentException("incorrect input ID or name parameters");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public long create(String name) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO client (name) VALUES (?)")) {
            if (validateInputName(name)) {
                ps.setString(1, name);
                ps.executeUpdate();
                return getIdByName(name);
            }
            throw new IllegalArgumentException("incorrect name. Name must be not null, >= 2 and <= 1000 characters");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public List<Client> listAll() {
        try (Connection con = DataSource.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM client")) {
            ResultSet rs = ps.executeQuery();
            List<Client> result = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("client_id");
                String name = rs.getString("name");
                result.add(new Client(id, name));
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public void deleteById(long id) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM client WHERE client_id = ?")) {
            if (validateInputId(id)) {
                ps.setLong(1, id);
                ps.executeUpdate();
            } else
                throw new IllegalArgumentException("illegal id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private long getIdByName(String name) throws SQLException {
        try (Connection con = DataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM client WHERE name = ?")) {
            if (validateInputName(name)) {
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getLong("client_id");
                }
            }
            throw new IllegalArgumentException("client with name " + name + " not found");
        }
    }

    private boolean validateInputId(long id) {
        return id > 0;
    }

    private boolean validateInputName(String name) {
        return name != null && name.length() >= 2 && name.length() <= 1000;
    }
}