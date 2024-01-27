package com.dnl.jdbc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@component to let know the spring ioc to create bean if this class
//@scope prototype to create different bean instance for each bean creation
@Component
@Scope("prototype")
public class Alien {

    private int id;
    private String name;
    private String tech;

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

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
