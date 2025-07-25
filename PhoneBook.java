import java.io.*;
import java.util.*;

class Contact implements Serializable {
    private String name;
    private String phone;
    private String email;
    private String address;

    public Contact(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }

    public boolean hasSameAddress(Contact other) {
        return this.address.equals(other.getAddress());
    }

    @Override
    public String toString() {
        return name + " | " + phone + " | " + email + " | " + address;
    }
}

class AddressBook<T extends Contact> {
    private HashMap<String, T> contacts = new HashMap<>();

    public void addContact(T contact) {
        contacts.put(contact.getPhone(), contact);
    }

    public void removeContactByPhone(String phone) {
        contacts.remove(phone);
    }

    public T searchByName(String name) {
        for (T contact : contacts.values()) {
            if (contact.getName().equalsIgnoreCase(name)) return contact;
        }
        return null;
    }

    public T searchByPhone(String phone) {
        return contacts.get(phone);
    }

    public List<T> listAll() {
        return new ArrayList<>(contacts.values());
    }

    public void saveToFile(String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(contacts);
        oos.close();
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        contacts = (HashMap<String, T>) ois.readObject();
        ois.close();
    }

    public List<T> sortByName() {
        List<T> list = listAll();
        list.sort(Comparator.comparing(Contact::getName));
        return list;
    }

    public List<T> sortByPhone() {
        List<T> list = listAll();
        list.sort(Comparator.comparing(Contact::getPhone));
        return list;
    }

    public boolean hasSameAddress(String phone1, String phone2) {
        T c1 = contacts.get(phone1);
        T c2 = contacts.get(phone2);
        return c1 != null && c2 != null && c1.hasSameAddress(c2);
    }
}

public class PhoneBook {
    public static void main(String[] args) throws Exception {
        AddressBook<Contact> book = new AddressBook<>();
        Contact c1 = new Contact("Alice", "123", "alice@mail.com", "123 Lane");
        Contact c2 = new Contact("Bob", "456", "bob@mail.com", "456 Lane");
        Contact c3 = new Contact("Charlie", "789", "charlie@mail.com", "123 Lane");

        book.addContact(c1);
        book.addContact(c2);
        book.addContact(c3);

        book.saveToFile("contacts.dat");
        book.loadFromFile("contacts.dat");

        System.out.println("Search by name: " + book.searchByName("Alice"));
        System.out.println("Search by phone: " + book.searchByPhone("456"));
        System.out.println("Sorted by name: " + book.sortByName());
        System.out.println("Sorted by phone: " + book.sortByPhone());
        System.out.println("Has same address (Alice & Charlie): " + book.hasSameAddress("123", "789"));
    }
}
