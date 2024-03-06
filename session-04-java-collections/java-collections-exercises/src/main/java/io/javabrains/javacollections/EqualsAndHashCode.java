package io.javabrains.javacollections;

import java.util.Date;
import java.util.Objects;

/*
Generate a Person class with the member variables firstName, lastName, age, lastModifiedDate.
Generate equals and hashcode methods using member variables firstName, lastName, age
Compare two instances of Person that have the same data
*/

public class EqualsAndHashCode {

    public static void main(String[] args) {
        Person p1 = new Person("Daniel", "Lucas", 24, new Date());
        Person p2 = new Person("Daniel", "Lucas", 24, new Date());

        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());
    }
}

class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Date lastModifiedDate;

    public Person(String firstName, String lastName, Integer age, Date lastModifiedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override // annotation not mandatory, but help catch mistakes
    public boolean equals(Object obj) { // used to compare this obj to another
        // compares if the references is the same
        if (obj == this) {
            return true;
        }

        // check if its null or the same class
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Person other = (Person) obj;

        // do the equals logic for this class
        return this.age == other.age 
            && Objects.equals(this.firstName, other.getFirstName())
            && Objects.equals(this.lastName, other.getLastName());
    }

    @Override
    public int hashCode() { // used to generate hashcode in collections
        return Objects.hash(firstName, lastName, age);
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}