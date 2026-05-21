class Contact {

    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
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

        if (count == contacts.length) {
            System.out.println("Directory is full");
            return;
        }

        contacts[count++] = new Contact(name, phone);

        System.out.println("Contact added");
    }

    public void searchContact(String name) {

        for (int i = 0; i < count; i++) {

            if (contacts[i].getName().equalsIgnoreCase(name)) {

                System.out.println("Contact Found");
                System.out.println("Name: " + contacts[i].getName());
                System.out.println("Phone: " + contacts[i].getPhone());

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

                System.out.println("Contact deleted");

                return;
            }
        }

        System.out.println("Contact not found");
    }

    public void displayAll() {

        for (int i = 0; i < count; i++) {

            System.out.println("Name: " + contacts[i].getName());
            System.out.println("Phone: " + contacts[i].getPhone());

            System.out.println();
        }
    }
}

public class project {

    public static void main(String[] args) {

        Directory directory = new Directory(5);

        directory.addContact("Rahul", "9876543210");
        directory.addContact("Amit", "9123456780");
        System.out.println();
        directory.displayAll();
        directory.searchContact("rahul");
        System.out.println();
        directory.deleteContact("Amit");
        System.out.println();
        directory.displayAll();
    }
}