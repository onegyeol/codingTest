package progammers;

import java.time.LocalDate;

public class codingTest37 {

    public String solution(int a, int b) {//a = month, b-day
        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        
        LocalDate date = LocalDate.of(2016, a, b);
        int day = date.getDayOfWeek().ordinal();
        
        return week[day];
    }
}
