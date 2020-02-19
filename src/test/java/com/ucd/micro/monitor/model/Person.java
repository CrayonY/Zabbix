package com.ucd.micro.monitor.model;

import lombok.Data;

/**
 * Created by crayon on 2019/4/13.
 */
@Data
public class Person {

    private String firstName, lastName, job, gender;
    private int salary, age;


    public Person(String firstName, String lastName, String job,
                  String gender, int age, int salary)       {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }


   /* public String groupKey(){
        return this.firstName + "_" + this.projectAddress + "_" + this.companyName;
    }*/
}
