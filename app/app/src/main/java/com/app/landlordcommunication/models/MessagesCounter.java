package com.app.landlordcommunication.models;

public class MessagesCounter {
    private int counter;

    public MessagesCounter(){

    }

    public MessagesCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
