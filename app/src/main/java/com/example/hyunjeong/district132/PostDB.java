package com.example.hyunjeong.district132;

/**
 * Created by Jeslyn on 30/3/2017.
 */

public class PostDB {

    private int post_id;
    private String username;
    private String location;
    private String housetype;
    private boolean purpose;
    private double price;
    private int no_of_rooms;
    private boolean furnishing;
    private String facilities;
    private String desc;
    private double size;

    public PostDB() {

    }

    public PostDB(int post_id, String username, String location, String housetype, boolean purpose, double price,
                  int no_of_rooms, boolean furnishing, String facilities, String desc, double size) {
        this.post_id = post_id;
        this.username = username;
        this.location = location;
        this.housetype = housetype;
        this.purpose = purpose;
        this.price = price;
        this.no_of_rooms = no_of_rooms;
        this.furnishing = furnishing;
        this.facilities = facilities;
        this.desc = desc;
        this.size = size;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getHousetype(){
        return housetype;
    }

    public void setHousetype(String housetype){
        this.housetype = housetype;
    }

    public boolean getPurpose(){
        return purpose;
    }

    public void setPurpose(boolean purpose){
        this.purpose = purpose;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public boolean getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(boolean furnishing) {
        this.furnishing = furnishing;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
