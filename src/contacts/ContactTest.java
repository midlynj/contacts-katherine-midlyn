package contacts;

import java.util.HashMap;

public class ContactTest {

    public static final int INVALID_CHOICE = -1;
    public static final int EXIT_CHOICE = 5;

    public static void main(String[] args) {

        Input input = new Input();


        int choice = INVALID_CHOICE;
        while(choice != EXIT_CHOICE) {
            showMenu();

            choice = input.getInt(0, 5);

            userMenuoption(choice);

        }

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
        HashMap<String,String> list = new HashMap<>();
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

    public static void addContact(Contacts a) {

    }
}
