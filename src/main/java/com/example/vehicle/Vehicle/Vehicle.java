package com.example.vehicle.Vehicle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Table
public class Vehicle {
    private @Id @GeneratedValue Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long year;

    @Column(nullable = false)
    private String colour;

    @Column(nullable = false)
    private Long costperkm;

    public Vehicle() {
    }

    public Vehicle(Long id, String brand, String name, Long year, String colour, Long costperkm) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.year = year;
        this.colour = colour;
        this.costperkm = costperkm;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getYear() {
        return this.year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Long getCostperkm() {
        return this.costperkm;
    }

    public void setCostperkm(Long costperkm) {
        this.costperkm = costperkm;
    }

    public Vehicle id(Long id) {
        setId(id);
        return this;
    }

    public Vehicle brand(String brand) {
        setBrand(brand);
        return this;
    }

    public Vehicle name(String name) {
        setName(name);
        return this;
    }

    public Vehicle year(Long year) {
        setYear(year);
        return this;
    }

    public Vehicle colour(String colour) {
        setColour(colour);
        return this;
    }

    public Vehicle costperkm(Long costperkm) {
        setCostperkm(costperkm);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehicle)) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(brand, vehicle.brand)
                && Objects.equals(name, vehicle.name) && Objects.equals(year, vehicle.year)
                && Objects.equals(colour, vehicle.colour) && Objects.equals(costperkm, vehicle.costperkm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, name, year, colour, costperkm);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", brand='" + getBrand() + "'" +
                ", name='" + getName() + "'" +
                ", year='" + getYear() + "'" +
                ", colour='" + getColour() + "'" +
                ", costperkm='" + getCostperkm() + "'" +
                "}";
    }

}