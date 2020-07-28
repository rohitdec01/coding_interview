package javaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExamples {

    public static void main(String[] args) {
        // mapEx();
        flatmapEx();
    }

    private static void mapEx() { // map will return new list
        List<Integer> list11 = Arrays.asList(3, 6, 9, 12, 15);
        List<Integer> list2 = list11.stream().map(number -> number * 3).collect(Collectors.toList());

        System.out.println(list11); // [3, 6, 9, 12, 15]
        System.out.println("New List" + list2);// New List[9, 18, 27, 36, 45]

        List<String> list12 = Arrays.asList("iam", "YOU are", "This IS", "THEY ARE");
        List<String> list3 = list12.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(list3); // [IAM, YOU ARE, THIS IS, THEY ARE]
    }

    private static void flatmapEx() {
        Person person1 = new Person("Mike", Arrays.asList("Java", "Scala"));
        Person person2 = new Person("Devid", Arrays.asList("Php", "JavaScript"));
        Person person3 = new Person("Mohit", Arrays.asList("C++", "Java"));

        List<Person> persons = Arrays.asList(person1, person2, person3);

        System.out.println("\n--------Using flatMap() method to print all languages--------");
        List<String> collect = persons.stream()
                .map(p -> p.languages)
                .flatMap(l -> l.stream()).distinct().collect(Collectors.toList());

        System.out.println(collect);

        List<Integer> list11 = Arrays.asList(3, 6, 9, 12, 15);
        long count = list11.stream().distinct().count();
        System.out.println(count);
    }


}

class Person {
    public String name;
    public List<String> languages;

    public Person(String name, List<String> languages) {
        this.name = name;
        this.languages = languages;
    }
}
