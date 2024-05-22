package org.foden.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang.RandomStringUtils;
import org.foden.enums.RandomDataType;

public class RandomDataGeneratorUtils {

    public static Faker faker = new Faker();

    public static String getRandomDataFor(RandomDataType randomDataType){
        switch (randomDataType){
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
            case FULLNAME:
                return faker.name().fullName();
            case PASSWORD:
                return faker.number().digits(10);
            default:
                return "Data type name not available";
        }
    }

    public static int getRandomNumber(int min, int max){
        return faker.number().numberBetween(min,max);
    }

    public static String getRandomAlphabets(int count){
        return RandomStringUtils.randomAlphabetic(count);
    }
}
