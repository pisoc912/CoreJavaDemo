package org.example.day7.iocDemo;

import org.springframework.stereotype.Component;

@Component
public class Livingroom {
    Integer size;
    String type;

    public Livingroom() {
        this.size = 200;
        this.type = "square";
    }
    public Livingroom(Integer size, String type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Livingroom{" +
                "size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}
