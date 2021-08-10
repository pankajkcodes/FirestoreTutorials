package com.pankajkcodes.firestoretutorials;

public class Model {
    String id,name,age,county;

    public Model(String id, String name, String age, String county) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.county = county;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
