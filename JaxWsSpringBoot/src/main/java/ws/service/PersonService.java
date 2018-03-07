package ws.service;

import ws.entity.Person;

/**
 * Created by EGBoldyr on 07.03.18.
 */
public interface PersonService {

    boolean add(Person person);

    Person get(Long id);

    Person[] getAllPersons();

}
