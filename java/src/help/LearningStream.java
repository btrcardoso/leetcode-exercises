package help;

import java.util.*;

/**
 * LearningStream
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 */

public class LearningStream {
    public static void main(String[] args){

        List<Person> people = new ArrayList<>();
        people.add(new Person("Bob", 36, Gender.MALE));
        people.add(new Person("Ava", 28, Gender.FEMALE));

        /***
         * Stream: a sequence of elements supporting sequential and parallel aggregate operations.
         */
    
        long womenQuantity = people.stream()
                                   .filter(p -> p.gender == Gender.FEMALE)
                                   .count();
        System.out.println(womenQuantity);

        int agesSum = people.stream()
                            .mapToInt(p -> p.age)
                            .sum();
        System.out.println(agesSum);

    }
}
