package com.ravi.rest.webservices.restfulwebservices.HelloController;

public class HelloWorld {
    private String messageOne;
    private String messageTwo;

    public HelloWorld(String messageOne, String messageTwo) {
        this.messageOne = messageOne;
        this.messageTwo = messageTwo;
    }

    //getter method is required to convert in json response

    public String getMessageOne() {
        return messageOne;
    }

    public void setMessageOne(String messageOne) {
        this.messageOne = messageOne;
    }

    public String getMessageTwo() {
        return messageTwo;
    }

    public void setMessageTwo(String messageTwo) {
        this.messageTwo = messageTwo;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "messageOne='" + messageOne + '\'' +
                ", messageTwo='" + messageTwo + '\'' +
                '}';
    }
}
