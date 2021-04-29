package com.pluralsight.springaop.example1;

public class Passenger {

    private int id;

    Passenger(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return "Passenger: " + id;
    }
}
