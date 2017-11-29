package com.fortech.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="car")
@NamedQueries({
        @NamedQuery(name = "car.searchCar", query = "Select c FROM car c WHERE c.mark=:pMark or c.color=:pColor or c.condition = :pCondition ")})

public class CarEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column( name="name")
    private String name;

    @Column (name="mark")
    private String mark;

    @Column (name="color")
    private String color;

    @Column (name="price")
    private double price;

    @Column (name="\"condition\"")
    private String condition;

    @Column (name="registrationDate")
    private Date registrationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}
