package com.example.demo.Model;

public class Message {
    public String from;
    public String to;
    public String content;

    public Message(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public Message() {
    }
}
