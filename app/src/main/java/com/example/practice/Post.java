package com.example.practice;

public class Post {
    public String name;
    public String phone;
    public String address;
    public String status;



    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String author, String title, String body) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }
}
