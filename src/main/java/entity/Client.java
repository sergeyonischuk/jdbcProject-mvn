package entity;

public class Client {
    private String name;
    private int countOfProjects;

    public Client() {
    }

    public Client(String name, int countOfProjects) {
        this.name = name;
        this.countOfProjects = countOfProjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfProjects() {
        return countOfProjects;
    }

    public void setCountOfProjects(int countOfProjects) {
        this.countOfProjects = countOfProjects;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", countOfProjects=" + countOfProjects +
                '}';
    }
}