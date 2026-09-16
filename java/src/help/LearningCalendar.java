package help;

import java.util.*;

public class LearningCalendar {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        int date = 15;
        int month = 7; //july
        int year = 2002;

        cal.set(year, month - 1, date);

        String displayName = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH);
        
        System.out.println(displayName); // Monday
    }
    
}
