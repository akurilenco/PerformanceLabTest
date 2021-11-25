package utils;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {
    public String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < getRandomNumber(10, 20); i++) {
            int number = random.nextInt(52);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public String getRandomNumber(int length) {
        String str = "123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(9);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public String getRandomMail() {
        return String.format("%s@%s.%s", getRandomString(), getRandomString(), getRandomString());
    }

    public int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public LocalDateTime getRandomDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.plusDays(ThreadLocalRandom.current().nextInt(-10000, 10000));
    }
}
