# Java Annotations

[Oracle tutorial](https://docs.oracle.com/javase/tutorial/java/annotations/) - [HackerHank](https://www.hackerrank.com/challenges/java-annotations/problem?isFullScreen=true) - [Coding with John](https://www.youtube.com/watch?v=DkZr7_c9ry8)


Java Annotations can be used to define the metadata of a Java Class or class element.
We can use Java annotation at the compile time to instruct the compiler about the build process.
Annotation is also used at runtime to get insight into the properties of class elements.

```java
@Entity
Class DemoClass {
}
```

We can also set a value to the annotation member

```java
@Entity(EntityName="DemoClass")
Class DemoClass{
}
```

You can also define your own annotations in the following way:
```java
@Target(ElementType.METHOD)             // define where the annotation can be used
@Retention(RetentionPolicy.RUNTIME)     // define if the annotation is available in RUNTIME
@interface FamilyBudget {
    String userRole() default "GUEST";
}
```

Example: 
```java
@SupressWarnings("unused")         // avoid warnings for unused variables
Cat myCat = new Cat("Jojo");
```