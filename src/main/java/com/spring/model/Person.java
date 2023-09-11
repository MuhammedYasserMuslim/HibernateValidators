package com.spring.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = true,length = 5)
    private double salary;

    @Column(nullable = false)
    private double discount;

    @Formula("(select count(*) from Persons person ) ")
    private Long PersonCount;

    @Formula("(select per.salary-per.discount from Persons per where per.id=id )")
    private double netSalary;

    public double getNetSalary(){
        return this.salary-this.discount;
    }


}
