package com.elcio.listadetarefas.model;

import java.io.Serializable;

//TODO keep in mind the necessity to implements the SERIALIZEBLE class
public class Person implements Serializable {
    private Integer id;
    private String firstName;
    private Integer age;

    public Person(String firstName, Integer age) {
        this.firstName = firstName;
        this.age = age;
    }

    public Person(String name, Integer age, Integer id) {
        this(name,age);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
