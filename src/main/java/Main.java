import entity.Person;
import repository.Repository;
import service.Service;
import swing.LaunchPage;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();
        var personList = service.getPersonsFromJson();
        Repository repository = new Repository(personList);
        new LaunchPage(repository);


    }
}
