package com.sin.test.jdk;

public class Person {
    private String name;
    private String password;
    private String hass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHass() {
        return hass;
    }

    public void setHass(String hass) {
        this.hass = hass;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", hass='" + hass + '\'' +
                '}';
    }
}
