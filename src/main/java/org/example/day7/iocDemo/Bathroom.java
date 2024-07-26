package org.example.day7.iocDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Bathroom {
    Integer size;
    boolean withTank;

    public Bathroom() {
        this.size = 100;
        this.withTank = true;
    }

    public Bathroom(Integer size, boolean withTank) {
        this.size = size;
        this.withTank = withTank;
    }

    @Override
    public String toString() {
        return "Bathroom{" +
                "size=" + size +
                ", withTank=" + withTank +
                '}';
    }
}
