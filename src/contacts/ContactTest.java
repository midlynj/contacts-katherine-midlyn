package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactTest {

    public static final int INVALID_CHOICE = -1;
    public static final int EXIT_CHOICE = 5;
    static HashMap<String, String> list = new HashMap<>();
    static List<String> trial = Arrays.asList("coffee");
    static HashMap<String, String> mn = new HashMap<>();
    static ArrayList<String> numbers = new ArrayList<>();


    public static void main(String[] args) throws IOException {
//       meep();
        showContactList();
//        addContact();
//        deleteContact();
//       save();
        Input input = new Input();


        int choice = INVALID_CHOICE;
        while (choice != EXIT_CHOICE) {
            showMenu();

            choice = input.getInt(0, 5);

            userMenuOption(choice);

        }
//        addContact();


    }

    public static void showMenu() {
        System.out.print("""
                1. View contacts.
                2. Add a new contact.
                3. Search a contact by name.
                4. Delete an existing contact.
                5. Exit.
                Enter an option (1, 2, 3, 4 or 5):
                """);
    }

    public static void showContactList() {

        Contacts joey = new Contacts("Joey", 123);
        Contacts katara = new Contacts("Katara", 456);
        Contacts kairo = new Contacts("Kairo", 789);
        list.put(joey.getContactName(), String.valueOf(joey.getPhoneNumber()));
        list.put(katara.getContactName(), String.valueOf(katara.getPhoneNumber()));
        list.put(kairo.getContactName(), String.valueOf(kairo.getPhoneNumber()));
        numbers.add(joey.getContactName());
        numbers.add(String.valueOf(joey.getPhoneNumber()));
        numbers.add(katara.getContactName());
        numbers.add(String.valueOf(katara.getPhoneNumber()));
        numbers.add(kairo.getContactName());
        numbers.add(String.valueOf(kairo.getPhoneNumber()));

        System.out.println(list.keySet());
//        meep();
//       1

    }

    public static void userMenuOption(int userPick) {
        switch (userPick) {
            case 1:
                showContactList();
                break;
            case 2:
                addContact();
                break;
            case 3:
                searchContacts();
                break;
            case 4:
                deleteContact();
                break;
        }
    }

    public static void addContact() {
        System.out.println("Enter name");
        Scanner scanner = new Scanner(System.in);
        String addName = scanner.next();
        scanner.next();
        System.out.println("Enter number");
        int addNumber = scanner.nextInt();
        Contacts m = new Contacts(addName, addNumber);
        list.put(m.getContactName(), String.valueOf(m.getPhoneNumber()));
        numbers.add(m.getContactName());
        numbers.add(String.valueOf(m.getPhoneNumber()));
        try {
            Files.write(
                    Paths.get("data", "test.txt.txt"),
                    Arrays.asList(m.getContactName()), // list with one item
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        save();

    }

    public static void deleteContact() {
        System.out.println("Who do you wanna delete");
        Scanner scanner = new Scanner(System.in);
        System.out.println(list.keySet());
        String deleteContact = scanner.next();
//        for (int i = 0; i < numbers.size(); i++){
//            numbers.remove(deleteContact + 1);
//            numbers.remove(deleteContact);
//
//
//
//
//        }
//        if (numbers.contains(deleteContact)) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i).equals(deleteContact)) {
                    numbers.remove(i + 1);
//                numbers.remove(deleteContact);
//                numbers.remove(deleteContact);
                    numbers.remove(i);


//                    System.out.println(deleteContact + " is removed");
//                    list.remove(deleteContact);
                    //numbers.remove(deleteContact);
                    save();
                    return;
                }
            }
        System.out.println("that person doesnt exist");
    }

    public static void searchContacts() {
        System.out.println("Who do you wanna search for?");
        Scanner scanner = new Scanner(System.in);
        System.out.println(list.keySet());
        String searchContact = scanner.next();
        if (list.containsKey(searchContact)) {
            System.out.println(list.get(searchContact));
        } else {
            System.out.println("No number for that name");
        }
    }


//    public static void meep() {
//        List<String> chicken = new ArrayList<>();
//        for (String n : list.keySet()) {
//            chicken.add(n);
//            System.out.println(n);
//      } System.out.println(chicken);
//
//        }

        public static void save(){
            String contactsFolder = "data";
            String contactFile = "test.txt";
//            Path Files.write(Path filepath, List<String> lines[, StandardOpenOption option])
            Path filepath = Paths.get("data", "test.txt.txt");
            try {
                Files.write(filepath, numbers);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void add() {
            try {
                Files.write(
                        Paths.get("data", "test.txt.txt"),
                        Arrays.asList(), // list with one item
                        StandardOpenOption.APPEND
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

//    @Override
//    public String toString() {
//        return String.format(" %s", list.keySet().toString());
//    }
    }
//}
