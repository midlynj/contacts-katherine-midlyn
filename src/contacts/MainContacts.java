package contacts;

public class MainContacts {
    public static void main(String[] args) {
        Menu();

    }
    public  static void Menu(){
        System.out.println("""
                1. View contacts.
                2. Add a new contact.
                3. Search a contact by name.
                4. Delete an existing contact.
                5. Exit.
                Enter an option (1, 2, 3, 4 or 5):""");
    }
}
