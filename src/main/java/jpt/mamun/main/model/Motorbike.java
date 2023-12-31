package jpt.mamun.main.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Motorbike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bike_name;
    private String brand;
    private String color;



    public Motorbike() {

    }

    public Motorbike(Long id, String bike_name, String brand, String color) {
        this.id = id;
        this.bike_name = bike_name;
        this.brand = brand;
        this.color = color;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBikeName() {
        return bike_name;
    }

    public void setBikeName(String bike_name) {
        this.bike_name = bike_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
