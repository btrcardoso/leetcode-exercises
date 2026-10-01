package LearningAnnotations;

@VeryImportant 
public class Cat {
    
    @ImportantString
    String name;

    public Cat (String name) {
        this.name = name;
    }

    @RunImmediately(times = 3)
    public void meow() {
        System.out.println("meow");
    }

    public void eat() {
        System.out.println("nham nham");
    }
}
