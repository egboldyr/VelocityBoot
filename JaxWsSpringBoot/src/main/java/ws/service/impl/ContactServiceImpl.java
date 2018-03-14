package ws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ws.dao.ContactDAO;
import ws.entity.Contact;
import ws.service.ContactService;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"contactCache"})
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO dao;

    @Override
    @CacheEvict(allEntries = true)
    public Long create(Contact contact) {
        if (contact != null) {
            return dao.create(contact);
        }
        return null;
    }

    @Override
    @Cacheable
    public Contact read(Long id) {
        if (id != null) {
            return dao.read(id);
        }
        return null;
    }

    @Override
    @CacheEvict(allEntries = true)
    public boolean update(Contact contact) {
        if (contact == null) {
            return false;
        }
        dao.update(contact);
        return true;
    }

    @Override
    @CacheEvict(allEntries = true)
    public boolean delete(Contact contact) {
        if (contact == null) {
            return false;
        }
        dao.delete(contact);
        return true;
    }

    @Override
    @Cacheable
    public Contact[] findAll() {
        List<Contact> contacts =  dao.findAll();
        Contact[] result = new Contact[contacts.size()];
        for (int i = 0; i < contacts.size(); i++) {
            result[i] = contacts.get(i);
        }
        return result;
    }
}
