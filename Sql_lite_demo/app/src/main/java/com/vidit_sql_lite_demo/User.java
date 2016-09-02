package com.vidit_sql_lite_demo;

/**
 * Created by android4 on 2/9/16.
 */
public class User  {
    private int id;
    private String name, email,mobile,city,gen;

    public User(String name, String email, String mobile, String city, String gen) {

        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.city = city;
        this.gen = gen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }
}
