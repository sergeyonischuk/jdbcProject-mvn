package entity;

import java.time.LocalDate;

public class Worker {
    private int id;
    private String name;
    private LocalDate birthday;
    private Level level;
    private int salaryMonth;

    public Worker() {
    }

    public Worker(String name, LocalDate birthday, Level level, int salaryMonth) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salaryMonth = salaryMonth;
    }

    public Worker(int id, String name, LocalDate birthday, Level level, int salaryMonth) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salaryMonth = salaryMonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(int salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", level=" + level +
                ", salaryMonth=" + salaryMonth +
                '}';
    }
}