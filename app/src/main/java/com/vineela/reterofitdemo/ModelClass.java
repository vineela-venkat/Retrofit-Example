package com.vineela.reterofitdemo;

/**
 * Created by VINEELA on 17-10-2018.
 */

public class ModelClass {
    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public ModelClass(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public String getTeam() {
        return team;

    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }

    String name;
    String realname;
    String team;
    String firstappearance;
    String createdby;
    String publisher;
    String imageurl;
    String bio;

}
