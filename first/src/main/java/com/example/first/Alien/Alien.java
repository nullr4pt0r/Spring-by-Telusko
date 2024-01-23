package com.example.first.Alien;

import com.example.first.Laptop.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Autowired
    Laptop lap;

    public void code(){
        System.out.println(lap.getClass());
        lap.compile();
    }
}
