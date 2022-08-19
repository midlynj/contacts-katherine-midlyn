package contacts;

import java.util.HashMap;
import java.util.Scanner;

public class ContactTest {

    public static final int INVALID_CHOICE = -1;
    public static final int EXIT_CHOICE = 5;
    static HashMap<String,String> list = new HashMap<>();
    public static void main(String[] args) {

        Input input = new Input();


        int choice = INVALID_CHOICE;
        while(choice != EXIT_CHOICE) {
            showMenu();

            choice = input.getInt(0, 5);

            userMenuoption(choice);

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

        Contacts joey = new Contacts("Joey","123");
        Contacts katara = new Contacts("Katara","456");
        Contacts kairo = new Contacts("Kairo", "789");
        list.put(joey.getContactName(), joey.getPhoneNumber());
        list.put(katara.getContactName(), katara.getPhoneNumber());
        list.put(kairo.getContactName(), kairo.getPhoneNumber());
        System.out.println(list.keySet());
    }

    public static void userMenuoption(int userPick) {
        switch(userPick) {
            case 1:
                showContactList();
                break;
            case 2:
                // TODO: view movies in the musical category
                addContact();
                break;
            case 3:
                // TODO: view movies in the drama category

//                dramaCategory();
                break;
            case 4:
                // TODO: view movies in the horror category
//                horrorCategory();

                break;
            case 5:
                // TODO: view movies in the scifi category
//                scifiCategory();

                break;
        }
    }

    public static void addContact() {
        System.out.println("Enter name");
        Scanner scanner = new Scanner(System.in);
        String addName = scanner.next();
        scanner.next();
        System.out.println("Enter number");
        String addNumber = scanner.next();
        Contacts m = new Contacts(addName,addNumber);
        list.put(m.getContactName(),m.getPhoneNumber());
        System.out.println(list);

    }

    public static void deleteContact() {
        System.out.println("Who do you wanna delete");
        Scanner scanner = new Scanner(System.in);
        String deleteContact = scanner.next();

    }
}
