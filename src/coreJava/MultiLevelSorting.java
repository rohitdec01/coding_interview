package coreJava;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;
import java.util.stream.Collectors;

public class MultiLevelSorting {

    public static void main(String[] args) {
        List<Person> lst = new ArrayList<>();
        lst.add(new Person("Rohit", "Gupta"));
        lst.add(new Person("Ravi", "kumar"));
        lst.add(new Person("Monika", "Arora"));
        lst.add(new Person("Kunal", "Gupta"));
        lst.add(new Person("Vivaan", "kumar"));
        lst.add(new Person("Monika", "kumar"));
        /*lst.forEach(person -> System.out.println(person.lastname + " " + person.firstname));
        Collections.sort(lst);
        System.out.println("*************************************");
        lst.forEach(person -> System.out.println(person.lastname + " " + person.firstname));*/

       /* exp1Map();
        exp2Map(lst);*/
        exp3Filter(lst);
    }

    private static void exp1Map() {
        // create a list of integers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        // demonstration of map method
        List<Integer> square = numbers.stream().map(x -> x * x).
                collect(Collectors.toList());
// ****************************************************************
        Set<Integer> squareSet =
                numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println(squareSet);

// ****************************************************************
        // demonstration of forEach method
        numbers.stream().map(x -> x * x).forEach(updatedValue -> System.out.println(updatedValue));

// ****************************************************************
    }

    private static void exp2Map(List<Person> lst) {
        // Java 8
        List<String> firstNameLst = lst.stream().map(person -> person.getFirstname()).collect(Collectors.toList());
        System.out.println(firstNameLst);

        // Java 7
        List<String> firstNameLst2 = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            firstNameLst2.add(lst.get(i).getFirstname());
        }
        System.out.println(firstNameLst2);
    }

    private static void exp3Filter( List<Person> lst) {
        // java 8 filter
        List<Person> persons =  lst.stream().filter(person -> person.getFirstname().equals("Monika")).collect(Collectors.toList());
        persons.forEach(person -> System.out.println(person.getFirstname() + "   " + person.getLastname()));

        // OR java 8 filter
        lst.stream().filter(person -> person.getFirstname().equals("Monika"))
                .forEach(person -> System.out.println(person.getFirstname() + "   " + person.getLastname()));

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
