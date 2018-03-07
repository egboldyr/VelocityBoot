package wsclient;

import ws.entity.Person;
import ws.jaxws.PersonWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by EGBoldyr on 07.03.18.
 *
 * Тестовая работающая версия Console Client для проверки WSDL сервиса
 */

public class WSConsoleClientPeople {

    private static final String WSDL_PEOPLE_URL = "http://localhost:8090/services/peoples?wsdl";

    private static PersonWebService ws;

    public static void main(String[] args) throws MalformedURLException {
        URL wsdlPeople = new URL(WSDL_PEOPLE_URL);

        QName qSrv = new QName("http://impl.jaxws.ws/", "PeopleSrv");

        Service srv = Service.create(wsdlPeople, qSrv);

        ws = srv.getPort(PersonWebService.class);
        Person pers1 = new Person(1000L, "Ivan", "Ivanov", 25);
        Person pers2 = new Person(2000L, "Petr", "Petrov", 30);

        System.out.println("Person Addition status = " + ws.addPerson(pers1));
        System.out.println("Person Addition status = " + ws.addPerson(pers2));

        System.out.println(Arrays.asList(ws.getAllPersons()));

    }
}
