package coreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiLevelSorting {

    public static void main(String[] args) {
        List<Person> lst = new ArrayList<>();
        lst.add(new Person("Rohit", "Gupta"));
        lst.add(new Person("Ravi", "kumar"));
        lst.add(new Person("Monika", "Arora"));
        lst.add(new Person("Kunal", "Gupta"));
        lst.add(new Person("Vivaan", "kumar"));
        lst.add(new Person("kanta", "kumar"));
        lst.forEach(person -> System.out.println(person.lastname + " " + person.firstname));
        Collections.sort(lst);
        System.out.println("*************************************");
        lst.forEach(person -> System.out.println(person.lastname + " " + person.firstname));
    }
}

class Person implements Comparable<Person> {
    public String firstname;
    public String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public int compareTo(Person person) {
        int index = this.lastname.compareTo((person.lastname));
        if (index == 0) {
            index = this.firstname.compareTo((person.firstname));
        }
        return index;
    }
}
