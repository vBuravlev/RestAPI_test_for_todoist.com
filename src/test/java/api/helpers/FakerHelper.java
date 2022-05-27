package api.helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

public interface FakerHelper {

    public static String createRandomName() {
        Faker faker = new Faker(new Locale("en"));
        String randomNameTask = faker.starTrek().character() + faker.random().nextInt(5);
        return randomNameTask;
    }

    public static String createRandomName(String languageShort) {
        Faker faker = new Faker(new Locale(languageShort));
        String randomNameTask = faker.starTrek().character() + faker.random().nextInt(5);
        return randomNameTask;
    }

    public static String createRandomName(String languageShort, int nextInt) {
        Faker faker = new Faker(new Locale(languageShort));
        String randomNameTask = faker.starTrek().character() + faker.random().nextInt(nextInt);
        return randomNameTask;
    }


    public static String createRandomName(Integer nextInt) {
        Faker faker = new Faker(new Locale("en"));
        String randomNameTask = faker.starTrek().character() + faker.random().nextInt(nextInt);
        return randomNameTask;
    }

    public static String createRandomContent() {
        Faker faker = new Faker(new Locale("en"));
        String randomNameContent = faker.lordOfTheRings().character() + faker.random().nextInt(5);
        return randomNameContent;
    }

    public static String createRandomContent(String languageShort) {
        Faker faker = new Faker(new Locale(languageShort));
        String randomNameContent = faker.lordOfTheRings().character() + faker.random().nextInt(5);
        return randomNameContent;
    }

    public static String createRandomContent(String languageShort, int nextInt) {
        Faker faker = new Faker(new Locale(languageShort));
        String randomNameContent = faker.lordOfTheRings().character() + faker.random().nextInt(nextInt);
        return randomNameContent;
    }

    public static String createRandomContent(int nextInt) {
        Faker faker = new Faker(new Locale("en"));
        String randomNameContent = faker.lordOfTheRings().character() + faker.random().nextInt(nextInt);
        return randomNameContent;
    }

    public static Integer createRandomPriority() {
        Faker faker = new Faker(new Locale("en"));
        int randomPriority = faker.random().nextInt(1, 4);
        return randomPriority;
    }

    public static Integer createRandomPriority(int firstVolume, int lastVolume) {
        Faker faker = new Faker(new Locale("en"));
        int randomPriority = faker.random().nextInt(firstVolume, lastVolume);
        return randomPriority;
    }

    public static String createDeadLineTask() {
        String dateDeadLineTask = "tomorrow at 12:00";
        return dateDeadLineTask;
    }

    public static int createRandomInt(int randomIntMax) {
        Faker faker = new Faker(new Locale("en"));
        int randomInt = faker.random().nextInt(1, randomIntMax);
        return randomInt;
    }

}
