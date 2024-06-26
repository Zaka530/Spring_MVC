package uz.kamron.springcourse.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import uz.kamron.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person>people;
    {
        people=new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Kamron"));
        people.add(new Person(++PEOPLE_COUNT,"Tom"));
        people.add(new Person(++PEOPLE_COUNT,"Bob"));
        people.add(new Person(++PEOPLE_COUNT,"Mike"));
    }
    public List<Person>index(){

        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
