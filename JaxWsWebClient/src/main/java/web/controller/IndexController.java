package web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import web.jaxws.Contact;
import web.jaxws.ContactWS;
import web.jaxws.ContactWebService;


@Controller
public class IndexController {

    private static final String URL_INDEX = "/";
    private static final String URL_NEW_CONTACT = "/new_contact";

    private ContactWS contactWS = new ContactWS();

    @RequestMapping(value = URL_INDEX, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = URL_NEW_CONTACT, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void newContact(
            @RequestParam("name")    String name,
            @RequestParam("surname") String surname,
            @RequestParam("phone")   String phone,
            @RequestParam("email")   String email) {

        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        contact.setEmail(email);

        ContactWebService ws = contactWS.getContactWSPort();
        ws.create(contact);
    }
}
