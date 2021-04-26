package cn.hsiaopan.learnjava;

import java.util.List;

public class ScoreFilter {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("小明", 88),
                new Person("大黄", 62),
                new Person("小白", 55),
                new Person("小黑", 78));
        personList.stream()
                .filter(person -> person.getScore() >= 60)
                .map(Person::getName)
                .forEach(System.out::println);
    }
}

class Person {
    private String name;
    private int score;

    public Person() {
    }

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
