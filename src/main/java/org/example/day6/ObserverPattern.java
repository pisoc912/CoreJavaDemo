package org.example.day6;

public class ObserverPattern {

    interface Observe{
        void update(float temperature);
    }

    class PhoneDisplay implements Observe{
        private float temperature;

        @Override
        public void update(float temperature) {
            this.temperature = temperature;
            display();
        }

        public void display(){
            System.out.println("Phone display: current temperature: " + temperature);
        }
    }

    class WebDisplay implements Observe{
        private float temperature;

        @Override
        public void update(float temperature) {
            this.temperature = temperature;
            display();
        }

        public void display(){
            System.out.println("Web Display: Current Temperature: "+ temperature);
        }
    }
}
