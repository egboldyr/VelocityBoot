package ws.service;

import ws.entity.Contact;

public interface ContactService {

    Long create(Contact contact);

    Contact read(Long id);

    boolean update(Contact contact);

    boolean delete(Contact contact);

    Contact[] findAll();
}
