package utils;

import java.time.LocalDate;

public class DateUtils {

    public static int getCurrentyear(){
        return LocalDate.now().getYear();
    }
}
