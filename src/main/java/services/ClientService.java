package services;

import entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    public String getById(long id) throws SQLException {
        if (validateInputId(id)) {
            Connection con = DataSource.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM client WHERE client_id = ?");
            st.setLong(1, id);

            Client client = new Client();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                client.setId(id);
                client.setName(rs.getString("name"));
            }
            if (client.getName() != null) {
                return client.getName();
            }
            rs.close();
        }
        throw new IllegalArgumentException("illegal id");

    }

    public void setName(long id, String name) throws SQLException {
        if (validateInputId(id) && validateInputName(name)) {
            Connection con = DataSource.getConnection();
            PreparedStatement st = con.prepareStatement("UPDATE client SET name = ? WHERE client_id = ?");
            st.setLong(2, id);
            st.setString(1, name);
            st.executeUpdate();
        } else
            throw new IllegalArgumentException("incorrect input ID or name parameters");
    }

    public long create(String name) throws SQLException {
        if (validateInputName(name)) {
            Connection con = DataSource.getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO client (name) VALUES (?)");
            st.setString(1, name);
            st.executeUpdate();

            return getIdByName(name);
        }
        throw new IllegalArgumentException("incorrect name. Name must be not null, >= 2 and <= 1000 characters");
    }

    public List<Client> listAll() throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement st = connection.prepareStatement("SELECT * FROM client");
        ResultSet rs = st.executeQuery();

        List<Client> result = new ArrayList<>();

        while (rs.next()) {
            long id = rs.getLong("client_id");
            String name = rs.getString("name");
            result.add(new Client(id, name));
        }
        rs.close();
        return result;
    }

    public void deleteById(long id) throws SQLException {
        if (validateInputId(id)) {
            Connection con = DataSource.getConnection();
            PreparedStatement st = con.prepareStatement("DELETE FROM client WHERE client_id = ?");
            st.setLong(1, id);
            st.executeUpdate();
        } else
            throw new IllegalArgumentException("illegal id");
    }

    private long getIdByName(String name) throws SQLException {
        if (validateInputName(name)) {
            Connection con = DataSource.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM client WHERE name = ?");
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getLong("client_id");
            }
            rs.close();
        }
        throw new IllegalArgumentException("client with name " + name + " not found");
    }

    private boolean validateInputId(long id) {
        return id > 0;
    }

    private boolean validateInputName(String name) {
        return name != null && name.length() >= 2 && name.length() <= 1000;
    }
}