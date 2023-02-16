package services;

import entity.Client;
import entity.Project;
import entity.Worker;

import java.sql.*;
import java.util.List;

public class DatabasePopulateService {
    public void saveClients(List<Client> clientList) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO client (name) VALUES (?)"))
        {
            for (Client client : clientList) {
                preparedStatement.setString(1, client.getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveWorkers(List<Worker> workers) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(
                     "INSERT INTO worker (name, birthday, level, salary_month) VALUES (?,?,?,?)")) {
            for (Worker worker : workers) {
                preparedStatement.setString(1, worker.getName());
                preparedStatement.setDate(2, Date.valueOf(worker.getBirthday()));
                preparedStatement.setObject(3, worker.getLevel(), Types.OTHER);
                preparedStatement.setInt(4, worker.getSalaryMonth());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveProjects(List<Project> projects) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(
                     "INSERT INTO project (start_date, finish_date, client_id) VALUES (?,?,?)")){
            for (Project project : projects) {
                preparedStatement.setDate(1, Date.valueOf(project.getStartDate()));
                preparedStatement.setDate(2, Date.valueOf(project.getFinishDate()));
                preparedStatement.setInt(3, project.getClientId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveProjectWorkers(int projectId, int workerId) {
        try (Connection con = DataSource.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(
                     "INSERT INTO project_worker (project_id, worker_id) VALUES (?,?)")){
            preparedStatement.setInt(1, projectId);
            preparedStatement.setInt(2, workerId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}