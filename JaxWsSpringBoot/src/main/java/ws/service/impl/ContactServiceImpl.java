package ws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
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
    public Long create(Contact contact) {
        if (contact != null) {
            return dao.create(contact);
        }
        return null;
    }

    @Override
    @Cacheable(value = "contactCache", key = "#id")
    public Contact read(Long id) {
        if (id != null) {
            return dao.read(id);
        }
        return null;
    }

    @Override
    @CacheEvict(cacheNames = "contactCache", key = "#p0.id")
    public boolean update(Contact contact) {
        if (contact == null) {
            return false;
        }
        dao.update(contact);
        return true;
    }

    @Override
    @CacheEvict(cacheNames = "contactCache", key = "#p0.id")
    public boolean delete(Contact contact) {
        if (contact == null) {
            return false;
        }
        dao.delete(contact);
        return true;
    }

    @Override
    public Contact[] findAll() {
        List<Contact> contacts =  dao.findAll();
        Contact[] result = new Contact[contacts.size()];
        for (int i = 0; i < contacts.size(); i++) {
            result[i] = contacts.get(i);
        }
        return result;
    }
}
