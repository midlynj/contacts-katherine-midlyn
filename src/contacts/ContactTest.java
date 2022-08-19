package contacts;

import java.util.HashMap;
import java.util.Scanner;

public class ContactTest {

    public static final int INVALID_CHOICE = -1;
    public static final int EXIT_CHOICE = 5;
    static HashMap<String, String> list = new HashMap<>();

    public static void main(String[] args) {

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
        System.out.println(list.keySet());
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
    }

    public static void deleteContact() {
        System.out.println("Who do you wanna delete");
        Scanner scanner = new Scanner(System.in);
        System.out.println(list.keySet());
        String deleteContact = scanner.next();
        if (list.containsKey(deleteContact)) {
            System.out.println(deleteContact + " is removed");
            list.remove(deleteContact);
        } else {
            System.out.println("Contact does not exist");
        }
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
}
