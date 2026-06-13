import java.util.*;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class Directory {
    private Contact[] contacts;
    private int count;

    public Directory(int size) {
        contacts = new Contact[size];
        count = 0;
    }

    public void addContact(String name, String phone) {
        if (count < contacts.length) {
            contacts[count++] = new Contact(name, phone);
            System.out.println("Contact added successfully");
        } else {
            System.out.println("Directory is full");
        }
    }

    public void searchContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Name: " + contacts[i].getName());
                System.out.println("Phone: " + contacts[i].getPhoneNumber());
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public void deleteContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {

                for (int j = i; j < count - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }

                count--;
                System.out.println("Contact deleted successfully");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public void displayContacts() {
        if (count == 0) {
            System.out.println("No contacts available");
            return;
        }

        System.out.println("All Contacts:");
        for (int i = 0; i < count; i++) {
            System.out.println(
                contacts[i].getName() + " - " +
                contacts[i].getPhoneNumber()
            );
        }
    }
}

public class project {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Directory directory = new Directory(100);

        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    directory.addContact(name, phone);
                    break;

                case 2:
                    System.out.print("Enter Name to Search: ");
                    name = sc.nextLine();

                    directory.searchContact(name);
                    break;

                case 3:
                    System.out.print("Enter Name to Delete: ");
                    name = sc.nextLine();

                    directory.deleteContact(name);
                    break;

                case 4:
                    directory.displayContacts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
