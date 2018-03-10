package ws.jaxws.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ws.entity.Contact;
import ws.jaxws.ContactWebService;
import ws.service.ContactService;

import javax.jws.WebService;

@Component
@WebService(serviceName = "ContactWS", portName = "ContactWSPort",
            endpointInterface = "ws.jaxws.ContactWebService")
public class ContactWSImpl implements ContactWebService {

    @Autowired
    private ContactService service;

    @Override
    public boolean create(Contact contact) {
        if (contact == null) {
            return false;
        }
        service.create(contact);
        return true;
    }

    @Override
    public Contact read(Long id) {
        if (id == null) {
            return null;
        }
        return service.read(id);
    }

    @Override
    public boolean update(Contact contact) {
        if (contact == null) {
            return false;
        }
        return service.update(contact);
    }

    @Override
    public boolean delete(Contact contact) {
        if (contact == null) {
            return false;
        }
        return service.delete(contact);
    }

    @Override
    public Contact[] findAll() {
        return service.findAll();
    }
}
