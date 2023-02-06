package entity;

import java.time.LocalDate;

public class Worker {
    private int id;
    private String name;
    private LocalDate birthday;
    private String lvl;
    private int salaryMonth;

    public Worker() {
    }

    public Worker(int id, String name, LocalDate birthday, String lvl, int salaryMonth) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.lvl = lvl;
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

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public int getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(int salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    @Override
    public String toString() {
        return "Entity.Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", lvl='" + lvl + '\'' +
                ", salaryMonth=" + salaryMonth +
                '}';
    }
}
