package LearningAnnotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main (String[] args) throws Exception {

        Cat myCat = new Cat("Stella");

        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("This thing is very important");
        }

        for (Method method : myCat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                for (int i = 0; i < method.getAnnotation(RunImmediately.class).times(); i ++) {
                    method.invoke(myCat); // needs to throws Exception
                }
            }
        }

        for (Field field : myCat.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ImportantString.class)) {
                Object obj = field.get(myCat);
                if (obj instanceof String stringValue) {
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }
    
}
