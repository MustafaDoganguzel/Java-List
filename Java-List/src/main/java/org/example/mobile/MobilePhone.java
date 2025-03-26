package org.example.mobile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts = new ArrayList<>();


    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myContacts = myContacts;
        this.myNumber = myNumber;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (!myContacts.contains(contact)) {
            myContacts.add(contact);
            return true;
        } else {
            System.out.println(contact + " rehberde mevcut");
            return false;
        }
    }

    public boolean updateContact(Contact oldOne, Contact newOne) {
        int index = myContacts.indexOf(oldOne);
        if (index >= 0) { // Eğer listede varsa
            myContacts.set(index, newOne);
            return true;
        } else {
            System.out.println(oldOne + " listede mevcut değil!");
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        if (myContacts.contains(contact)) {
            myContacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact); // contact var ise x degerine atanir
    }


    public int findContact(String str) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals(str)) {
                return myContacts.indexOf(contact);
            }

            }
            return -1;
        }

    public Contact queryContact(String name){
        for (Contact contact : myContacts){
            if(contact.getName().equals(name)){
                return contact;
            }
        }
        return null;
    }
}

