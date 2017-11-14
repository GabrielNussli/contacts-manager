package com.fredericboisguerin.insa;

public class Contact {
    String name;
    String email;
    String phoneNumber;

    public Contact(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
