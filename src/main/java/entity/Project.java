package entity;

import java.time.LocalDate;

public class Project {
    private int id;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int clientId;

    public Project() {
    }

    public Project(LocalDate startDate, LocalDate finishDate, int clientId) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.clientId = clientId;
    }

    public Project(int id, LocalDate startDate, LocalDate finishDate, int clientId) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", clientId=" + clientId +
                '}';
    }
}
