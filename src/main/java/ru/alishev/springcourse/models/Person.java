package ru.alishev.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author Neil Alishev
 */
public class Person {
    private int person_id;

    @NotEmpty(message = "ФИО не может быть пустым")
    private String name;

    @Min(value = 0, message = "Год рождения должен быть выше нуля")
    private int year;

    public Person() {}

    public Person(int person_id, String name, int year) {
        this.person_id = person_id;
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
