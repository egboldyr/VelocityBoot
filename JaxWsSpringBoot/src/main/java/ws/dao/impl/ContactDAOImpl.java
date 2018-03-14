package ws.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ws.dao.ContactDAO;
import ws.entity.Contact;

import java.util.List;

@Repository
@Transactional
public class ContactDAOImpl implements ContactDAO {

    private static final Logger logger = LoggerFactory.getLogger(ContactDAOImpl.class);

    @Autowired
    private SessionFactory factory;

    @Override
    @Caching(
        put = @CachePut(value = "contactCache", key = "#contact.id"),
        evict = @CacheEvict(value = "contactListCache", allEntries = true))
    public Long create(Contact contact) {
        logger.info("Creating contact [" + contact + "]");
        return (Long) factory.getCurrentSession().save(contact);
    }

    @Override
    @Cacheable(value = "contactCache", key = "#id")
    public Contact read(Long id) {
        logger.info("Get Contact by ID [" + id + "]");
        return factory.getCurrentSession().get(Contact.class, id);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "contactCache", key = "#contact.id"),
            @CacheEvict(value = "contactListCache", allEntries = true)
    })
    public boolean update(Contact contact) {
        try {
            logger.info("Updating Contact [" + contact + "]");
            factory.getCurrentSession().update(contact);
            logger.info("Updating SUCCESS.");
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            factory.getCurrentSession().getTransaction().rollback();
            logger.info("Updating FAIL.");
            return false;
        }
    }

    @Override
    @Caching(evict = {
           @CacheEvict(value = "contactCache", key = "#contact.id"),
           @CacheEvict(value = "contactListCache", allEntries = true)
    })
    public boolean delete(Contact contact) {
        try {
            logger.info("Deleting Contact [" + contact + "]");
            factory.getCurrentSession().delete(contact);
            logger.info("Deleting SUCCESS.");
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            factory.getCurrentSession().getTransaction().rollback();
            logger.info("Deleting FAIL.");
            return false;
        }
    }

    @Override
    @Cacheable(value = "contactListCache", sync = true)
    public List<Contact> findAll() {
        logger.info("Getting all Contact records...");
        return factory
                .getCurrentSession()
                .createCriteria(Contact.class)
                .list();
    }
}
