package ws.dao;

import ws.entity.Contact;

import java.util.List;

public interface ContactDAO {

    Long create(Contact contact);

    Contact read(Long id);

    boolean update(Contact contact);

    boolean delete(Contact contact);

    List<Contact> findAll();

}
