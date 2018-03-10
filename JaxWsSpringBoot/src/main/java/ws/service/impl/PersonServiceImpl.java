package ws.service.impl;

import org.springframework.stereotype.Service;
import ws.entity.Person;
import ws.service.PersonService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by EGBoldyr on 07.03.18.
 */

@Service
public class PersonServiceImpl implements PersonService {

    private static Map<Long, Person> people = new HashMap<Long, Person>();

    @Override
    public boolean add(Person person) {
        people.put(person.getId(), person);
        return true;
    }

    @Override
    public Person get(Long id) {
        return null;
    }

    @Override
    public Person[] getAllPersons() {
        Set<Long> ids = people.keySet();
        int i = 0;

        Person[] people = new Person[ids.size()];
        for (Long id : ids) {
            people[i++] = this.people.get(id);
        }

        return people;
    }

}
