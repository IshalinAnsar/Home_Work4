package ru.gb.dz.lesson4;

import javax.persistence.*;

@Entity
@Table(name = "test.person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Имя")
    private String firstName;
    @Column (name = "Фамилия")
    private String lastName;
    @Column(name = "Возраст")
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {}
}
