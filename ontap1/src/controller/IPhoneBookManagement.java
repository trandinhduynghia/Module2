package controller;

import model.Person;

import java.io.IOException;
import java.util.List;

public interface IPhoneBookManagement extends GeneralManagement<Person> {
    int findPersonByPhoneNumber(String phoneNumber);
    int findPersonByName(String name);
    void writeToFiles(Person person) ;
    List<String> readFiles() ;
}
