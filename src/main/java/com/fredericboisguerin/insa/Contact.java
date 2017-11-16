package com.fredericboisguerin.insa;
import java.util.*;
import java.util.regex.Pattern;

public class Contact {
    String name;
    String email;
    String phoneNumber;

    public Contact(String name, String email, String phoneNumber) throws InvalidContactNameException, InvalidEmailException {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        if (name == null)
            throw new InvalidContactNameException();
        if (name == "")
            throw new InvalidContactNameException();
        if (email != null) {
            Pattern pattern;
            pattern = Pattern.compile("@[a-z]+\\..[a-z]+");
            java.util.regex.Matcher matcher;
            matcher = pattern.matcher(email);

        if (!(matcher.find()))
            throw new InvalidEmailException();
        }
    }

    @Override
    public String toString() {
        if (email==null)
            return
                    name +", "+ phoneNumber ;
        if (phoneNumber==null)
            return name +", "+ email ;
        else
            return
                name +", "+ email+", " + phoneNumber ;
    }
}
