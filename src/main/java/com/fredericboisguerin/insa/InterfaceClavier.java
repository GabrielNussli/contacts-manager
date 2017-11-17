package com.fredericboisguerin.insa;
import java.util.*;

public class InterfaceClavier {
    private static Scanner Sc = new Scanner(System.in);
    private static ContactsManager c = new ContactsManager();

    public static void main(String[] args) {
        while (true) {
            String cmd = Sc.next();
            System.out.println(cmd);
            if (cmd.equals("add")) {
                String nom = Sc.next();
                String email = Sc.next();
                String phone = Sc.next();;
                try {
                    c.addContact(nom, email, phone);
                } catch (InvalidContactNameException | InvalidEmailException f) {
                }
            }
            if (cmd.matches("print")) {
                c.printAllContacts();
            }
        }
    }
}