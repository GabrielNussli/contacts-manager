package colis.td2;
import java.io.*;
import java.util.*;

public class InterfaceClavier {
    private static Scanner Sc = new Scanner(System.in);
    private static ContactsManager c = new ContactsManager();

    public static void main(String[] args) {
        while (true) {
            String cmd = Sc.next();
            if (cmd.equals("open"))
                ouvrir_fichier(Sc.next());
            if (cmd.equals("add")) {
                System.out.println("add1");

                String nom = Sc.next();
                String email = Sc.next();
                String phone = Sc.next();;
                try {
                    c.addContact(nom, email, phone);
                } catch (InvalidContactNameException | InvalidEmailException f) {
                    System.out.println(f);

                }
            }
            if (cmd.matches("print")) {
                System.out.println("print1");

                c.printAllContacts();
            }
            if (cmd.matches("search")) {
                String nom =Sc.next();
                c.searchContactByName(nom);

            }

            if (cmd.matches("save")) {
                sauver_contacts(Sc.next());
            }

        }
    }

    public static void ouvrir_fichier(String chemin){
        String csvFile = chemin;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] contact = line.split(cvsSplitBy);

                c.addContact(contact[0],contact[1],contact[2]);

            }
        } catch(java.io.FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException | InvalidEmailException | InvalidContactNameException e) {
            e.printStackTrace();
        }finally{
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void sauver_contacts(String chemin){
        File csvFile = new File(chemin);
        try{
            PrintStream l_out = new PrintStream(new FileOutputStream(chemin));
        for (Contact contact:c.listContact) {
            l_out.print(contact);
            l_out.println();
            l_out.flush();

        }
            l_out.close();
            l_out=null;
        } catch (java.io.FileNotFoundException e){}
    }
}