package service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import entity.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Service {

    public Service() {
    }

    public List<Person> getPersonsFromJson() {

        JSONParser parser = new JSONParser();
        Gson gson = new Gson();
        List<Person> personList = new ArrayList<>();

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("person.json"));

            for(Object object : jsonArray) {

                JSONObject jsonObject = (JSONObject) object;

                var person = gson.fromJson(jsonObject.toString(), Person.class);
                personList.add(person);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return personList;
    }

    public void writePersonsToJson(List<Person> personList) {

        Gson gson = new Gson();
        var json = gson.toJson(personList);
        System.out.println(json);

        try {
            FileWriter fileWriter = new FileWriter("person.json");
            fileWriter.write(json);
            fileWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}