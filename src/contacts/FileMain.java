package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileMain {
    public static void main(String[] args) throws IOException {

        // make a path object using absolute path for a demo folder
        Path contactFolder = Paths.get("data");

//        Path demoFolder = Paths.get("demo");

        System.out.println("Does this folder exist? " + Files.exists(contactFolder));

        Path contactFile = Paths.get("data", "contacts.txt");

        System.out.println("Does this file exist? " + Files.exists(contactFile));

        if (Files.exists(contactFolder)) {
            System.out.println("Hey the folder already exists!");
        } else {
            Files.createDirectories(contactFolder);
        }
        if (Files.exists(contactFile)) {
            System.out.println("Hey the file already exists!");
        } else {
            Files.createFile(contactFile);
        }
        List<String> contacts= Arrays.asList("Kat", "Ben", "Midlyn", "Val");
        Files.write(contactFile, contacts);
        List<String> contactDB = Files.readAllLines(contactFolder);
        System.out.println(contactDB);

//        fruitDB.remove("banana");
//        System.out.println(fruitDB);
//        Files.write(contactFile, fruitDB);
    }

}

