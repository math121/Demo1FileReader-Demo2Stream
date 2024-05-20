package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StreamData {

    private List<Person> people;

    public StreamData(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        people = objectMapper.readValue(new File(fileName), new TypeReference<>(){});
    }

    public List<Person> getPeopleByGender(String gender) {
        return people.stream().filter(person -> person.gender().equals(gender)).toList();
    }

    public List<Person> getPeopleByFavoriteColor(String color) {
        return people.stream().filter(person -> person.color().equals(color)).toList();
    }

    public List<String> getCatchPhrases() {
        return people.stream().map(Person::catchPhrase).toList();
    }

    public List<Person> getFirstNamesThatStartWithALetter(char letter) {
        return people.stream().filter(person -> person.firstName().charAt(0) == letter).toList();
    }
}
