package ch02.stream.app02.streamcreation.sub04;

public class MyObjectToPeek {
    private String name;
    private int age;

    public MyObjectToPeek(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyObjectToPeek() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyObjectToPeek{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
