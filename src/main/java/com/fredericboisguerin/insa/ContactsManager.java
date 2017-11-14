package com.fredericboisguerin.insa;
import java.util.*;

public class ContactsManager {
    ArrayList<Contact> listContact = new ArrayList<Contact>();
    public void addContact(String name, String email, String phoneNumber) {
        listContact.add(new Contact(name,email,phoneNumber));
    }

    public void printAllContacts() {
        for (Contact contact:listContact) {
            System.out.println(contact);
        }

    }

    public void searchContactByName(String name) {
        for (Contact contact:listContact) {
            if(contact.name.toLowerCase().contains(name)){
                System.out.println(contact);
            }

        }
    }
}
