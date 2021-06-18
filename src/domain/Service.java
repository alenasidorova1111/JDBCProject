package domain;

public class Service {

    private Integer id;

    private String name;

    private Double cost;

    public Service(Integer id, String name, Double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Cost: " + cost;
    }

}