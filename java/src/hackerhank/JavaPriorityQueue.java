import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
class Student {
    
    private int id;
    private String name;
    private double cgpa;
    
    Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getCGPA() {
        return this.cgpa;
    }   
}

class Priorities {
    
    public List<Student> getStudents(List<String> events) {
        
        PriorityQueue<Student> queue = new PriorityQueue<>(
            new Comparator<Student>() {
                
                public int compare(Student s1, Student s2) {
                    
                    if (s1.getCGPA() == s2.getCGPA()) {
                        
                        if (s1.getName().equals(s2.getName())) {
                            return s1.getID() > s2.getID() ? -1 : 1;
                        } 
                        
                        return s1.getName().compareTo(s2.getName());
                        
                    } 
                    
                    return s1.getCGPA() > s2.getCGPA() ? -1 : 1;
                    
                }
                
            }
        );
        
        for (String event : events) {
            
            String[] splitted = event.split(" ");
            String type = splitted[0];
            
            if (type.equals("ENTER")) {
                String name = splitted[1];
                double cgpa = Double.parseDouble(splitted[2]);
                int id = Integer.parseInt(splitted[3]);
            
                Student student = new Student(id, name, cgpa);
                queue.add(student);
            } else if (queue.size() > 0) {
                queue.remove();
            }
            
            
            // System.out.print("List: ");
            // for (Student st : queue) {
            //     System.out.print(st.getName() + "(" + st.getCGPA() + ") ");
            // }
            // System.out.println("");
            
            
        }
        
        List<Student> result = new ArrayList<>();
        
        while(queue.size() > 0) {
            result.add(queue.remove());
        }
        
        return result;
        
    }
    
}


public class JavaPriorityQueue {
    
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}