package services;

import entity.ClientAndProject;
import entity.LongestProject;
import entity.ProjectPrice;
import entity.Worker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class DatabaseQueryService {

    public List<Worker> getMaxSalaryWorkers() throws SQLException, IOException {
        List<Worker> workers = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String content = readFile("src/main/resources/find_max_salary_worker.sql");
        PreparedStatement st = connection.prepareStatement(content);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("worker_id");
            int salaryMonth = rs.getInt("salary_month");
            String name = rs.getString("name");
            String level = rs.getString("level");
            LocalDate birthday = LocalDate.parse(rs.getString("birthday"));

            workers.add(new Worker(id, name, birthday, level, salaryMonth));
        }
        st.close();
        return workers;
    }

    public List<Worker> getYoungestAndOldestWorkers() throws SQLException, IOException {
        List<Worker> workers = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String content = readFile("src/main/resources/find_youngest_eldest_workers.sql");
        PreparedStatement st = connection.prepareStatement(content);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
            Worker worker = new Worker();
            worker.setName(name);
            worker.setBirthday(birthday);
            workers.add(worker);
        }
        st.close();
        return workers;
    }

    public ClientAndProject getClientWithMaxCountOfProjects() throws SQLException, IOException {
        Connection connection = DatabaseConnection.getConnection();
        String content = readFile("src/main/resources/find_max_projects_client.sql");
        PreparedStatement st = connection.prepareStatement(content);
        ResultSet rs = st.executeQuery();

        ClientAndProject clientAndProject = null;

        while (rs.next()) {
            String name = rs.getString("name");
            int count = rs.getInt("project_count");
            clientAndProject = new ClientAndProject(name, count);
        }
        st.close();
        return clientAndProject;
    }

    public List<LongestProject> getLongestProjects() throws SQLException, IOException {
        Connection connection = DatabaseConnection.getConnection();
        String content = readFile("src/main/resources/find_longest_project.sql");

        PreparedStatement st = connection.prepareStatement(content);
        ResultSet rs = st.executeQuery();

        List<LongestProject> longestProjects = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("project_id");
            int months = rs.getInt("month");
            longestProjects.add(new LongestProject(id, months));
        }
        st.close();
        return longestProjects;
    }

    public List<ProjectPrice> getProjectPrices() throws SQLException, IOException {
        Connection connection = DatabaseConnection.getConnection();
        String content = readFile("src/main/resources/print_project_prices.sql");

        PreparedStatement st = connection.prepareStatement(content);
        ResultSet rs = st.executeQuery();
        List<ProjectPrice> projectPrices = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("project_id");
            float price = rs.getFloat("price");
            projectPrices.add(new ProjectPrice(id, price));
        }
        st.close();
        return projectPrices;
    }


    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, UTF_8);
    }
}
