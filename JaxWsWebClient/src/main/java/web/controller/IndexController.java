package web.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import web.jaxws.Contact;
import web.jaxws.ContactWS;
import web.jaxws.ContactWebService;

import java.util.List;

@Controller
public class IndexController {

    private static final String URL_INDEX = "/";
    private static final String URL_NEW_CONTACT = "/new_contact";
    private static final String URL_DELETE_CONTACT = "/delete_contact";
    private static final String URL_ALL_CONTACTS = "/all_contacts";

    private ContactWS contactWS = new ContactWS();
    private ContactWebService ws = contactWS.getContactWSPort();

    @RequestMapping(value = URL_INDEX, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = URL_NEW_CONTACT, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void newContact(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email) {

        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        contact.setEmail(email);

        ws.create(contact);
    }

    @RequestMapping(value = URL_DELETE_CONTACT, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteContact(@RequestParam("id") Long id) {
        ws.delete(ws.read(id));
    }

    @RequestMapping(value = URL_ALL_CONTACTS, method = RequestMethod.GET)
    public @ResponseBody String getAllContacts() {
        List<Contact> contacts = ws.findAll().getItem();
        JSONArray jsonArray = new JSONArray();
        for (Contact contact : contacts) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", contact.getId());
            jsonObj.put("name", contact.getName());
            jsonObj.put("surname", contact.getSurname());
            jsonObj.put("phone", contact.getPhone());
            jsonObj.put("email", contact.getEmail());
            jsonArray.add(jsonObj);
        }
        return jsonArray.toJSONString();
    }
}
