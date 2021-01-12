package repository;

import entity.Person;

import java.util.List;

public class Repository {

    private List<Person> personList;

    public Repository(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> add(Person entity) {
        this.personList.add(entity);
        return personList;
    }

    public void delete(int index) {
        this.personList.remove(index);
    }

    public Person getPerson(int index) {
        return this.personList.get(index);
    }

    public void updatePerson(int index, String name, String surname, String address){
        this.personList.get(index).setName(name);
        this.personList.get(index).setSurname(surname);
        this.personList.get(index).setAddress(address);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "personList=" + personList +
                '}';
    }
}
