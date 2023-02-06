package entity;

public class ProjectPrice {
    private int id;
    private float price;

    public ProjectPrice(int id, float price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}