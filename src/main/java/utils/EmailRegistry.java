package utils;

import java.util.concurrent.atomic.AtomicInteger;

public class EmailRegistry {

    private static AtomicInteger COUNTER = new AtomicInteger(0);

    public static String getUniqEmail(String email){
        int index = COUNTER.incrementAndGet();
        return email + index;
    }


}
